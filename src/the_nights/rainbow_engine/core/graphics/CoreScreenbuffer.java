/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class CoreScreenbuffer implements IScreenBuffer {

    public boolean renderAlpha = true;
    public BufferedImage backgroundImage;
    public BufferedImage viewImage;
    public int[] viewPixels;
    public int[] bgPixels;
    public Rectangle camera;
    private final AffineTransform affinetransform = new AffineTransform();
    private final FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

    public CoreScreenbuffer(int width, int height) {
        //Create a BufferedImage that will represent our viewImage.
        viewImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        backgroundImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        //Create an array for viewPixels
        viewPixels = ((DataBufferInt) viewImage.getRaster().getDataBuffer()).getData();
        bgPixels = ((DataBufferInt) backgroundImage.getRaster().getDataBuffer()).getData();
        //Create Cammera;
        camera = new Rectangle(0, 0, width, height);
    }

//    public void renderRainbow(Graphics graphics) {
//        int spectrumSize = viewImage.getHeight() / 6;
//        int row = 0;
//        int colorIndex = 0;
//        int pixel = EngineColors.Red;
//        for (int indexH = 0; indexH < viewImage.getHeight(); indexH++) {
//
//            if (row == spectrumSize) {
//                switch (colorIndex) {
//                    case 0:
//                        pixel = EngineColors.Orange;
//                        break;
//                    case 1:
//                        pixel = EngineColors.Yellow;
//                        break;
//                    case 2:
//                        pixel = EngineColors.Green;
//                        break;
//                    case 3:
//                        pixel = EngineColors.Blue;
//                        break;
//                    case 4:
//                        pixel = EngineColors.Violet;
//                        break;
//                }
//                row = 0;
//                colorIndex++;
//            }
//
//            for (int indexW = 0; indexW < viewImage.getWidth(); indexW++) {
//                viewPixels[indexH * viewImage.getWidth() + indexW] = pixel;
//            }
//            row++;
//        }
//        graphics.drawImage(viewImage, 0, 0, viewImage.getWidth(), viewImage.getHeight(), null);
//    }
    @Override
    public void renderImage(BufferedImage image, int xPosition, int yPosition, boolean renderBackground) {
        renderImage(image, xPosition, yPosition, 1, 1, renderBackground);
    }

    @Override
    public void renderImage(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom, boolean renderBackground) {
        int[] imagePixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
        if (renderBackground) {
            renderBackgroundPixels(imagePixels, xPosition, yPosition, image.getWidth(), image.getHeight(), xZoom, yZoom);
        } else {
            renderPixels(imagePixels, xPosition, yPosition, image.getWidth(), image.getHeight(), xZoom, yZoom);
        }
    }
//    @Override
//    public void renderSprite(Sprite sprite, int xPosition, int yPosition, boolean renderBackground) {
//        renderSprite(sprite, xPosition, yPosition, 1, 1, renderBackground);
//    }
//
//    @Override
//    public void renderSprite(Sprite sprite, int xPosition, int yPosition, int xZoom, int yZoom, boolean renderBackground) {
//        if (renderBackground) {
//            renderBackgroundPixels(sprite.getPixels(), xPosition, yPosition, sprite.getWidth(), sprite.getHeight(), xZoom, yZoom);
//        } else {
//            renderPixels(sprite.getPixels(), xPosition, yPosition, sprite.getWidth(), sprite.getHeight(), xZoom, yZoom);
//        }
//    }

    @Override
    public void renderRectangle(Rectangle rec, boolean renderBackground) {
        renderRectangle(rec, 1, 1, renderBackground);
    }

    @Override
    public void renderRectangle(Rectangle rec, int xZoom, int yZoom, boolean renderBackground) {
        int[] recPixels = rec.getPixels();
        if (recPixels != null) {
            if (renderBackground) {
                renderBackgroundPixels(recPixels, rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight(), xZoom, yZoom);
            } else {
                renderPixels(recPixels, rec.getX(), rec.getY(), rec.getWidth(), rec.getHeight(), xZoom, yZoom);
            }
        }
    }

    @Override
    public void renderString(Text text, boolean renderBackground) {
        Graphics graphics;
        if (renderBackground) {
            graphics = this.backgroundImage.getGraphics();
        } else {
            graphics = viewImage.createGraphics();
        }
        graphics.setColor(text.getColor());
        graphics.setFont(new Font(text.getFont(), Font.PLAIN, text.getSize()));
        graphics.drawString(text.getText(), text.getxPosition(), text.getyPosition());
        graphics.dispose();
    }

    @Override
    public void renderString(String s, String fontName, int fontSize, int xPosition, int yPosition, boolean renderBackground) {
        Text t = new Text(s, fontSize, fontName, xPosition, yPosition);
        renderString(t, renderBackground);
    }

    @Override
    public void renderPixels(int[] renderPixels, int xPosition, int yPosition, int renderWidth, int renderHeight) {
        renderPixels(renderPixels, xPosition, yPosition, renderWidth, renderHeight, 1, 1);
    }

    @Override
    public void renderPixels(int[] renderPixels, int xPosition, int yPosition, int renderWidth, int renderHeight, int xZoom, int yZoom) {
        for (int y = 0; y < renderHeight; y++) {
            for (int x = 0; x < renderWidth; x++) {
                for (int xz = 0; xz < xZoom; xz++) {
                    for (int yz = 0; yz < yZoom; yz++) {
                        int pixelID = x + (y * renderWidth);
                        int pixel = renderPixels[pixelID];
                        int xi = ((x * xZoom) + xPosition + xz);
                        int yi = ((y * yZoom) + yPosition + yz);
                        setPixel(pixel, xi, yi);
                    }
                }
            }
        }
    }

    @Override
    public void setPixel(int pixel, int x, int y) {
        if (renderAlpha) {
            if (//pixel == ColorPallete.ALPHA_ARGB ||
                    pixel == ColorPallete.ALPHA_RGB) {
                return;
            }
        }
        if ((x >= camera.getX() && x < camera.getX() + camera.getWidth())
                && (y >= camera.getY() && y < camera.getY() + camera.getHeight())) {
            int pixelIndex = (x - camera.getX()) + (y - camera.getY()) * viewImage.getWidth();
            if (pixelIndex < viewPixels.length) {
                viewPixels[pixelIndex] = pixel;
            }
        }
    }

    @Override
    public void DrawView(Graphics graphics) {
        graphics.drawImage(viewImage, 0, 0, viewImage.getWidth(), viewImage.getHeight(), null);
    }

    @Override
    public void DrawView(Graphics graphics, int screenWidth, int screenHeight) {
        //System.out.println("W : "+screenWidth +" H "+ screenHeight);

        int zoomY = (screenHeight / viewImage.getHeight());
        int zoomX = (screenWidth / viewImage.getWidth());
        //System.out.println("Zoom X : "+ zoomX + " Y : "+zoomY);        

        int zoomFactor = 1;
        if (zoomX <= zoomY) {
            zoomFactor = zoomX;
        } else {
            zoomFactor = zoomY;
        }

        //System.out.println("Zoomfactor " +zoomFactor);  
        int xPosition = (screenWidth - (viewImage.getWidth() * zoomFactor)) / 2;
        int yPosition = (screenHeight - (viewImage.getHeight() * zoomFactor)) / 2;

        //System.out.println("xpos : "+ xPosition + "ypos : "+ yPosition);
        BufferedImage screen = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
        int[] screenPixels = ((DataBufferInt) screen.getRaster().getDataBuffer()).getData();
        int scanline = 5;
        int scan = 0;
        for (int y = 0; y < viewImage.getHeight(); y++) {
            for (int x = 0; x < viewImage.getWidth(); x++) {
                for (int yz = 0; yz < zoomFactor; yz++) {
                    if ((scan % scanline) != 0) {
                        for (int xz = 0; xz < zoomFactor; xz++) {
                            int pixel = viewPixels[x + (y * viewImage.getWidth())];
                            int xi = ((x * zoomFactor) + xPosition + xz);
                            int yi = ((y * zoomFactor) + yPosition + yz);
                            screenPixels[xi + (yi * screenWidth)] = pixel;
                        }
                    }
                    scan++;
                }
            }
        }
        graphics.drawImage(screen, 0, 0, screenWidth, screenHeight, null);
    }

    @Override
    public void renderBackgroundPixels(int[] renderPixels, int xPosition, int yPosition, int renderWidth, int renderHeight, int xZoom, int yZoom) {
        for (int y = 0; y < renderHeight; y++) {
            for (int x = 0; x < renderWidth; x++) {
                for (int xz = 0; xz < xZoom; xz++) {
                    for (int yz = 0; yz < yZoom; yz++) {
                        int pixelID = x + (y * renderWidth);
                        int pixel = renderPixels[pixelID];
                        int xi = ((x * xZoom) + xPosition + xz);
                        int yi = ((y * yZoom) + yPosition + yz);
                        setBackgroundPixel(pixel, xi, yi);
                    }
                }
            }
        }
    }

    @Override
    public void setBackgroundPixel(int pixel, int x, int y) {
        //if (pixel != ColorPallete.ALPHA_ARGB) {
        if (pixel != ColorPallete.ALPHA_RGB) {
            int pixelIndex = x + (y * backgroundImage.getWidth());
            if (pixelIndex < bgPixels.length) {
                bgPixels[pixelIndex] = pixel;
            }
        }
        //}
    }

    @Override
    public void setBackgroundSize(int width, int heigth) {
//        if (heigth < camera.getHeight()) {
//            heigth = camera.getHeight();
//        }
//        if (width < camera.getWidth()) {
//            width = camera.getWidth();
//        }
        backgroundImage = new BufferedImage(width, heigth, BufferedImage.TYPE_INT_ARGB);
        bgPixels = ((DataBufferInt) backgroundImage.getRaster().getDataBuffer()).getData();
    }

    @Override
    public void setRenderAlpha(boolean renderAlpha) {
        this.renderAlpha = renderAlpha;
    }

    @Override
    public boolean isRenderAlpha() {
        return renderAlpha;
    }

    @Override
    public Rectangle getCamara() {
        return camera;
    }

    @Override
    public BufferedImage getView() {
        return viewImage;
    }

    @Override
    public int[] getViewPixels() {
        return viewPixels;
    }

    @Override
    public void clear(boolean renderbackground) {
        if (renderbackground) {
            renderImage(backgroundImage, 0, 0, false);

//            for (int y = 0; y < backgroundImage.getHeight() && y< camera.getHeight(); y++) {
//                for (int x = 0; x < backgroundImage.getWidth() && x< camera.getWidth(); x++) {
//                    int bgpID = camera.getX() + (camera.getY() * camera.getWidth());
//                    if (bgpID < bgPixels.length) {
//                        int pixel = bgPixels[bgpID];
//                        viewPixels[x + (y * viewImage.getWidth())] = pixel;
//                    } else {
//                        System.out.println("bgpID are out of range og bgImage");
//                    }
//                }
//            }
        } else {
            for (int i = 0; i < viewPixels.length; i++) {
                viewPixels[i] = 0;
            }
        }
    }

    @Override
    public BufferedImage getBufferImage() {
        return viewImage;
    }

    @Override
    public int calculateTextSize(Text text) {
        Font font = new Font(text.getFont(), Font.PLAIN, text.getSize());
        return (int) (font.getStringBounds(text.getText(), frc).getWidth());
    }
}

//    ---- ----- OLD SHIT ------------
//    @Deprecated
//    private int convertPixel(int pixel) {
//        int ConvertedPixel = 0;
//        Color pColor = new Color(pixel);
//        double distance = -1;
//        for (int i = 0; i < EngineColors.ColorCodes.length; i++) {
//            Color cColor = new Color(EngineColors.ColorCodes[i]);
//            double r = calcColorDistanse(pColor, cColor);
//            if (r < distance || distance == -1) {
//                distance = r;
//                ConvertedPixel = EngineColors.ColorCodes[i];
//            }
//        }
//        return ConvertedPixel;
//    }
//
//    @Deprecated
//    private double calcColorDistanse(Color origanal, Color convertion) {
//
//// FAILED MOST        
////        double distance = (origanal.getRed() - convertion.getRed())*(origanal.getRed() - convertion.getRed()) +
////                                    (origanal.getGreen() - convertion.getGreen())*(origanal.getGreen() -convertion.getGreen()) + 
////                                    (origanal.getBlue()-convertion.getBlue())*(origanal.getBlue() - convertion.getBlue());
//// FAILED FEVER        
////        double distance = (Math.pow(30*(origanal.getRed() - convertion.getRed()),2) +
////                          Math.pow(59*(origanal.getGreen() - convertion.getGreen()),2) + 
////                          Math.pow(11*(origanal.getBlue()- convertion.getBlue()),2));
//        float[] hsb = Color.RGBtoHSB(convertion.getRed(), convertion.getGreen(), convertion.getBlue(), null);
//        float H0 = hsb[0];
//        float S0 = hsb[1];
//        float V0 = hsb[2];
//
//        double X0 = Math.cos(H0) * S0 * V0;
//        double Y0 = Math.sin(H0) * S0 * V0;
//        double Z0 = V0;
//
//        hsb = Color.RGBtoHSB(origanal.getRed(), origanal.getGreen(), origanal.getBlue(), null);
//        double H1 = hsb[0];
//        double S1 = hsb[1];
//        double V1 = hsb[2];
//
//        double X1 = Math.cos(H1) * S1 * V1;
//        double Y1 = Math.sin(H1) * S1 * V1;
//        double Z1 = V1;
//
//        //For both points and then taking the Euclidian distance between them:
//        //double distance = Math.sqrt((X0 - X1) * (X0 - X1) + (Y0 - Y1) * (Y0 - Y1) + (Z0 - Z1) * (Z0 - Z1));
//        double A = S0 * V0;
//        double B = S1 * V1;
//        double dTheta = H1 - H0;
//        double dZ = V0 - V1;
//        double distance = Math.sqrt(dZ * dZ + A * A + B * B + 2 * A * B * Math.cos(dTheta));
//
//        return distance;
//    }
//}

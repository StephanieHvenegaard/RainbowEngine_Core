/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.interfaces;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import the_nights.rainbow_engine.core.graphics.Rectangle;
import the_nights.rainbow_engine.core.graphics.Text;
import the_nights.rainbow_engine.core.graphics.pallates.BasePalette;
/**
 *
 * @author Stephanie
 */
public interface IScreenBuffer {

    public void renderImage(BufferedImage image, int xPosition, int yPosition);
    
    public void renderSprite(ISprite sprite, int xPosition, int yPosition);
    
    public void renderRectangle(Rectangle rec);
    
    public void renderString(Text text);

    public void renderPixels(int[] renderPixels, int xPosition, int yPosition, int renderWidth, int renderHeight);

    public void setPixel(int pixel, int x, int y);   

    public void DrawView(Graphics graphics, int screenWidth, int screenHeight);

    public void clear();  
    
    public BasePalette getPallete();
    
    public void setPallete(BasePalette pallete);

    //public void renderRectangle(Rectangle rec, int xZoom, int yZoom);
   
    //public void renderImage(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom);

    //public void renderSprite(ISprite sprite, int xPosition, int yPosition, int xZoom, int yZoom);
    
    //public void renderString(String s, String fontName, int fontSize, int xPosition, int yPosition);

    //public void renderBackgroundPixels(int[] renderPixels, int xPosition, int yPosition, int renderWidth, int renderHeight, int xZoom, int yZoom);

    //public void setBackgroundPixel(int pixel, int x, int y);

    //public void setBackgroundSize(int width, int heigth);

    //public void renderPixels(int[] renderPixels, int xPosition, int yPosition, int renderWidth, int renderHeight, int xZoom, int yZoom);

    //public void setRenderAlpha(boolean renderAlpha);
    
    //public boolean isRenderAlpha();

    //public void DrawView(Graphics graphics);
    
    //public Rectangle getCamara();

    //public BufferedImage getView();

    //public int[] getViewPixels();
    
    //public int calculateTextSize(Text text);
    
    //public BufferedImage getBufferImage();
}

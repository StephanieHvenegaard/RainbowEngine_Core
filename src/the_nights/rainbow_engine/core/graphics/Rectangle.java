/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.graphics;


/**
 *
 * @author Stephanie
 */
public class Rectangle {

    private int x;
    private int y;
    private int width;
    private int height;
    private int[] pixels;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.pixels = new int[width * height];
        for (int iy = 0; iy < height; iy++) {
            for (int ix = 0; ix < width; ix++) {
                pixels[ix + (iy * width)] = ColorPallete.ALPHA_RGB;
            }
        }
    }

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public void generateGrafics(int color) {
        //pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[x + y * width] = color;
            }
        }
    }

    //TODO
    public void generateBorderGrafics(int color) {
        //pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if ((y == 0 || y == height - 1) || (x == 0 || x == width - 1)) {
                    pixels[x + y * width] = color;
                } 
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPixels() {
        if (pixels != null) {
            return pixels;
        } else {
            System.out.println("no Grafics for rectagle");
            return null;
        }
    }

    public boolean Overlap(Rectangle other) {
        if (other.x >= this.x && other.x <= (this.x + this.width)
        && (other.y >= this.y && other.y <= (this.y + this.height))) {
            return true;
        }else if(this.x >= other.x && this.x <= (other.x + other.width)
             && (this.y >= other.y && this.y <= (other.y + other.height)))
        {
            return true;
        }
        else {
            return false;
        }
    }
}

//        int px = other.getX();
//        int py = other.getY();
//        int cornerx = this.x-(this.width/2);
//        int cornery = this.y+(this.height/2);
//        int endx = cornerx + this.width;
//        int endy = cornery - this.height;
//        if(px >cornerx & px < endx)
//        {
//            if(py >cornery && py < endy)
//            {
//                return true;
//            }
//        }        
//        return false;        
//        // If one rectangle is on left side of other
//        if (this.x > (other.x+other.width) || other.x > (this.x+this.width)) {
//            return false;
//        }
//        // If one rectangle is above other
//        if (this.y < (other.y+other.height)|| other.y < (this.y+this.height)) {
//            return false;
//        }
//        return true;

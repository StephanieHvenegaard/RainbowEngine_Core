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
public class ColorPallete {
    //public static int ALPHA_ARGB= 0xFFFF00DD;
    public static int ALPHA_RGB = 0xFF00DD;  
    private int[] colors;
    private ColorMode colormode;
    public static ColorPallete loadPallete()
    {
        return new ColorPallete();
    }
    public int getColor(int id)
    {
        if(id == -1)
            return ALPHA_RGB;
        return 0;
    }    
}    
//    public static final int COLOR_MODE_8=0;
//    public static final int COLOR_MODE_16=1;
//    public static final int COLOR_MODE_24=3;
//    public static final int COLOR_MODE_32=4;
//    public static final int COLOR_MODE_256=5;
//    private int colorMode;
//    private int[] colors;
//    public ColorPallete()
//    {
//        this.colorMode = COLOR_MODE_16;
//        this.colors = new int[8+(colorMode*8)+1];
//        this.colors[0]= 0xFF00DD;
//        this.colors[1]= 0x000000;
//        this.colors[2]= 0xFFFFFF;
//        this.colors[3]= 0x880000;
//        this.colors[4]= 0xAAFFEE;
//        this.colors[5]= 0xCC44CC;
//        this.colors[6]= 0x00CC55;
//        this.colors[7]= 0x0000AA;
//        this.colors[8]= 0xEEEE77;
//        this.colors[9]= 0xDD8855;
//        this.colors[10]= 0x664400;
//        this.colors[11]= 0x333333;
//        this.colors[12]= 0x777777;
//        this.colors[13]= 0xFF7777;
//        this.colors[14]= 0xAAFF66;
//        this.colors[15]= 0x0088FF;
//        this.colors[16]= 0xBBBBBB;        
//    }
//    public int getColor(int id)
//    {
//        if(id < colors.length)
//        {
//            return colors[id];
//        }
//        return -1;
//    }
//    public int[] getColors() {
//        return colors;
//    }    


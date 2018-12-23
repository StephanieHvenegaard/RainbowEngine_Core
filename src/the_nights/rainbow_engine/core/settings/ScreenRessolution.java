/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.settings;

/**
 *
 * @author Stephanie
 */
public enum ScreenRessolution {
    CGA("320x200", 0, 320, 200), VGA("640x480", 1, 640, 480), HD720("1280x720", 2, 1280, 720);
    public final String res; //representation of direction. 
    public final int index;
    public final int width;
    public final int heigth;

    private ScreenRessolution(String ressolution, int index, int width, int heigth) {
        this.res = ressolution;
        this.index = index;
        this.width = width;
        this.heigth = heigth;
    }

    public static ScreenRessolution fromId(int id) {
        for (ScreenRessolution res : values()) {
            if (res.index == id) {
                return res;
            }
        }
        return null;
    }
};

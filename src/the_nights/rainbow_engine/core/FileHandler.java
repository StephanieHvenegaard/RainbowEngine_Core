/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import the_nights.rainbow_engine.core.logging.RELogger;

/**
 *
 * @author Stephanie
 */
public class FileHandler {    
    public static BufferedImage loadImage(String path) {
        try {
            BufferedImage loaded = ImageIO.read(loadFile(path));
            BufferedImage formatted = new BufferedImage(loaded.getWidth(), loaded.getHeight(), BufferedImage.TYPE_INT_RGB);
            formatted.getGraphics().drawImage(loaded, 0, 0, null);
            return formatted;
        } catch (IOException e) {
            RELogger.writelog(e.getMessage(), "FileHandler");
            return null;
        }
    }
    public static File loadFile(String path) {
        File loaded = null;
        try {
            loaded = new File(path);
        } catch (Exception e) {
            RELogger.writelog(e.getMessage(), "FileHandler");
        }
        return loaded;
    }
}

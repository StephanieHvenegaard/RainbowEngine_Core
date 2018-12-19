/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import the_nights.rainbow_engine.core.Engine;
import the_nights.rainbow_engine.core.logging.RELogger;

/**
 *
 * @author Stephanie
 */
public class SplashScreen extends JFrame {

    public SplashScreen() {
        setUndecorated(true);
        //setSize(640,400);
        //this.setBackground(new Color(0,0,0,0));
        ImageCanvas ic = new ImageCanvas();
        //ic.setBackground(new Color(0,0,0,0));
        add(ic);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class ImageCanvas extends Canvas {

    private BufferedImage img;

    public ImageCanvas() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/splash/splash_bg.png"));
            //img = ImageIO.read(new File("art/splash/splash_bg.png"));
        } catch (IOException ex) {
            RELogger.writelog(ex.getMessage(), this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return img == null ? new Dimension(200, 200) : new Dimension(img.getWidth(), img.getHeight());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (img != null) {
            int x = (getWidth() - img.getWidth()) / 2;
            int y = (getHeight() - img.getHeight()) / 2;
            g.drawImage(img, x, y, this);
        }
    }

}

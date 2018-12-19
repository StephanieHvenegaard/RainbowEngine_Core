package the_nights.rainbow_engine.core.listner;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import the_nights.rainbow_engine.core.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stephanie
 */
public class MouseEventListner implements MouseListener,MouseMotionListener{
    private final Engine engine;
    public MouseEventListner(Engine engine)
    {
        this.engine = engine;
    }
    @Override        
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse was clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Mouse was Pressed");
        //if(e.getButton() == MouseEvent.BUTTON1)
            //engine.leftClick(e.getX(),e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Mouse was Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Mouse was Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("Mouse was Exited");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    
    }
}

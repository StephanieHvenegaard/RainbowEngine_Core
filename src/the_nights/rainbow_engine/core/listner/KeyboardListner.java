/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.listner;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import the_nights.rainbow_engine.core.Engine;

/**
 *
 * @author Stephanie
 */
public class KeyboardListner implements KeyListener, FocusListener {

    private boolean[] keys = new boolean[210];
    private Engine engine;

    public KeyboardListner(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("key : " + e.getKeyChar() + " with code : " + e.getKeyCode() + " was pressed.");
        int keyCode = e.getKeyCode();
        if (keyCode < keys.length) {
            keys[keyCode] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //System.out.println("key : " + e.getKeyChar() + " with code : " + e.getKeyCode() + " was released.");
        int keyCode = e.getKeyCode();
        if (keyCode < keys.length) {
            keys[keyCode] = false;
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
        for (int i = 0; i < keys.length; i++) {
            keys[i] = false;
        }
    }

    public boolean checkKey(int key) {
        return keys[key];
    }

    public boolean anyKey() {
        for (boolean b : keys) {
            if (b) {
                return true;
            }
        }
        return false;
    }

    public boolean enter() {
        return keys[KeyEvent.VK_ENTER];
    }

    public boolean esc() {
        return keys[KeyEvent.VK_ESCAPE];
    }

    public boolean up() {
        return keys[KeyEvent.VK_UP];
    }

    public boolean down() {
        return keys[KeyEvent.VK_DOWN];
    }

    public boolean left() {
        return keys[KeyEvent.VK_LEFT];
    }

    public boolean right() {
        return keys[KeyEvent.VK_RIGHT];
    }

    public boolean w() {
        return keys[KeyEvent.VK_W];
    }

    public boolean s() {
        return keys[KeyEvent.VK_S];
    }

    public boolean a() {
        return keys[KeyEvent.VK_A];
    }

    public boolean d() {
        return keys[KeyEvent.VK_D];
    }

}

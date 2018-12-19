/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.graphics;

import java.awt.Color;

/**
 *
 * @author Stephanie
 */
public class Text {

    private String text;
    private int size;
    private String Font;
    private int xPosition;
    private int yPosition;
    private Color color;

    public Text(String text, int size, String Font, Color color, int xPosition, int yPosition) {
        this.text = text;
        this.size = size;
        this.Font = Font;
        this.color = color;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    public Text(String text, int size, String Font, int xPosition, int yPosition) {
        this(text, size, Font, Color.WHITE, xPosition, yPosition);  
    }
    public Text(String text, int size, int xPosition, int yPosition) {
        this(text, size, "Consolas", Color.WHITE, xPosition, yPosition);
    }

    public Text(String text, Color color,int xPosition, int yPosition) {
        this(text, 12, "Consolas", color, xPosition, yPosition);
    }
    public Text(String text, int xPosition, int yPosition) {
        this(text, 12, "Consolas", Color.WHITE, xPosition, yPosition);
    }

    public String getText() {
        return text;
    }

    public int getSize() {
        return size;
    }

    public String getFont() {
        return Font;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public Color getColor() {
        return color;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFont(String Font) {
        this.Font = Font;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.interfaces;

import the_nights.rainbow_engine.core.Engine;
import the_nights.rainbow_engine.core.graphics.IScreenBuffer;

/**
 *
 * @author Stephanie
 */
public interface ICutscreen {
    public void render(IScreenBuffer screenBuffer, int xZoom,int yZoom);
    public void update(Engine engine);
    public int getCurrentFrame();
    public void setCurrentFrame();
    public boolean isOver();
}

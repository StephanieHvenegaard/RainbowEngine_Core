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
public interface IGame {
    public void update(Engine engine);
    public void render(IScreenBuffer screenbuffer);    
    public void loadAssets();
    public String getName();
    public String getVersionNumber();
    public void startGame(Engine engine);
    public void resetGame(Engine engine);
    public void pauseGame(Engine engine);
    public void esc(Engine engine);
    public void quitGame(Engine engine);
    public int countGameObjects();
}

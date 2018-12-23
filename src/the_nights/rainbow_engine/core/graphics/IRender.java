/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.graphics;
import the_nights.rainbow_engine.core.interfaces.ICoreObject;
/**
 *
 * @author Stephanie
 */
public interface IRender extends ICoreObject
{    
       public void render(IScreenBuffer screenBuffer, int xZoom,int yZoom);
}

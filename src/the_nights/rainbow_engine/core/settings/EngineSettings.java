/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.settings;

import the_nigths.rson.RSONObject;

/**
 *
 * @author Stephanie
 */
public class EngineSettings {
    public int desiredSpeed = 30;
    public boolean fullscreen = false;
    public boolean borderless = false;
    public ScreenRessolution resolution = ScreenRessolution.CGA;
    private RSONObject settings;

}

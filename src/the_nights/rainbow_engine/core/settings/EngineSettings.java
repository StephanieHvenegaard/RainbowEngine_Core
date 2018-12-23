/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.settings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import the_nights.rainbow_engine.core.logging.RELogger;
import the_nigths.rson.RSONObject;

/**
 *
 * @author Stephanie
 */
public class EngineSettings {

    private String path = "enginesettings.rson";
    public int desiredSpeed = 30;
    public boolean fullscreen = false;
    public boolean borderless = false;
    public ScreenRessolution resolution = ScreenRessolution.CGA;
    private RSONObject savefile;

    public EngineSettings() {
        try {
            savefile = RSONObject.parse(new File(path));
        } catch (FileNotFoundException ex) {
            savefile = new RSONObject();
            savefile.put("desiredSpeed", "30");
            savefile.put("fullscreen", "false");
            savefile.put("borderless", "false");
            savefile.put("resolution", ScreenRessolution.CGA.name());
            try {
                savefile.save(path);
            } catch (IOException ex1) {
                RELogger.writelog("failed to write settings file.", this);
                RELogger.writelog(ex1.getMessage(), this);
            }
        } catch (IllegalArgumentException ex) {
            RELogger.writelog("failed to read argument.", this);
            RELogger.writelog(ex.getMessage(), this);
        }
        this.desiredSpeed = Integer.getInteger(savefile.get("desiredSpeed"));
        this.borderless = Boolean.parseBoolean(savefile.get("fullscreen"));
        this.borderless = Boolean.parseBoolean(savefile.get("borderless"));
        this.resolution = ScreenRessolution.fromId(Integer.getInteger(savefile.get("resolution")));
    }

    public String get(String key) {
        return savefile.get(key);
    }

    public void put(String key, String value) {
        savefile.put(key, value);
    }
}

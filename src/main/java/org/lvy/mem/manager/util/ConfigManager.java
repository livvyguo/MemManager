package org.lvy.mem.manager.util;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by livvy on 15/8/24.
 */
public final class ConfigManager {
    private ConfigManager() {
        throw new AssertionError("no instance for you!");
    }

    private static final ResourceBundle CONFIG = ResourceBundle.getBundle("config");

//
//    private static PropertiesConfiguration CONFIGURATION = null;
//
//    static {
//        try {
//            CONFIGURATION = new PropertiesConfiguration("config");
//        } catch (ConfigurationException e) {
//            e.printStackTrace();
//        }
//    }

    public static final String getConfig(String key) {
        return CONFIG.getString(key);
    }
}

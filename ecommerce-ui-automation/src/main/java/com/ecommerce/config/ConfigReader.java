package com.ecommerce.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties config = new Properties();

    static {
        try(InputStream i = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (i != null) {
                config.load(i);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConfigReader() {}

    public static String get(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if(systemValue != null && !systemValue.isEmpty()) {
            return systemValue;
        }
        return config.getProperty(key, defaultValue);
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return Boolean.parseBoolean(get(key, Boolean.toString(defaultValue)));
    }
}

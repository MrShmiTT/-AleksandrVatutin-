package com.epam.tc.hw5.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    protected static FileInputStream fileInputStream;
    protected static Properties PROPERTIES;

    public ConfigProperties() {
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    static {
        try {
            fileInputStream = new FileInputStream("src/test/resources/com/epam/tc/hw5/config.properties");
            PROPERTIES = new Properties();
            PROPERTIES.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

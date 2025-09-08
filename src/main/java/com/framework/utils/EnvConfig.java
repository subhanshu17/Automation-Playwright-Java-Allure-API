package com.framework.utils;
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.Properties;
public class EnvConfig {
    private static Properties properties = new Properties();
    public static void load() {
        String env = System.getProperty("env"); if (env == null || env.isEmpty()) env = "qa";
        String file = "src/test/resources/config-" + env + ".properties";
        try (FileInputStream fis = new FileInputStream(file)) { properties.load(fis); } catch (IOException e) { throw new RuntimeException("Failed to load env properties: " + file, e); }
    }
    public static String get(String key) { return properties.getProperty(key); }
}

package properties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.io.FileInputStream;

public class PropertiesHandler {

    private Properties properties = new Properties();

    private static PropertiesHandler instance;

    private PropertiesHandler() {
        String rootPath = System.getProperty("user.dir") + File.separator + "properties" + File.separator;
        String defaultConfigPath = rootPath + "default.properties";
        try {
            properties.load(new FileInputStream(defaultConfigPath));
        } catch (IOException e) {
            System.out.println("Properties file not loaded");
        }
    }

    public static PropertiesHandler getInstance() {
        if (instance != null) {
            return instance;
        }
        instance = new PropertiesHandler();
        return instance;
    }

    public static String getProperty(String key) {
        return getInstance().getProperty(key, null);
    }

    public String getProperty(String key, String defaultValue) {
        return getInstance().properties.getProperty(key, defaultValue);
    }
}

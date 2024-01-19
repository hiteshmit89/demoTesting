package Framework.Util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ConfigManager {
    private static ConfigManager manager = null;
    private static final Properties PROPERTIES = new Properties();

    private ConfigManager() throws IOException{
        PROPERTIES.load(getInputStream("Default.properties"));
    }

    public static ConfigManager getInstance() {
        if (manager == null){
            try {
                manager = new ConfigManager();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return manager;
    }

    public String getProperty(String propertyName){
        return System.getProperty(propertyName, PROPERTIES.getProperty(propertyName));
    }

    private InputStream getInputStream(String filename) {
        try {
            List<URL> urls = Collections.list(Thread.currentThread().getContextClassLoader().getResources(filename));
            return urls == null || urls.isEmpty() ? null : urls.getFirst().openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void loadAdditionalProperties(String fileName){
        try{
            PROPERTIES.load(getInputStream(fileName));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

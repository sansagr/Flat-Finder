package org.example.configs;

import lombok.extern.log4j.Log4j2;

import java.util.Properties;
import java.io.InputStream;

@Log4j2
public class AppConfig {

    public String getConfigValue(String configName){
        Properties prop = new Properties();
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
               log.info("Sorry, unable to find application.properties");
                return null;
            }
            prop.load(input);
        }
        catch (Exception e){
            log.error("Error in reading from application.properties");
        }

        return prop.getProperty(configName);
    }
}

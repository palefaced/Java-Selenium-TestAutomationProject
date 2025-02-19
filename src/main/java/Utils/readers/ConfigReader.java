package Utils.readers;

import Utils.config.AppConfig;
import Utils.constants.Constants_Readers;
import Utils.loggers.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConfigReader {
    private static AppConfig appConfig;

    static {
        try {
            // Specify the path to the appConfig.json file
            File configFile = new File("src/test/resources/config/appConfig.json");

            // Use Jackson ObjectMapper to parse the JSON file into the AppConfig class
            ObjectMapper objectMapper = new ObjectMapper();
            appConfig = objectMapper.readValue(configFile, AppConfig.class);
        } catch (IOException e) {
            Logger.log.error(Constants_Readers.FAILED_TO_LOAD_READER, e.getMessage());
            throw new RuntimeException(e);
        }
    }

    // Accessor for AppConfig object
    public static AppConfig getConfig() {
        return appConfig;
    }
}

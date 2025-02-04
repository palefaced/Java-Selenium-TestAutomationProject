package Utils.readers;

import Utils.config.AppConfig;
import Utils.constants.Constants_Readers;
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
        } catch (IOException exception) {
            throw new RuntimeException(Constants_Readers.FAILED_TO_LOAD_READER, exception);
        }
    }

    // Accessor for AppConfig object
    public static AppConfig getConfig() {
        return appConfig;
    }
}

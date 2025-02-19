package Utils.readers;

import Utils.constants.Constants_Readers;
import Utils.loggers.Logger;
import Utils.models.RegistrationPageUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataReader {

    public static RegistrationPageUser getTestData(String filePath, String testCaseId) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File filepath = new File(filePath);
            // Read JSON array into a list
            List<RegistrationPageUser> testDataList = mapper.readValue(
                    filepath,
                    new TypeReference<List<RegistrationPageUser>>() {
                    }
            );

            // Find the data matching the given testCaseId
            return testDataList.stream()
                    .filter(data -> data.getTestCaseID().equalsIgnoreCase(testCaseId))
                    .findFirst()
                    .orElseThrow(() -> {
                        Logger.log.error(Constants_Readers.TEST_DATA_NOT_FOUND_FOR_TEST_CASE + testCaseId);
                        return new IllegalArgumentException();
                    });
        } catch (IOException e) {
            Logger.log.error(Constants_Readers.FAILED_TO_READ_DATA_FROM_JSON + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
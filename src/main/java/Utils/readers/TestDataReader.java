package Utils.readers;

import Utils.models.RegistrationUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataReader {

    public static RegistrationUser getTestData(String filePath, String testCaseId) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File filepath = new File(filePath);
            // Read JSON array into a list
            List<RegistrationUser> testDataList = mapper.readValue(
                    filepath,
                    new TypeReference<List<RegistrationUser>>() {
                    }
            );

            // Find the data matching the given testCaseId
            return testDataList.stream()
                    .filter(data -> data.getTestCaseID().equalsIgnoreCase(testCaseId))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No test data found for testCaseId: " + testCaseId));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from JSON file", e);
        }
    }
}
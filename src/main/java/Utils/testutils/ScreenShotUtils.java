package Utils.testutils;

import Utils.constants.Constants_Test_Classes;
import Utils.loggers.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;

public class ScreenShotUtils {
    private WebDriver driver;

    public ScreenShotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void captureFailureDetails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            String screenshotPath = "screenshots/" + testName + ".png";
            String logFilePath = "logs/" + testName + ".log";

            // then Convert WebDriver to TakesScreenshot object to ONLY capture an image with getScreenshotAt method
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                Logger.log.error("Test Failed: {} - Screenshot saved at {}", testName, screenshotPath);
            } catch (IOException e) {
                Logger.log.error("Failed to save screenshot: ", e);
            }

            // then we Save Logs for this test
            File logFile = new File(logFilePath);
            try {
                FileUtils.writeStringToFile(logFile, "Test Failure Log: " + testName + "\n" + result.getThrowable(), "UTF-8");
                Logger.log.error("Logs saved at {}", logFilePath);
            } catch (IOException e) {
                Logger.log.error("Failed to save logs", e);
            }
        }
    }
}
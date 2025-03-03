package Utils.testutils;

import Utils.constants.Constants_ScreenShotUtils;
import Utils.loggers.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtils {
    private WebDriver driver;
    private String currentScreenshotPath;

    public ScreenShotUtils(WebDriver driver) {
        this.driver = driver;
    }
    //Не е кой знае колко сложно, трбява да се заучи как точно се случват нещата
    public void captureFailureDetails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String testName = result.getName();
            String screenshotPath = "screenshots/" + testName + ".png";
            String logFilePath = "logs/" + testName + ".log";

            
            //Deletes old screenshot if exists
            File screenshotFile = new File(screenshotPath);
            if (screenshotFile.exists() && screenshotFile.delete()) {
                Logger.log.info(Constants_ScreenShotUtils.OLD_SCREENSHOT_DELETED_MSG, screenshotPath);
            }

            // then Convert WebDriver to TakesScreenshot object to ONLY capture an image with getScreenshotAt method
            File screenshot = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshot, new File(screenshotPath));
                Logger.log.error(Constants_ScreenShotUtils.NEW_SCREENSHOT_SAVED_MSG, screenshotPath);
                this.currentScreenshotPath = screenshotPath;
            } catch (IOException e) {
                Logger.log.error(Constants_ScreenShotUtils.FAILED_TO_SAVE_SCREENSHOT_MSG, e);
            }

            //Delete old logs if file exists
            File logFile = new File(logFilePath);
            if (logFile.exists() && logFile.delete()) {
                Logger.log.info(Constants_ScreenShotUtils.OLD_LOGS_DELETED_MSG, logFilePath);
            }

            // then we Save Logs for the failed test
            try {
                FileUtils.writeStringToFile(logFile, "Test Failure Log: " + testName + "\n" + result.getThrowable(), "UTF-8");
                Logger.log.error(Constants_ScreenShotUtils.NEW_LOG_SAVED_MSG, logFilePath);
            } catch (IOException e) {
                Logger.log.error(Constants_ScreenShotUtils.FAILED_TO_SAVE_LOG_MSG, e);
            }
        }
    }

    public String getCurrentScreenshotPath() {
        return currentScreenshotPath;
    }
}
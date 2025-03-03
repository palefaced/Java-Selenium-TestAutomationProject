package Utils.base;

import Utils.constants.Constants_Test_Classes;
import Utils.loggers.Logger;
import Utils.readers.ConfigReader;
import Utils.testutils.EmailUtils;
import Utils.testutils.ScreenShotUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;


public class BaseTest {
    protected WebDriver driver;
    public ScreenShotUtils screenShotUtils;

    @BeforeClass
    public void setUp() {
        String browser = ConfigReader.getConfig().getEnvironment().getBrowser();
        Boolean headless = ConfigReader.getConfig().getEnvironment().getHeadless();

        if (browser.toLowerCase().equals(Constants_Test_Classes.chrome)) {
            initializeChromeDriver(headless);
        } else if (browser.toLowerCase().equals(Constants_Test_Classes.firefox)) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else {
            Logger.log.error(Constants_Test_Classes.UNSUPPORTED_BROWSER_ERROR_MSG + browser);
            throw new IllegalArgumentException();
        }
        driver.manage().window().maximize();

        //Initialize screenShotUtils
        this.screenShotUtils = new ScreenShotUtils(driver);
    }

    private void initializeChromeDriver(Boolean headless) {
        if (headless) {
            ChromeOptions options = new ChromeOptions();
            List<String> arguments = ConfigReader.getConfig().getEnvironment().getArguments();
            options.addArguments(arguments);
            this.driver = new ChromeDriver(options);
        } else {
            this.driver = new ChromeDriver();
        }
    }

    @AfterMethod
    public void logFailuresAndSendEmails(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Logger.log.error(Constants_Test_Classes.TEST_FAILURE_MSG, result.getName());
            Logger.log.error(Constants_Test_Classes.RESULT_OF_THE_FAILED_TEST, result.getThrowable());
        }
        //Capture screenshot
        screenShotUtils.captureFailureDetails(result);

        //Get its path to be able to send it in an email
        String screenshotPath = screenShotUtils.getCurrentScreenshotPath();
//        if (screenshotPath != null) {
//            Logger.log.info("Screenshot saved at: " + screenshotPath);
//            String errorMessage = result.getThrowable() != null ? result.getThrowable().toString() : "Test failed without an exception.";
//            EmailUtils.sendEmail(result.getName(), errorMessage, screenshotPath);
//        } else {
//            Logger.log.error("Screenshot path is null, skipping email sending.");
//        }
        String errorMessage = result.getThrowable() != null ? result.getThrowable().toString() : "Test failed without an exception.";
        EmailUtils.sendEmail(result.getName(), errorMessage, screenshotPath);

    }

    @AfterClass
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}

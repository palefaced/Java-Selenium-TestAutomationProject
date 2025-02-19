import Utils.constants.Constants_Test_Classes;
import Utils.loggers.Logger;
import Utils.readers.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.List;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {

        String browser = ConfigReader.getConfig().getEnvironment().getBrowser();
        Boolean headless = ConfigReader.getConfig().getEnvironment().getHeadless();

        if (browser.toLowerCase().equals(Constants_Test_Classes.chrome)) {
            if (headless) {
                ChromeOptions options = new ChromeOptions();
                List<String> arguments = ConfigReader.getConfig().getEnvironment().getArguments();
                options.addArguments(arguments);
                this.driver = new ChromeDriver(options);
            } else {
                this.driver = new ChromeDriver();
            }

        } else if (browser.toLowerCase().equals(Constants_Test_Classes.firefox)) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else {
            Logger.log.error(Constants_Test_Classes.UNSUPPORTED_BROWSER_ERROR_MSG + browser);
            throw new IllegalArgumentException();
        }
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void logFailures(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Logger.log.error(Constants_Test_Classes.TEST_FAILURE_MSG, result.getName(), result.getThrowable());
        }
    }

    public void tearDown(){
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}

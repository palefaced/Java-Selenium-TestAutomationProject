import Utils.readers.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        String browser = ConfigReader.getConfig().getEnvironment().getBrowser();

        if (browser.toLowerCase().equals("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");  // Disable GPU hardware acceleration
            options.addArguments("--no-sandbox");   // Ensure it runs in CI
            options.addArguments("--remote-debugging-port=9222");  // Required to avoid "DevToolsActivePort" error

            this.driver = new ChromeDriver(options);

            //Needed if tests are started from testing.xml
            //Utils.removeAllFrames(driver);
        } else if (browser.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported brer" + browser);
        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        if (this.driver != null) {
            this.driver.quit();
        }
    }

//    Best Practices
//    Use @BeforeClass and @AfterClass for browser setup and teardown if you want to run all tests in a class in a single browser instance.
//    Use @BeforeMethod and @AfterMethod if each test method needs its own browser instance.
//    Centralize the WebDriver initialization logic in a base class or a utility class to follow the DRY (Don't Repeat Yourself) principle.
//    Use WebDriverManager (e.g., from the io.github.bonigarcia library) to simplify browser driver management instead of setting system properties manually.

}

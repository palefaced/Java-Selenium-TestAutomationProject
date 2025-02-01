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
    public void setUp() {

        String browser = ConfigReader.getConfig().getEnvironment().getBrowser();

        if (browser.toLowerCase().equals("chrome")) {
//            Required to run test execution in GITHUB Actions

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");  // Disable GPU hardware acceleration
            options.addArguments("--no-sandbox");   // Ensure it runs in CI
            options.addArguments("--remote-debugging-port=9222");  // Required to avoid "DevToolsActivePort" error

            this.driver = new ChromeDriver(options);
            // this.driver = new ChromeDriver();

        } else if (browser.toLowerCase().equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            this.driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser" + browser);
        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}

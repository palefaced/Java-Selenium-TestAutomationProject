import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zAnotherInstanceOfChromeTest {
    //The class will be used only for testing purposes
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.abv.bg");
    }
}

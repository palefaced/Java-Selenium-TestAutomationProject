package Pages;

import Utils.readers.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver Driver(){
        return this.driver;
    }
}

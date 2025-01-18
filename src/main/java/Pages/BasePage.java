package Pages;

import Utils.readers.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int waitTime = ConfigReader.getConfig().getTimeouts().getExplicitWait();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
    }
    public WebDriver Driver(){
        return this.driver;
    }

    //Така ще работи с Лист от Уебелементи и с Сингъл уебелемент, за това ползваме дженерици
    public <T> T WaitFor(ExpectedCondition<T> condition) {
        return this.wait.until(condition);
    }
}

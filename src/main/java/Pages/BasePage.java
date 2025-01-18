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

        //Generated based on the ConfigFile - access the timeout values from the nested timeouts objects
        int wait = ConfigReader.getConfig().getTimeouts().getExplicitWait();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(wait));
    }
    public WebDriver Driver(){
        return this.driver;
    }

    //Така ще работи с Лист от Уебелементи и с Сингъл уебелемент, за това ползваме дженерици
    public <T> T WaitFor(ExpectedCondition<T> condition) {
        return this.wait.until(condition);
    }

    //Wait-a, можем и да го добавим генерално в Base клас-a, като просто го подадем на конструктора !
    // така ще го има на всяка стъпка !
}

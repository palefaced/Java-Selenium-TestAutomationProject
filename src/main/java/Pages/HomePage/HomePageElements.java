package Pages.HomePage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements extends BasePage {
    public HomePageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement mainHeader(){
        return Driver().findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
    }

    public  WebElement JoinNowButton(){
        return Driver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/a/img"));
    }
}

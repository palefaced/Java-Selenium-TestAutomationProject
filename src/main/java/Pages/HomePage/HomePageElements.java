package Pages.HomePage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements extends BasePage {
    public HomePageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement mainHeader(){
        try {
            return Driver().findElement(By.xpath("//*[@id=\"app\"]/header/a/img"));
        } catch (NoSuchElementException e){
            throw new RuntimeException("Element not found" + e.getMessage());
        }
    }

    public  WebElement JoinNowButton(){
        try {
            return Driver().findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]/a/img"));
        }   catch (NoSuchElementException e){
            throw new RuntimeException("Element not found" + e.getMessage());
        }
    }
}

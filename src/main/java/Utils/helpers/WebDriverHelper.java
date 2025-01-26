package Utils.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelper {

    public static void tryToNavigateToURL(WebDriver driver, String url){
        try {
            driver.get(url);
        } catch (Exception e){
            throw new RuntimeException("Failed to navigate to the URL: " + e.getMessage());
        }
    }

    public static WebElement findElement(WebDriver driver, By locator){
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public static void tryToClickOnElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("option not found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be clicked: " + e.getMessage());
        }
    }



}

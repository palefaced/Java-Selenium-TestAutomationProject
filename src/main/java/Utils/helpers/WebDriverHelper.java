package Utils.helpers;

import Utils.constants.Constants_Registration_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class WebDriverHelper {

    public static void tryToNavigateToURL(WebDriver driver, String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            throw new RuntimeException("Failed to navigate to the URL: " + e.getMessage());
        }
    }

    public static WebElement tryFindElement(WebDriver driver, By locator) {
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
            throw new RuntimeException("Element not found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be clicked: " + e.getMessage());
        }
    }

    public static void trySendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Failed to populate the element: " + e.getMessage());
        }
    }

    public static void trySelectElement(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be selected: " + e.getMessage());
        }
    }

    public static void selectDateFromCalendarWidget(List<WebElement> elementList, String day) {
        try {
            List<WebElement> days = elementList;
            for (WebElement dayCell : days) {
                if (dayCell.getText().equals(day)) {
                    dayCell.click();
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be selected: " + e.getMessage());
        }
    }

    public static void selectFromMultipleOptions(List<WebElement> elemetsList, List<Boolean> booleanList){
        try {
            for (int i = 0; i < elemetsList.size() - 1; i++) {
                if (booleanList.get(i)) {
                    elemetsList.get(i).click();
                }
            }
        } catch (Exception exp) {
            throw new RuntimeException("Element failed to be selected: " + exp.getMessage());
        }
    }

    public static String trySetAbsolutePathForFile(String path){
        try {
            File file = new File(path);
            return file.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException("File not found: " + path);
        }
    }
}

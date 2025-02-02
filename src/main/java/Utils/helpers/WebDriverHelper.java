package Utils.helpers;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class WebDriverHelper extends BasePage {

    public WebDriverHelper(WebDriver driver) {
        super(driver);
    }

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

    public static List<WebElement> tryFindElements(WebDriver driver, By locator) {
        try {
            return driver.findElements(locator);
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

    public static void trySelectDateFromCalendarWidget(List<WebElement> elementList, String day) {
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

    public static void trySelectFromMultipleOptions(List<WebElement> elemetsList, List<Boolean> booleanList) {
        try {
            for (int i = 0; i < elemetsList.size() - 1; i++) {
                if (booleanList.get(i)) {
                    elemetsList.get(i).click();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be selected: " + e.getMessage());
        }
    }

    public static String trySetAbsolutePathForFile(String path) {
        try {
            File file = new File(path);
            return file.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException("Absolute path for the file not found: " + path);
        }
    }

    public static WebElement tryWaitForElementToBeClickable(WebDriver driver, By locator) {
        try {
            return new WebDriverHelper(driver).WaitFor(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be clicked: " + e.getMessage());
        }
    }

    public static WebElement tryWaitForElementToBeVisible(WebDriver driver, By locator) {
        try {
            return new WebDriverHelper(driver).WaitFor(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            throw new RuntimeException("Element not visible: " + e.getMessage());
        }
    }

    public static List<WebElement> tryWaitForElementsToBeVisible(WebDriver driver, By locator) {
        try {
            return new WebDriverHelper(driver).WaitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            throw new RuntimeException("Elements not visible: " + e.getMessage());
        }
    }

    public static String tryReturnCSSValue(WebElement element, String property) {
        try {
            return element.getCssValue(property);
        } catch (Exception e) {
            throw new RuntimeException("CSS value of element not found: " + e.getMessage());
        }
    }
}

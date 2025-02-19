package Utils.helpers;

import Utils.constants.Constants_Element_Action_Helper;
import Utils.loggers.LoggerUtils;
import Utils.readers.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class ElementActionsHelper {

    private static <T> T waitFor(WebDriver driver, ExpectedCondition<T> condition) {
        int waitTime = ConfigReader.getConfig().getTimeouts().getExplicitWait();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
        return wait.until(condition);
    }

    public static void tryToNavigateToURL(WebDriver driver, String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.FAILED_TO_NAVIGATE_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static WebElement tryFindElement(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List<WebElement> tryFindElements(WebDriver driver, By locator) {
        try {
            return driver.findElements(locator);
        } catch (NoSuchElementException e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void tryToClickOnElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_CLICK_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void trySendKeys(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (NoSuchElementException e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_POPULATED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void trySelectElement(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_FAILED_TO_BE_SELECTED_MSG + e.getMessage());
            throw new RuntimeException(e);
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
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_FAILED_TO_BE_SELECTED_MSG + e.getMessage());
            throw new RuntimeException(e);
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
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_FAILED_TO_BE_SELECTED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String trySetAbsolutePathForFile(String path) {
        try {
            File file = new File(path);
            return file.getAbsolutePath();
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.PATH_NOT_FOUND_MSG + path);
            throw new RuntimeException(e);
        }
    }

    public static WebElement tryWaitForElementToBeClickable(WebDriver driver, By locator) {
        try {
            return waitFor(driver, ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_CLICK_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static WebElement tryWaitForElementToBeVisible(WebDriver driver, By locator) {
        try {
            return waitFor(driver, ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_VISIBILITY_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List<WebElement> tryWaitForElementsToBeVisible(WebDriver driver, By locator) {
        try {
            return waitFor(driver, ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.ELEMENT_VISIBILITY_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String tryReturnCSSValue(WebElement element, String property) {
        try {
            return element.getCssValue(property);
        } catch (Exception e) {
            LoggerUtils.log.error(Constants_Element_Action_Helper.CSS_VALUE_OF_ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

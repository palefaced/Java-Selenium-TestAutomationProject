package Utils.helpers;

import Utils.constants.Constants_Element_Action_Helper;
import Utils.constants.Constants_JS;
import Utils.loggers.Logger;
import Utils.readers.ConfigReader;
import org.apache.commons.logging.Log;
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
            Logger.log.info(Constants_Element_Action_Helper.NAVIGATING_TO_THE_WEB_PAGE + url);
            driver.get(url);
            Logger.log.info(Constants_Element_Action_Helper.SUCCESSFULLY_NAVIGATED_TO_THE_WEB_PAGE + url);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.FAILED_TO_NAVIGATE_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static WebElement tryFindElement(WebDriver driver, By locator) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.SEARCHING_FOR_ELEMENT, locator);
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List<WebElement> tryFindElements(WebDriver driver, By locator) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.SEARCHING_FOR_ELEMENTS, locator);
            return driver.findElements(locator);
        } catch (NoSuchElementException e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void tryToClickOnElement(WebElement element) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.CLICKING_ON_ELEMENT, element);
            element.click();
            Logger.log.info(Constants_Element_Action_Helper.ELEMENT_CLICKED);
        } catch (NoSuchElementException e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_CLICK_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void trySendKeys(WebElement element, String text) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.POPULATING_FIELD, element, text);
            element.clear();
            element.sendKeys(text);
            Logger.log.info(Constants_Element_Action_Helper.FIELD_POPULATED_MSG);
        } catch (NoSuchElementException e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_NOT_POPULATED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void trySelectElement(WebElement element, String text) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.SELECTING_ELEMENT_BY_VISIBLE_TEXT + element);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            Logger.log.info(Constants_Element_Action_Helper.ELEMENT_SELECTED_SUCCESSFULLY);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_FAILED_TO_BE_SELECTED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void trySelectDateFromCalendarWidget(List<WebElement> elementList, String day) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.SELECTING_DATE_FROM_CALENDAR);
            List<WebElement> days = elementList;
            for (WebElement dayCell : days) {
                if (dayCell.getText().equals(day)) {
                    dayCell.click();
                    break;
                }
            }
            Logger.log.info(Constants_Element_Action_Helper.DATE_SELECTED_MSG);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_FAILED_TO_BE_SELECTED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void trySelectFromMultipleOptions(List<WebElement> elemetsList, List<Boolean> booleanList) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.SELECTING_MULTISELECT_OPTION);
            for (int i = 0; i < elemetsList.size() - 1; i++) {
                if (booleanList.get(i)) {
                    elemetsList.get(i).click();
                }
            }
            Logger.log.info(Constants_Element_Action_Helper.ELEMENT_SELECTED_SUCCESSFULLY);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_FAILED_TO_BE_SELECTED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String trySetAbsolutePathForFile(String path) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.SETTING_ABSOLUTE_PATH_FOR_FILE);
            File file = new File(path);
            return file.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException(Constants_Element_Action_Helper.PATH_NOT_FOUND_MSG + path);
        }
    }

    public static WebElement tryWaitForElementToBeClickable(WebDriver driver, By locator) {
        try {
            Logger.log.info(Constants_Element_Action_Helper.CLICKING_ON_ELEMENT);
            return waitFor(driver, ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_CLICK_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static WebElement tryWaitForElementToBeVisible(WebDriver driver, By locator) {
        try {
            return waitFor(driver, ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_VISIBILITY_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static List<WebElement> tryWaitForElementsToBeVisible(WebDriver driver, By locator) {
        try {
            return waitFor(driver, ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.ELEMENT_VISIBILITY_FAILED_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static String tryReturnCSSValue(WebElement element, String property) {
        try {
            return element.getCssValue(property);
        } catch (Exception e) {
            Logger.log.error(Constants_Element_Action_Helper.CSS_VALUE_OF_ELEMENT_NOT_FOUND_MSG + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

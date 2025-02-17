package Utils.scripts;

import Utils.constants.Constants_JS;
import Utils.loggers.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS_Scripts {
    public static void removeAllFrames(WebDriver driver) {
        Logger.log.info(Constants_JS.REMOVING_ALL_FRAMES_FROM_THE_PAGE);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(Constants_JS.REMOVE_ALL_FRAMES_SCRIPT);
        for (int i = 0; i < 3; i++) { // Retry logic
            Long frameCount = (Long) js.executeScript(Constants_JS.COUNT_FRAMES_SCRIPT);
            if (frameCount == 0) break;
            try {
                Thread.sleep(500); // Allow any dynamic frames to load
            } catch (InterruptedException e) {
                Logger.log.error(Constants_JS.INTERRUPTED_EXCEPTION, e);
                throw new RuntimeException(e);
            }
            js.executeScript(Constants_JS.REMOVE_ALL_FRAMES_SCRIPT);
        }
    }

    public static void scrollToBottom(WebDriver driver) {
        try {
            Logger.log.info(Constants_JS.SCROLLING_TO_THE_BOTTOM_OF_THE_PAGE);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(Constants_JS.SCROLL_TO_BOTTOM_SCRIPT);
            Logger.log.info(Constants_JS.SUCCESSFULLY_SCROLLED_TO_THE_BOTTOM_OF_THE_PAGE);
        } catch (Exception e) {
            Logger.log.error(Constants_JS.FAILED_TO_SCROLL_TO_THE_BOTTOM_OF_THE_PAGE + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void scrollElementInToView(WebDriver driver, WebElement element) {
        try {
            Logger.log.info(Constants_JS.SCROLLING_ELEMENT_INTO_VIEW, element);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(Constants_JS.SCROLL_ELEMENT_INTO_VIEW_SCRIPT, element);
            Logger.log.info(Constants_JS.SUCCESSFULLY_SCROLLED_ELEMENT_INTO_VIEW);
        } catch (Exception e) {
            Logger.log.error(Constants_JS.FAILED_TO_SCROLL_ELEMENT_INTO_VIEW + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

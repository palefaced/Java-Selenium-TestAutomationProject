package Utils.scripts;

import Utils.constants.Constants_JS;
import Utils.loggers.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS_Scripts {
    public static void removeAllFrames(WebDriver driver) {
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
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(Constants_JS.SCROLL_TO_BOTTOM_SCRIPT);
        } catch (Exception e) {
            Logger.log.error(Constants_JS.FAILED_TO_SCROLL_TO_THE_BOTTOM_OF_THE_PAGE + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void scrollElementInToView(WebDriver driver, WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(Constants_JS.SCROLL_ELEMENT_INTO_VIEW_SCRIPT, element);
        } catch (Exception e) {
            Logger.log.error(Constants_JS.FAILED_TO_SCROLL_ELEMENT_INTO_VIEW + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

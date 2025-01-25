package Utils.scripts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS_Scripts {
    public static void removeAllFrames(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll('iframe, frame').forEach(frame => frame.remove());");
        for (int i = 0; i < 3; i++) { // Retry logic
            Long frameCount = (Long) js.executeScript("return document.querySelectorAll('iframe, frame').length;");
            if (frameCount == 0) break;
            try {
                Thread.sleep(500); // Allow any dynamic frames to load
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            js.executeScript("document.querySelectorAll('iframe, frame').forEach(frame => frame.remove());");
        }
    }

    public static void scrollToBottom(WebDriver driver) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        } catch (Exception e){
            throw new RuntimeException("Failed to scroll to the bottom of the page: " + e.getMessage());
        }
    }

    public static void scrollElementInToView(WebDriver driver, WebElement element){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e){
            throw new RuntimeException("Failed to scroll element into view: " + e.getMessage());
        }
    }
}

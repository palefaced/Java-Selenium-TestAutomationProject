package Pages.HomePage;

import Pages.BasePage;
import Utils.helpers.ElementActionsHelper;
import Utils.loggers.LoggerUtils;
import Utils.readers.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    protected HomePageElements elements() {
        return new HomePageElements(Driver());
    }

    public HomePageAssertions assertions() {
        return new HomePageAssertions(Driver());
    }

    public void navigateTo() {
        LoggerUtils.logger.info("Navigating to HomePage");
        ElementActionsHelper.tryToNavigateToURL(Driver(), ConfigReader.getConfig().getEnvironment().getBaseUrl());
        LoggerUtils.logger.info("Successfully navigated to Registration Page");
    }
}

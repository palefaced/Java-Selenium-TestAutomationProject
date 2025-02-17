package Pages.HomePage;

import Pages.BasePage;
import Utils.helpers.ElementActionsHelper;
import Utils.readers.ConfigReader;
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
        ElementActionsHelper.tryToNavigateToURL(Driver(), ConfigReader.getConfig().getEnvironment().getBaseUrl());
    }
}

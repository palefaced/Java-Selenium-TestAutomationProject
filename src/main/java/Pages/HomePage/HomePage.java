package Pages.HomePage;

import Pages.BasePage;
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
        try {
            Driver().get(ConfigReader.getConfig().getEnvironment().getBaseUrl());
        } catch (Exception e){
            throw new RuntimeException("Failed to navigate to the URL: " + e.getMessage());
        }
    }
}

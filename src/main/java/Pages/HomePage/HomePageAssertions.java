package Pages.HomePage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageAssertions extends BasePage {
    public HomePageAssertions(WebDriver driver) {
        super(driver);
    }

    protected HomePageElements elements(){
        return new HomePageElements(Driver());
    }

    public void assertIfHeaderIsAvailable(){
        Assert.assertTrue(elements().mainHeader().isDisplayed());
    }

    public void assertIfJoinNowButtonIsAvailable(){
        //explicitly fails to trigger RetryListenerClass
        Assert.assertFalse(elements().JoinNowButton().isDisplayed());
    }
}

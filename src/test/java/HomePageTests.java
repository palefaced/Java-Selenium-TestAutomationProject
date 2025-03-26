import Pages.HomePage.HomePage;
import Utils.base.BaseTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

//@Listeners(value= RetryListener.class)
public class HomePageTests extends BaseTest {
    @Test
    @Description("Verify HomePage is Loaded")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("HomePageTests")
    public void VerifyHomePageIsLoadedByCheckingTheHeader() {
        HomePage hp = new HomePage(this.driver);
        hp.navigateTo();
        hp.assertions().assertIfHeaderIsAvailable();
    }

    @Test
    @Description("Verify HomePage Join Button is presented on the WebPage")
    @Severity(SeverityLevel.NORMAL)
    @Feature("HomePageTests")
    public void VerifyHomePageJoinButtonIsPresented() {
        HomePage hp = new HomePage(this.driver);
        hp.navigateTo();
        hp.assertions().assertIfJoinNowButtonIsAvailable();
    }
}

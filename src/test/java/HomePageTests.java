import Pages.HomePage.HomePage;
import Utils.base.BaseTest;
import org.testng.annotations.Test;

//@Listeners(value= RetryListener.class)
public class HomePageTests extends BaseTest {
    @Test
    public void VerifyHomePageIsLoadedByCheckingTheHeader() {
        HomePage hp = new HomePage(this.driver);
        hp.navigateTo();
        hp.assertions().assertIfHeaderIsAvailable();
    }

    @Test()
    public void VerifyHomePageJoinButtonIsPresented() {
        HomePage hp = new HomePage(this.driver);
        hp.navigateTo();
        hp.assertions().assertIfJoinNowButtonIsAvailable();
    }
}

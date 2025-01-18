import Pages.HomePage.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void verifyHomePageIsLoadedByCheckingTheHeader() {
        HomePage hp = new HomePage(this.driver);
        hp.navigateTo();
        hp.assertions().assertIfHeaderIsAvailable();
    }

    @Test
    public void VerifyHomePageJoinButtonIsPresented() {
        HomePage hp = new HomePage(this.driver);
        hp.navigateTo();
        hp.assertions().assertIfJoinNowButtonIsAvailable();

    }
}

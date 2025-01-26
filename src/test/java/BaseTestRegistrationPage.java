import Pages.RegistrationPage.RegistrationPage;
import Utils.readers.ConfigReader;
import org.testng.annotations.BeforeClass;

public class BaseTestRegistrationPage extends BaseTest{
    protected String testDataPathRegistrationPage;
    protected RegistrationPage registrationPage;

    @BeforeClass
    public void setUpRegistrationPage(){
        this.testDataPathRegistrationPage = ConfigReader.getConfig().getTestData().getTestDataPathRegistrationPage();
        this.registrationPage = new RegistrationPage(this.driver);
    }
}
import Utils.base.BaseTestRegistrationPage;
import Utils.models.RegistrationPageUser;
import Pages.RegistrationPage.RegistrationPage;
import Utils.readers.ConfigReader;
import Utils.readers.TestDataReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.testng.annotations.Test;

public class RegistrationPageTests extends BaseTestRegistrationPage {

    //Two ways if preparing the actual tests: using Utils.base.BaseTest class and Utils.base.BaseTest/forAnyPage/Class//
    //Utils.base.BaseTestRegistrationPage is handling the path to the config file and the creation of the reg page//

    @Test(priority = 2)
    @Description("Verify Registration fails without first name.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("RegPageTests")
    public void RegistrationFailsWithoutFirstName() throws InterruptedException {
        RegistrationPageUser user = TestDataReader.getTestData(this.testDataPathRegistrationPage, "TC001");

        this.registrationPage.navigateTo();
        this.registrationPage.fillRegistrationForm(user);
        this.registrationPage.assertions().assertRegistrationFailsWithoutFirstName();
    }

    @Test(priority = 2)
    @Description("Verify Registration fails without last name.")
    @Severity(SeverityLevel.NORMAL)
    @Feature("RegPageTests")
    public void RegistrationFailsWithoutLastName() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(this.driver);
        String testDatPath = ConfigReader.getConfig().getTestData().getTestDataPathRegistrationPage();
        RegistrationPageUser user = TestDataReader.getTestData(testDatPath, "TC002");

        registrationPage.navigateTo();
        registrationPage.fillRegistrationForm(user);
        registrationPage.assertions().assertRegistrationFailsWithoutLastname();
    }

    @Test(priority = 3)
    @Description("Verify Registration fails without phone number.")
    @Severity(SeverityLevel.MINOR)
    @Feature("RegPageTests")
    public void RegistrationFailsWithoutPhoneNumber() throws InterruptedException {

        RegistrationPageUser user = TestDataReader.getTestData(this.testDataPathRegistrationPage, "TC003");

        this.registrationPage.navigateTo();
        this.registrationPage.fillRegistrationForm(user);
        this.registrationPage.assertions().assertRegistrationFailsWithoutMobilePhone();
    }

    @Test(priority = 3)
    @Description("Verify Registration fails without a valid phone number.")
    @Severity(SeverityLevel.MINOR)
    @Feature("RegPageTests")
    public void RegistrationFailsWithoutValidPhoneNumber() throws InterruptedException {

        RegistrationPageUser user = TestDataReader.getTestData(this.testDataPathRegistrationPage, "TC004");

        this.registrationPage.navigateTo();
        this.registrationPage.fillRegistrationForm(user);
        this.registrationPage.assertions().assertRegistrationFailsWithoutMobilePhone();
    }

    @Test(priority = 3)
    @Description("Verify Registration fails without valid email address.")
    @Severity(SeverityLevel.MINOR)
    @Feature("RegPageTests")
    public void RegistrationFailsWithoutValidEmail() throws InterruptedException {

        RegistrationPageUser user = TestDataReader.getTestData(this.testDataPathRegistrationPage, "TC005");

        registrationPage.navigateTo();
        registrationPage.fillRegistrationForm(user);
        registrationPage.assertions().assertRegistrationFailsWithInValidEmail();
    }

    @Test(priority = 3)
    @Description("Verify Registration fails without selecting gender.")
    @Severity(SeverityLevel.MINOR)
    @Feature("RegPageTests")
    public void RegistrationFailsWithoutGenderSelection() throws InterruptedException {

        RegistrationPageUser user = TestDataReader.getTestData(this.testDataPathRegistrationPage, "TC006");

        registrationPage.navigateTo();
        registrationPage.fillRegistrationForm(user);
        registrationPage.assertions().assertRegistrationFailsWithoutGenders();
    }

    @Test(priority = 1)
    @Description("Verify Registration is successful.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("RegPageTests")
    public void SuccessfullySubmittingFormByCheckingTheLabel() throws InterruptedException {

        RegistrationPageUser user = TestDataReader.getTestData(this.testDataPathRegistrationPage, "TC007");

        registrationPage.navigateTo();
        registrationPage.fillRegistrationForm(user);
        registrationPage.assertions().AssertFormIsSuccessfullySubmittedByLabel();
    }
}

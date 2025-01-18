package Pages.RegistrationPage;

import Pages.BasePage;
import Utils.constants.Constants_Registration_Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPageAssertions extends BasePage {
    public RegistrationPageAssertions(WebDriver driver) {
        super(driver);
    }

    protected RegistrationPageElements elements() {
        return new RegistrationPageElements(Driver());
    }

    public void assertRegistrationFailsWithoutFirstName() {
        String actualImageURL = elements().getFieldBackGroundImage(elements().firstName());
        Assert.assertEquals(actualImageURL, Constants_Registration_Page.BACKGROUND_IMAGE_EXPECTED_ERROR_URL,
                Constants_Registration_Page.BACKGROUND_IMAGE_ERROR_MSG);
    }

    public void assertRegistrationFailsWithoutLastname() {
        String actualImageURL = elements().getFieldBackGroundImage(elements().lastName());
        Assert.assertEquals(actualImageURL, Constants_Registration_Page.BACKGROUND_IMAGE_EXPECTED_ERROR_URL,
                Constants_Registration_Page.BACKGROUND_IMAGE_ERROR_MSG);
    }

    public void assertRegistrationFailsWithoutMobilePhone() {
        String actualImageURL = elements().getFieldBackGroundImage(elements().mobilePhone());
        Assert.assertEquals(actualImageURL, Constants_Registration_Page.BACKGROUND_IMAGE_EXPECTED_ERROR_URL,
                Constants_Registration_Page.BACKGROUND_IMAGE_ERROR_MSG);
    }

    public void assertRegistrationFailsWithInValidEmail() {
        String actualImageURL = elements().getFieldBackGroundImage(elements().eMail());
        Assert.assertEquals(actualImageURL, Constants_Registration_Page.BACKGROUND_IMAGE_EXPECTED_ERROR_URL,
                Constants_Registration_Page.BACKGROUND_IMAGE_ERROR_MSG);
    }

    public void assertRegistrationFailsWithoutGenders() {
        Assert.assertEquals(elements().getElementColor(elements().femaleGender()),
                Constants_Registration_Page.BORDER_COLOR_RED,
                Constants_Registration_Page.BORDER_COLOR_ERROR_MSG_IN_CASE_OF_DISCREPANCY);
    }

    public void AssertFormIsSuccessfullySubmittedByLabel() {
        Assert.assertEquals(elements().successfullySubmittingFormMessage(),
                Constants_Registration_Page.SUCCESSFULLY_SUBMITTED_FORM_MSG);
    }
}

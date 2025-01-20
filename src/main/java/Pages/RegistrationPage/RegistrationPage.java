package Pages.RegistrationPage;

import Utils.readers.ConfigReader;
import Utils.models.RegistrationUser;
import Pages.BasePage;
import Utils.constants.Constants_Registration_Page;
import Utils.scripts.JS_Scripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    protected RegistrationPageElements elements() {
        return new RegistrationPageElements(Driver());
    }

    public RegistrationPageAssertions assertions() {
        return new RegistrationPageAssertions(Driver());
    }

    public void navigateTo() {
        Driver().get(ConfigReader.getConfig().getEnvironment().getBaseUrl() +
                Constants_Registration_Page.REGISTRATION_PAGE_TITLE);
    }

    public void removeFramesFromPage() {
        JS_Scripts.removeAllFrames(Driver());
    }

    public void fillRegistrationForm(RegistrationUser user) {
        removeFramesFromPage();

        populateField(elements().firstName(), user.getFirstName());
        populateField(elements().lastName(), user.getLastName());
        populateField(elements().eMail(), user.getEmail());
        selectFromMultipleOptions(elements().genders(), user.getGenders());
        populateField(elements().mobilePhone(), user.getPhoneNumber());

        scrollTheElementInToVIew(elements().calendarButton());
        clickOnElement(elements().calendarButton());

        populateBirthData(elements().monthDD(), user.getBirthMonth());
        populateBirthData(elements().yearDD(), user.getBirthYear());
        selectDateFromCalendar(user.getBirthDay());

        populateField(elements().subjectField(), user.getSubject());
        scrollToTheBottomOfTheForm();
        removeFramesFromPage();
        selectFromMultipleOptions(elements().hobbies(), user.getHobbies());
       // elements().picButton().sendKeys(user.getPicture());
        populateField(elements().currentAddressField(), user.getAddress());

        selectSpecificState(user.getState());
        selectSpecificCity(user.getCity());
        clickOnElement(elements().submitButton());
        Driver().switchTo().activeElement();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void populateBirthData(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectDateFromCalendar(String day) {
        List<WebElement> days = elements().dayCells();
        for (WebElement dayCell : days) {
            if (dayCell.getText().equals(day)) {
                dayCell.click();
                break;
            }
        }
    }

    public void populateField(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToTheBottomOfTheForm() {
        JS_Scripts.scrollToBottom(Driver());
    }

    public void scrollTheElementInToVIew(WebElement element) {
        JS_Scripts.scrollElementInToView(Driver(), element);
    };

    public void selectSpecificState(String state) {
        elements().stateDD().click();
        elements().stateValue(state).click();
    }

    public void selectSpecificCity(String city) {
        elements().cityDD().click();
        elements().cityValue(city).click();
    }

    public void selectFromMultipleOptions(List<WebElement> hobbies, List<Boolean> boolValue) {
        for (int i = 0; i < hobbies.size() - 1; i++) {
            if (boolValue.get(i)) {
                hobbies.get(i).click();
            }
        }
    }
}

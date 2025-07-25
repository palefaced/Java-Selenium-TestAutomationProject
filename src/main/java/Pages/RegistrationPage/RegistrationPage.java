package Pages.RegistrationPage;

import Utils.helpers.ElementActionsHelper;
import Utils.models.RegistrationPageUser;
import Utils.readers.ConfigReader;
import Pages.BasePage;
import Utils.constants.Constants_Registration_Page;
import Utils.scripts.JS_Scripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        ElementActionsHelper.tryToNavigateToURL(Driver(), ConfigReader.getConfig().getEnvironment().getBaseUrl() +
                Constants_Registration_Page.REGISTRATION_PAGE_TITLE);
    }

    public void removeFramesFromPage() {
        JS_Scripts.removeAllFrames(Driver());
    }

    public void scrollToTheBottomOfTheForm() {
        JS_Scripts.scrollToBottom(Driver());
    }

    public void scrollTheElementInToVIew(WebElement element) {
        JS_Scripts.scrollElementInToView(Driver(), element);
    }

    public void fillRegistrationForm(RegistrationPageUser user) throws InterruptedException {
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

        //elements().picButton().sendKeys(user.getPicture());
        //Ако ползваме CI (Jenkins/GHA) ни трябва абсолютен път до файл от нашата машина, а не локален
        elements().picButton().sendKeys(setAbsolutePath(user.getPicture()));

        populateField(elements().currentAddressField(), user.getAddress());
        selectSpecificState(user.getState());
        SelectSpecificCity(user.getCity());
        clickOnElement(elements().submitButton());
        Driver().switchTo().activeElement();
    }

    public void clickOnElement(WebElement element) {
        ElementActionsHelper.tryToClickOnElement(element);
    }

    public void populateField(WebElement element, String text) {
        ElementActionsHelper.trySendKeys(element, text);
    }

    public void populateBirthData(WebElement element, String text) {
        ElementActionsHelper.trySelectElement(element, text);
    }

    public void selectDateFromCalendar(String day) {
        ElementActionsHelper.trySelectDateFromCalendarWidget(elements().dayCells(), day);
    }

    public void selectSpecificState(String state) {
        ElementActionsHelper.tryToClickOnElement(elements().stateDD());
        ElementActionsHelper.tryToClickOnElement(elements().stateValue(state));
    }

    public void SelectSpecificCity(String city) {
        ElementActionsHelper.tryToClickOnElement(elements().cityDD());
        ElementActionsHelper.tryToClickOnElement(elements().cityValue(city));
    }

    public void selectFromMultipleOptions(List<WebElement> hobbies, List<Boolean> boolValue) {
        ElementActionsHelper.trySelectFromMultipleOptions(hobbies, boolValue);
    }

    public String setAbsolutePath(String relativePath) {
        return ElementActionsHelper.trySetAbsolutePathForFile(relativePath);
    }
}

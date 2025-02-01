package Pages.RegistrationPage;

import Utils.helpers.WebDriverHelper;
import Utils.readers.ConfigReader;
import Utils.models.RegistrationUser;
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
        WebDriverHelper.tryToNavigateToURL(Driver(), ConfigReader.getConfig().getEnvironment().getBaseUrl() +
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

    public void fillRegistrationForm(RegistrationUser user) throws InterruptedException {
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
        WebDriverHelper.tryToClickOnElement(element);
    }

    public void populateField(WebElement element, String text) {
        WebDriverHelper.trySendKeys(element, text);
    }

    public void populateBirthData(WebElement element, String text) {
        WebDriverHelper.trySelectElement(element, text);
    }

    public void selectDateFromCalendar(String day) {
        WebDriverHelper.trySelectDateFromCalendarWidget(elements().dayCells(), day);
    }

    public void selectSpecificState(String state) {
        WebDriverHelper.tryToClickOnElement(elements().stateDD());
        WebDriverHelper.tryToClickOnElement(elements().stateValue(state));
    }

    public void SelectSpecificCity(String city) {
        WebDriverHelper.tryToClickOnElement(elements().cityDD());
        WebDriverHelper.tryToClickOnElement(elements().cityValue(city));
    }

    public void selectFromMultipleOptions(List<WebElement> hobbies, List<Boolean> boolValue) {
        WebDriverHelper.trySelectFromMultipleOptions(hobbies, boolValue);
    }

    public String setAbsolutePath(String relativePath) {
        return WebDriverHelper.trySetAbsolutePathForFile(relativePath);
    }
}

package Pages.RegistrationPage;

import Pages.BasePage;
import Utils.helpers.ElementActionsHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPageElements extends BasePage {

    public RegistrationPageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement firstName() {
        return ElementActionsHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"firstName\"]"));
    }

    public WebElement lastName() {
        return ElementActionsHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"lastName\"]"));
    }

    public WebElement eMail() {
        return ElementActionsHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"userEmail\"]"));
    }

    //вземам ги като лист с общ къстъм Xpath, след това в основната страница въртя цикъл и си избирам кой да маркирам
    public List<WebElement> genders() {
        return ElementActionsHelper.tryFindElements(Driver(), By.xpath("//label[contains(@for, 'gender-radio-')]"));
    }

    public WebElement mobilePhone() {
        return ElementActionsHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"userNumber\"]"));
    }

    public WebElement calendarButton() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.id("dateOfBirthInput"));
    }

    public WebElement monthDD() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.xpath("//select[contains(@class, 'react-datepicker__month-select')]"));
    }

    public WebElement yearDD() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.xpath("//select[contains(@class, 'react-datepicker__year-select')]"));
    }

    public List<WebElement> dayCells() {
        return ElementActionsHelper.tryWaitForElementsToBeVisible(Driver(), By.xpath("//div[contains(@class, 'react-datepicker__day')]"));
    }

    public WebElement subjectField() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.xpath("//input[@id='subjectsInput']"));
    }

    public List<WebElement> hobbies() {
        return ElementActionsHelper.tryWaitForElementsToBeVisible(Driver(), By.xpath("//label[contains(@for, 'hobbies-checkbox-')]"));
    }

    public WebElement picButton() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.xpath("//*[@id=\"uploadPicture\"]"));
    }

    public WebElement currentAddressField() {
        return ElementActionsHelper.tryWaitForElementToBeVisible(Driver(), By.xpath("//*[@id=\"currentAddress\"]"));
    }

    public WebElement stateDD() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.id("state"));
    }

    public WebElement stateValue(String state) {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.xpath(String.format("//div[contains(text(),'%s')]", state)));
    }

    public WebElement cityDD() {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.id("city"));
    }

    public WebElement cityValue(String city) {
        return ElementActionsHelper.tryWaitForElementToBeClickable(Driver(), By.xpath(String.format("//div[contains(text(),'%s')]", city)));
    }

    public WebElement submitButton() {
        return ElementActionsHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"submit\"]"));
    }

    public String getFieldBackGroundImage(WebElement element) {
        return ElementActionsHelper.tryReturnCSSValue(element, "background-image");
    }

    public WebElement femaleGender() {
        return ElementActionsHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
    }

    public String getElementColor(WebElement element) {
        return ElementActionsHelper.tryReturnCSSValue(element, "color");
    }

    public String modalWindowMessage() {
        return ElementActionsHelper.tryWaitForElementToBeVisible(Driver(), By.id("example-modal-sizes-title-lg")).getText();
    }
}

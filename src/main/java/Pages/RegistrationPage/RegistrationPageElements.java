package Pages.RegistrationPage;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RegistrationPageElements extends BasePage {

    public RegistrationPageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement firstName() {
        return Driver().findElement(By.xpath("//*[@id=\"firstName\"]"));
    }

    public WebElement lastName() {
        return Driver().findElement(By.xpath("//*[@id=\"lastName\"]"));
    }

    public WebElement eMail() {
        return Driver().findElement(By.xpath("//*[@id=\"userEmail\"]"));
    }

    //вземам ги като лист с общ къстъм Xpath, след това в основната страница въртя цикъл и си избирам кой да маркирам
    public List<WebElement> genders() {
        return Driver().findElements(By.xpath("//label[contains(@for, 'gender-radio-')]"));
    }

    public WebElement mobilePhone() {
        return Driver().findElement(By.xpath("//*[@id=\"userNumber\"]"));
    }

    public WebElement calendarButton() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
    }

    public WebElement monthDD() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class, 'react-datepicker__month-select')]")));
    }

    public WebElement yearDD() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class, 'react-datepicker__year-select')]")));
    }

    public List<WebElement> dayCells() {
        return WaitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'react-datepicker__day')]")));
    }

    public WebElement subjectField() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']")));
    }

    public List<WebElement> hobbies() {
        return WaitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(@for, 'hobbies-checkbox-')]")));
    }

    public WebElement picButton() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uploadPicture\"]")));
    }

    public WebElement currentAddressField() {
        return WaitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subjectsInput']")));
    }

    public WebElement stateDD() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.id("state")));
    }

    public WebElement stateValue(String state) {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[contains(text(),'%s')]", state))));
    }

    public WebElement cityDD() {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.id("city")));
    }

    public WebElement cityValue(String city) {
        return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[contains(text(),'%s')]", city))));
    }

    public WebElement submitButton() {
        return this.Driver().findElement(By.xpath("//*[@id=\"submit\"]"));
    }

    public String getFieldBackGroundImage(WebElement element){
        return element.getCssValue("background-image");
    }

    public WebElement femaleGender(){
        return Driver().findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
    }

    public String getElementColor(WebElement element){
        return element.getCssValue("color");
    }

    public String successfullySubmittingFormMessage(){
        WebElement element = WaitFor(ExpectedConditions.visibilityOfElementLocated((By.id("example-modal-sizes-title-lg"))));
        return element.getText();
    }
}

package Pages.RegistrationPage;

import Pages.BasePage;
import Utils.helpers.WebDriverHelper;
import org.apache.hc.client5.http.HttpRoute;
import org.bouncycastle.crypto.agreement.ECDHCUnifiedAgreement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class RegistrationPageElements extends BasePage {

    public RegistrationPageElements(WebDriver driver) {
        super(driver);
    }

    public WebElement firstName() {
        return WebDriverHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"firstName\"]"));
    }

    public WebElement lastName() {
        return WebDriverHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"lastName\"]"));
    }

    public WebElement eMail() {
        return WebDriverHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"userEmail\"]"));
    }

    //вземам ги като лист с общ къстъм Xpath, след това в основната страница въртя цикъл и си избирам кой да маркирам
    public List<WebElement> genders() {
        return WebDriverHelper.tryFindElements(Driver(), By.xpath("//label[contains(@for, 'gender-radio-')]"));
    }

    public WebElement mobilePhone() {
        return WebDriverHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"userNumber\"]"));
    }

    public WebElement calendarButton() {
        return WebDriverHelper.tryWaitForElementToBeClickable(Driver(), By.id("dateOfBirthInput"));
    }

    public WebElement monthDD() {
        return WebDriverHelper.tryWaitForElementToBeClickable(Driver(), By.xpath("//select[contains(@class, 'react-datepicker__month-select')]"));
    }

    public WebElement yearDD() {
        return WebDriverHelper.tryWaitForElementToBeClickable(Driver(), By.xpath("//select[contains(@class, 'react-datepicker__year-select')]"));
    }

    public List<WebElement> dayCells() {
        try {
            return WaitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'react-datepicker__day')]")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement subjectField() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='subjectsInput']")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public List<WebElement> hobbies() {
        try {
            return WaitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[contains(@for, 'hobbies-checkbox-')]")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement picButton() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"uploadPicture\"]")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement currentAddressField() {
        try {
            return WaitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"currentAddress\"]")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement stateDD() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.id("state")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement stateValue(String state) {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[contains(text(),'%s')]", state))));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement cityDD() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.id("city")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement cityValue(String city) {
        return WebDriverHelper.tryWaitForElementToBeClickable(Driver(), By.xpath(String.format("//div[contains(text(),'%s')]", city)));
    }

    public WebElement submitButton() {
        return WebDriverHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"submit\"]"));
    }

    public String getFieldBackGroundImage(WebElement element) {
        try {
            return element.getCssValue("background-image");
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement femaleGender() {
        return WebDriverHelper.tryFindElement(Driver(), By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
    }

    public String getElementColor(WebElement element) {
        return element.getCssValue("color");
    }

    public String successfullySubmittingFormMessage() {
        try {
            WebElement element = WaitFor(ExpectedConditions.visibilityOfElementLocated((By.id("example-modal-sizes-title-lg"))));
            return element.getText();
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }
}

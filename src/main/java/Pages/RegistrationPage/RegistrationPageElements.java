package Pages.RegistrationPage;

import Pages.BasePage;
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
        try {
            return Driver().findElement(By.xpath("//*[@id=\"firstName\"]"));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement lastName() {
        try {
            return Driver().findElement(By.xpath("//*[@id=\"lastName\"]"));

        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement eMail() {
        try {
            return Driver().findElement(By.xpath("//*[@id=\"userEmail\"]"));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    //вземам ги като лист с общ къстъм Xpath, след това в основната страница въртя цикъл и си избирам кой да маркирам
    public List<WebElement> genders() {
        try {
            return Driver().findElements(By.xpath("//label[contains(@for, 'gender-radio-')]"));

        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement mobilePhone() {
        try {
            return Driver().findElement(By.xpath("//*[@id=\"userNumber\"]"));

        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement calendarButton() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.id("dateOfBirthInput")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement monthDD() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class, 'react-datepicker__month-select')]")));

        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement yearDD() {
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath("//select[contains(@class, 'react-datepicker__year-select')]")));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
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
            return WaitFor(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subjectsInput']")));
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
        try {
            return WaitFor(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[contains(text(),'%s')]", city))));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement submitButton() {
        try {
            return this.Driver().findElement(By.xpath("//*[@id=\"submit\"]"));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public String getFieldBackGroundImage(WebElement element) {
        try {
            return element.getCssValue("background-image");
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
    }

    public WebElement femaleGender() {
        try {
            return Driver().findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
        } catch (Exception e) {
            throw new RuntimeException("Element not found: " + e.getMessage());
        }
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

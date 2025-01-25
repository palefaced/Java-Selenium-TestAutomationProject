package Pages.RegistrationPage;

import Utils.readers.ConfigReader;
import Utils.models.RegistrationUser;
import Pages.BasePage;
import Utils.constants.Constants_Registration_Page;
import Utils.scripts.JS_Scripts;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
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
        try {
            Driver().get(ConfigReader.getConfig().getEnvironment().getBaseUrl() +
                    Constants_Registration_Page.REGISTRATION_PAGE_TITLE);
        } catch (Exception e) {
            System.out.println("Failed to navigate to the URL: " + e.getMessage());
        }
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

        //elements().picButton().sendKeys(user.getPicture());
        //Ако ползваме CI (Jenkins/GHA) ни трябва абсолютен път до файл от нашата машина, а не локален
        elements().picButton().sendKeys(setAbsolutePathForImage(user.getPicture()));

        populateField(elements().currentAddressField(), user.getAddress());
        selectSpecificState(user.getState());
        selectSpecificCity(user.getCity());
        clickOnElement(elements().submitButton());
        Driver().switchTo().activeElement();
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("option not found: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be clicked: " + e.getMessage());
        }
    }

    public void populateBirthData(WebElement element, String text) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be selected: " + e.getMessage());
        }
    }

    public void selectDateFromCalendar(String day) {
        try {
            List<WebElement> days = elements().dayCells();
            for (WebElement dayCell : days) {
                if (dayCell.getText().equals(day)) {
                    dayCell.click();
                    break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be selected: " + e.getMessage());
        }
    }

    public void populateField(WebElement element, String text) {
        try {
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be populated" + e.getMessage());
        }

    }

    public void selectSpecificState(String state) {
        try {
            elements().stateDD().click();
            elements().stateValue(state).click();
        } catch (Exception e) {
            throw new RuntimeException("Element failed to be selected: " + e.getMessage());
        }
    }

    public void selectSpecificCity(String city) {
        try {
            elements().cityDD().click();
            elements().cityValue(city).click();
        } catch (Exception e) {
            System.out.println("Element failed to be selected: " + city);
        }
    }

    public void selectFromMultipleOptions(List<WebElement> hobbies, List<Boolean> boolValue) {
        try {
            for (int i = 0; i < hobbies.size() - 1; i++) {
                if (boolValue.get(i)) {
                    hobbies.get(i).click();
                }
            }
        } catch (Exception exp) {
            System.out.println("Element failed to be selected: " + exp.getMessage());
        }
    }

    public String setAbsolutePathForImage(String relativePath) {
        try {
            File file = new File(relativePath);
            return file.getAbsolutePath();
        } catch (Exception e) {
            throw new RuntimeException(Constants_Registration_Page.FILE_NOT_FOUND_ERROR_MSG + relativePath);
        }
    }
}

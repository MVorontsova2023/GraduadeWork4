package ui.e2e;

import ui.pages.BasePage;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SignUpPage extends  BasePage  {
    public SelenideElement selectRole = $x("//button[@title='Select your role']");
    public SelenideElement fullNameField = $x("//input[@name='full_name']");
    public SelenideElement emailField = $x("//input[@name='static_email']");
    public SelenideElement passwordField = $x("//input[@name='password']");
//    public SelenideElement uncheckedCheckBox = $x("//input[@type='checkbox']");
    public SelenideElement signUpButton = $("a[id='sw-sign-up-submit-btn']");

    public SelenideElement signInButton = $("a[id='sw-go-to-sign-in-btn']");
    public SelenideElement showPassword = $x("//i[contains(@class, 'fa-eye-slash')]");
    public SelenideElement avatarCurrentUser = $x("//button[contains(@class,'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-17qbyv7')]");
    public SelenideElement profileCurrentUser = $x("//a[@href='/user-profile']");
    public SelenideElement roleTeacher = $x("//span[text()='teacher']");
    public SelenideElement roleStudent = $x("//span[text()='student']");
    public SelenideElement emptyErrorMessage = $x("//div[text()='        Please make sure there are no empty required fields.']");
    public SelenideElement passwordErrorMessage = $x("//div[@class='validation-message d-none d-block']");
    public SelenideElement agreeCheckBox = $x("//span[@class='checkmark position-relative sw-checkbox']");

    public void selectRole(Boolean isStudent) {
        selectRole.shouldBe(visible);
        selectRole.click();
        if (isStudent) {
            roleStudent.shouldBe(enabled).click();
        }
        else {
            roleTeacher.shouldBe(enabled).click();
        }
    }
}

package ui.e2e;

import ui.pages.BasePage;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
public class SignInPage extends  BasePage{
    public SelenideElement emailField = $x("//input[@name='email']");
    public SelenideElement passwordField = $x("//input[@name='password']");
    public SelenideElement signInButton = $x("//a[@id='sw-sign-in-submit-btn']");
    public SelenideElement showPassword = $x("//i[contains(@class, 'fa-eye-slash')]");
    public SelenideElement linkForgotPassword = $x("//a[@href='/forgot-password']");
    public SelenideElement signUpButton = $x("//*[@id='sw-go-to-sign-up-btn']");
    public SelenideElement avatarCurrentUser = $x("//button[contains(@class,'MuiButton')]");
    public SelenideElement profileCurrentUser = $x("//a[@href='/user-profile']");
    public SelenideElement emailFieldCurrentUser = $x("//input[@placeholder='Email']");
    public SelenideElement errorMassage = $x("//div[text()='Invalid email or password']");
}

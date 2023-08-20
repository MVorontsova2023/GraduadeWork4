package ui.tests;

import api.ApiBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.e2e.SignInPage;
import ui.e2e.SignUpPage;
import ui.pages.ProfileUserPage;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Authorization Test")
class SignInPageTest extends BasePageTest {
    private static SignInPage signInPage;
    private static ProfileUserPage profileUserPage;

    @BeforeEach
    void setUp() {
        open(BASE_URL + "/sign-in");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        signInPage = new SignInPage();
        profileUserPage = new ProfileUserPage();
    }

    @Test
    @DisplayName("Successful student authorization")
    public void successSignInAsStudent() {
        signInPage.emailField.shouldBe(enabled).setValue(STUDENT_EMAIL);
        signInPage.passwordField.shouldBe(enabled).setValue(STUDENT_PASSWORD);
        signInPage.signInButton.shouldBe(enabled).click();
        Selenide.sleep(3000L);
        signInPage.avatarCurrentUser.click();
        signInPage.profileCurrentUser.click();
        Selenide.sleep(3000L);
        Assertions.assertEquals(profileUserPage.getEmail(),STUDENT_EMAIL);
    }

    @Test
    @DisplayName("Successful teacher authorization")
    public void successSignInAsTeacher() {
        signInPage.emailField.shouldBe(enabled).setValue(TEACHER_EMAIL);
        signInPage.passwordField.shouldBe(enabled).setValue(TEACHER_PASSWORD);
        signInPage.signInButton.shouldBe(enabled).click();
        Selenide.sleep(3000L);
        signInPage.avatarCurrentUser.click();
        signInPage.profileCurrentUser.click();
        Selenide.sleep(3000L);
        Assertions.assertEquals(profileUserPage.getEmail(),TEACHER_EMAIL);
    }

    @Test
    @DisplayName("Authorization with empty email field")
    public void emptyEmailField() {
        signInPage.emailField.shouldBe(enabled).setValue("");
        signInPage.passwordField.shouldBe(enabled).setValue("123456");
        signInPage.signInButton.shouldBe(enabled).click();
        signInPage.errorMassage.shouldHave(text("Invalid email or password"));
    }

    @Test
    @DisplayName("Authorization with empty password field")
    public void emptyPasswordField() {
        signInPage.emailField.shouldBe(enabled).setValue("malik@example.com");
        signInPage.passwordField.shouldBe(enabled).setValue("");
        signInPage.signInButton.shouldBe(enabled).click();
        signInPage.errorMassage.shouldHave(text("Invalid email or password"));
    }

    @Test
    @DisplayName("Authorization with invalid Email and valid password")
    public void invalidEmailValidPassword() {
        signInPage.emailField.shouldBe(enabled).setValue("malikexample.com");
        signInPage.passwordField.shouldBe(enabled).setValue("123456");
        signInPage.signInButton.shouldBe(enabled).click();
        signInPage.errorMassage.shouldHave(text("Invalid email or password"));
    }

    @Test
    @DisplayName("Authorization with valid Email and invalid password")
    public void invalidPasswordValidEmail() {
        signInPage.emailField.shouldBe(enabled).setValue("malik@example.com");
        signInPage.passwordField.shouldBe(enabled).setValue("12345");
        signInPage.signInButton.shouldBe(enabled).click();

        signInPage.errorMassage.shouldHave(text("Invalid email or password"));;
    }

    @Test
    @DisplayName("Check function forgot password")
    public void forgotPassword() {
        signInPage.emailField.shouldBe(enabled).setValue("malik@example.com");
        signInPage.passwordField.shouldBe(enabled).setValue("");
        signInPage.linkForgotPassword.click();
        String s = WebDriverRunner.url();
        Assertions.assertTrue(WebDriverRunner.url().contains("forgot"));
    }

    @Test
    @DisplayName("Check correct function Sing up button")
    public void validSignUpHeaderButton() {
        signInPage.signUpButton.click();
        Assertions.assertTrue(WebDriverRunner.url().contains("sign-up"));
    }
}
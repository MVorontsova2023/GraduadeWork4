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
import ui.e2e.SignUpPage;
import ui.pages.ProfileUserPage;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Registration Test")
class SignUpPageTest extends BasePageTest {
    private static SignUpPage signUpPage;
    private static ProfileUserPage profileUserPage;
    private Random random = new Random();
    @BeforeEach
    void setUp() {
        open(BASE_URL + "/sign-up");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        signUpPage = new SignUpPage();
        profileUserPage = new ProfileUserPage();
    }
    @Test
    @DisplayName("Successful student registration")
    public void successSignUpAsStudent() {
        String randomNum = String.format("%d",random.nextInt(1000));
        String userEmail = "johnr" + randomNum + "@example.com";
        String userName = "John Richardson" + randomNum;
        System.out.println(userName);
        System.out.println(userEmail);
        signUpPage.selectRole(true);
        signUpPage.fullNameField.shouldBe(enabled).setValue(userName);
        signUpPage.emailField.shouldBe(enabled).setValue(userEmail);
        signUpPage.passwordField.shouldBe(enabled).setValue("12345678");
        signUpPage.agreeCheckBox.click();
        signUpPage.signUpButton.click();
        Selenide.sleep(3000L);
        signUpPage.avatarCurrentUser.shouldBe(visible).click();
        signUpPage.profileCurrentUser.click();
        Selenide.sleep(3000L);
        Assertions.assertEquals(profileUserPage.getEmail(),userEmail);
        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(userEmail);
    }

    @Test
    @DisplayName("Successful teacher registration")
    public void successSignUpAsTeacher() {
        String randomNum = String.format("%d",random.nextInt(1000));
        String userEmail = "johnr" + randomNum + "@gmail.com";
        String userName = "John Richardson" + randomNum;
        System.out.println(userName);
        System.out.println(userEmail);
        signUpPage.selectRole(false);
        signUpPage.fullNameField.shouldBe(enabled).setValue(userName);
        signUpPage.emailField.shouldBe(enabled).setValue(userEmail);
        signUpPage.passwordField.shouldBe(enabled).setValue("12345678");
        signUpPage.agreeCheckBox.click();
        signUpPage.signUpButton.click();
        Selenide.sleep(3000L);
        signUpPage.avatarCurrentUser.shouldBe(visible).click();
        Selenide.sleep(3000L);
        signUpPage.profileCurrentUser.click();
        Selenide.sleep(3000L);
        Assertions.assertEquals(profileUserPage.getEmail(), userEmail);

        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(userEmail);
    }

    @Test
    @DisplayName("Registration with a short password")
    public void ValidFullNameValidEmailInValidPassword() {
        signUpPage.selectRole(true);
        signUpPage.fullNameField.shouldBe(enabled).setValue("malik");
        signUpPage.emailField.shouldBe(enabled).setValue("malik@exampele.com");
        signUpPage.passwordField.shouldBe(enabled).setValue("12345");
        signUpPage.agreeCheckBox.click();
        signUpPage.signUpButton.click();
        signUpPage.passwordErrorMessage.shouldHave(text("Password must contain at least 6 characters"));
    }

    @Test
    @DisplayName("Registration without sign @ in email field")
    public void ValidFullNameInvalidEmailValidPassword() {
        signUpPage.selectRole(true);
        signUpPage.fullNameField.shouldBe(enabled).setValue("malik");
        signUpPage.emailField.shouldBe(enabled).setValue("malikexampele.com");
        signUpPage.passwordField.shouldBe(enabled).setValue("123456");
        signUpPage.agreeCheckBox.click();
        signUpPage.signUpButton.click();
        signUpPage.emptyErrorMessage.shouldHave(text("Please make sure there are no empty required fields."));
    }

    @Test
    @DisplayName("Registration with empty full name field")
    public void EmptyFullNameValidEmailValidPassword() {
        signUpPage.selectRole(true);
        signUpPage.fullNameField.shouldBe(enabled).setValue("");
        signUpPage.emailField.shouldBe(enabled).setValue("malik@exampele.com");
        signUpPage.passwordField.shouldBe(enabled).setValue("123456");
        signUpPage.agreeCheckBox.click();
        signUpPage.signUpButton.click();
        signUpPage.emptyErrorMessage.shouldHave(text("Please make sure there are no empty required fields"));
    }

    @Test
    @DisplayName("Registration with empty check-box")
    public void UnCheckAgreeBoxAllFieldCorrect() {
        signUpPage.selectRole(true);
        signUpPage.fullNameField.shouldBe(enabled).setValue("Malik");
        signUpPage.emailField.shouldBe(enabled).setValue("malik@exampele.com");
        signUpPage.passwordField.shouldBe(enabled).setValue("123456");
        signUpPage.signUpButton.click();
        signUpPage.emptyErrorMessage.shouldHave(text("Please make sure there are no empty required field"));
    }
}
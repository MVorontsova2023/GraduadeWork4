package ui.tests;

import api.ApiBase;
import com.codeborne.selenide.*;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import ui.e2e.SignUpPage;
import ui.pages.*;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Student Details Page Test")
class StudentDetailsPageTest extends BasePageTest {
    private static SignUpPage signUpPage;
    private static StudentDetailsPage studentDetailsPage;
    private static StudentDirectoryPage studentDirectoryPage;
    private static StudentMainPage studentMainPage;
    private Random random = new Random();
    @BeforeEach
    void setUp() {
        open(BASE_URL + "/sign-up");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        signUpPage = new SignUpPage();
        studentDetailsPage = new StudentDetailsPage();
        studentMainPage = new StudentMainPage();
        studentDirectoryPage = new StudentDirectoryPage();
    }
    @Test
    public void validStudentDetailsSearch() {
        String randomNum = String.format("%d",random.nextInt(1000));
        String userEmail = "johnr" + randomNum + "@gmail.com";
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

        studentMainPage.linkHeaderStudentDirectory.shouldBe(visible).click();

        studentDirectoryPage.searchStudentField.shouldBe(enabled).setValue("John Richardson");
        Selenide.sleep(3000L);

        studentDirectoryPage.viewProfileButton.click();

        Selenide.sleep(3000L);
        assertEquals(1,studentDetailsPage.profileEmailCollection.size());

        ApiBase apiBase = new ApiBase();
        apiBase.deleteRequest(userEmail);
    }
}
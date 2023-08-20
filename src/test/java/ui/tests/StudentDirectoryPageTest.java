package ui.tests;

import com.codeborne.selenide.*;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import ui.pages.StudentDirectoryPage;
import ui.pages.StudentDetailsPage;
import ui.pages.TeacherMainPage;
import ui.pages.StudentMainPage;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Student Directory Page Test")
class StudentDirectoryPageTest extends BasePageTest {
private static StudentDirectoryPage studentDirectoryPage;
private static StudentMainPage studentMainPage;
    @BeforeEach
    void setUp() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        studentDirectoryPage = new StudentDirectoryPage();
        studentMainPage = new StudentMainPage();
        studentDirectoryPage.login(STUDENT_EMAIL, STUDENT_PASSWORD);
        studentMainPage.linkHeaderStudentDirectory.shouldBe(visible).click();
    }

    @Test
    @DisplayName("Checking the search by student name on student-directory page")
    public void validStudentsSearch() {
        studentDirectoryPage.searchStudentField.shouldBe(enabled).setValue("mari");
        Selenide.sleep(3000L);
        for (int i =0; i < studentDirectoryPage.searchedStudentsCollection.size(); i++) {
            SelenideElement el = studentDirectoryPage.searchedStudentsCollection.get(i);
            el.shouldBe(visible).shouldHave(text("student"));
        }
    }
}
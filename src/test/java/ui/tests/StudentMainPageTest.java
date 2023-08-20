package ui.tests;

import com.codeborne.selenide.*;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import ui.pages.StudentMainPage;
import ui.pages.TeacherMainPage;
import ui.pages.CourseListPage;

import java.util.Random;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Student Main Page Test")
class StudentMainPageTest extends BasePageTest {
    private static StudentMainPage studentMainPage;

    @BeforeEach
    void setUp() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        studentMainPage = new StudentMainPage();
        studentMainPage.login(STUDENT_EMAIL, STUDENT_PASSWORD);
        Selenide.sleep(3000L);
    }
    @Test
    @DisplayName("Check links About us in header")
    public void validAboutAsHeaderLink() {
        studentMainPage.linkHeaderAbout.click();
        Assertions.assertTrue(WebDriverRunner.url().contains("about-us"));
    }
    @Test
    @DisplayName("Check link Courses in header")
    public void validCoursesHeaderLink() {
        Selenide.sleep(3000L);
        studentMainPage.linkHeaderCourses.shouldBe(enabled).click();
        studentMainPage.linkHeaderCoursesList.shouldBe(enabled).click();
        assertTrue(WebDriverRunner.url().contains("course-list"));
    }
    @Test
    @DisplayName("Check link Professors in header")
    public void validProfessorsHeaderLink() {
        studentMainPage.linkHeaderProfessors.click();
        assertTrue(WebDriverRunner.url().contains("teacher-spotlight-heading"));
    }
    @Test
    @DisplayName("Check link Student directory in header")
    public void validStudentDirectoryHeaderLink() {
        studentMainPage.linkHeaderStudentDirectory.click();
        assertTrue(WebDriverRunner.url().contains("student-directory"));
    }
    @Test
    @DisplayName("Check button Avatar user in header")
    public void validAvatarHeaderLink() {
        studentMainPage.avatarHeaderButton.click();
        studentMainPage.myProfilePopUpAvatarButton.click();
        assertTrue(WebDriverRunner.url().contains("user-profile"));
    }
    @Test
    @DisplayName("Check button View Profile")
    public void validViewProfileButton() {
        studentMainPage.linkHeaderProfessors.shouldBe(visible).click();
        studentMainPage.viewProfileButton.click();
        assertTrue(WebDriverRunner.url().contains("details"));
    }
    @Test
    @DisplayName("Check button  View courses")
    public void validViewCoursesButton() {
        studentMainPage.viewCoursesButton.click();
        assertTrue(WebDriverRunner.url().contains("course-list"));
    }
    @Test
    @DisplayName("Check button Meet Your Peers")
    public void validMeetYourPeersButton() {
        studentMainPage.meetYourPeersButton.click();
        assertTrue(WebDriverRunner.url().contains("student-directory"));
    }
    @Test
    @DisplayName("Check Professor Spotlight search")
    public void validProfessorsSpotlightSearch() {
        studentMainPage.coursesProfessorListSearchField.shouldBe(enabled).setValue("ma");
        Selenide.sleep(3000L);
        for (int i = 0; i < studentMainPage.linkSearchedProfessorCollection.size(); i++) {
            SelenideElement el = studentMainPage.linkSearchedProfessorCollection.get(i);
            el.shouldBe(visible).shouldHave(text("teacher"));
        }
    }
}

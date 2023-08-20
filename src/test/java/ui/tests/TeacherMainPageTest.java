package ui.tests;

import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.ProfileUserPage;
import ui.pages.TeacherMainPage;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Teacher Main Page Test")
class TeacherMainPageTest extends BasePageTest {
    private static TeacherMainPage teacherMainPage;
    private static ProfileUserPage profileUserPage;

    @BeforeEach
    void setUp() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        teacherMainPage = new TeacherMainPage();
        profileUserPage = new ProfileUserPage();
        teacherMainPage.login(TEACHER_EMAIL, TEACHER_PASSWORD);
    }
    @Test
    @DisplayName("Check links About us in header")
    public void validAboutAsHeaderLink() {
        teacherMainPage.linkHeaderAbout.click();
        Assertions.assertTrue(WebDriverRunner.url().contains("about-us"));
    }
    @Test
    @DisplayName("Check link Courses in header")
    public void validCoursesHeaderLink() {
        Selenide.sleep(3000L);
        teacherMainPage.linkHeaderCourses.shouldBe(visible).click();
        teacherMainPage.linkHeaderCoursesList.shouldBe(visible).click();
        assertTrue(WebDriverRunner.url().contains("course-list"));
    }
    @Test
    @DisplayName("Check linksProfessors in header")
    public void validProfessorsHeaderLink() {
        teacherMainPage.linkHeaderProfessors.click();
        assertTrue(WebDriverRunner.url().contains("teacher-spotlight-heading"));
    }
    @Test
    @DisplayName("Check link Student directory in header")
    public void validStudentDirectoryHeaderLink() {
        teacherMainPage.linkHeaderStudentDirectory.click();
        assertTrue(WebDriverRunner.url().contains("student-directory"));
    }
    @Test
    public void validAddACourseHeaderFirstButton() {
        teacherMainPage.addCourseHeaderButton.click();
        Selenide.sleep(3000L);
        assertTrue(WebDriverRunner.url().contains("add-course"));
    }
    @Test
    public void validAddCourseHeaderSecondButton() {
        teacherMainPage.addCourseHeaderButton.click();
        assertTrue(WebDriverRunner.url().contains("add-course"));
    }
    @Test
    @DisplayName("Check button Avatar  My profile user in header")
    public void validMyProfilePopUpAvatarButton() {
        teacherMainPage.avatarHeaderButton.click();
        teacherMainPage.myProfilePopUpAvatarButton.click();
        assertTrue(WebDriverRunner.url().contains("user-profile"));
    }
    @Test
    @DisplayName("Check button View Courses")
    public void validViewCoursesButton() {
        teacherMainPage.viewCoursesButton.click();
        assertTrue(WebDriverRunner.url().contains("course-list"));
    }
    @Test
    @DisplayName("Check button Student Directory")
    public void validStudentDirectoryButton() {
        teacherMainPage.linkHeaderStudentDirectory.click();
        assertTrue(WebDriverRunner.url().contains("student-directory"));
    }
    @Test
    @DisplayName("Check button View Profile")
    public void validViewProfileButton() {
        teacherMainPage.viewProfileButton.click();
        assertTrue(WebDriverRunner.url().contains("details"));
    }
    @Test
    @DisplayName("Check Professor Spotlight search")
    public void validProfessorsSpotlightSearch() {
        teacherMainPage.coursesProfessorListSearchField.shouldBe(enabled).setValue("ma");
        Selenide.sleep(3000L);
        for (int i =0; i < teacherMainPage.linkSearchedProfessorCollection.size(); i++) {
            SelenideElement el = teacherMainPage.linkSearchedProfessorCollection.get(i);
            el.shouldBe(visible).shouldHave(text("teacher"));
        }
    }
}
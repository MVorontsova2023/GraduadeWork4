package ui.tests;

import static com.codeborne.selenide.Condition.text;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.CourseListDetailsPage;
import ui.pages.CourseListPage;
import ui.pages.TeacherMainPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Course List Details Page Test")
class CourseListDetailsPageTest extends BasePageTest {
    private static CourseListDetailsPage courseListDetailsPage;
    private static TeacherMainPage teacherMainPage;
    private static CourseListPage courseListPage;
    @BeforeEach
    void setUp() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        courseListDetailsPage = new CourseListDetailsPage();
        courseListPage = new CourseListPage();
        teacherMainPage = new TeacherMainPage();
        courseListDetailsPage.login(TEACHER_EMAIL, TEACHER_PASSWORD);
    }
    @Test
    @DisplayName("Checking the name of professor on сourse-details page")
    public void validCourseSearchDetails() {
        Selenide.sleep(3000L);
        teacherMainPage.linkHeaderCourses.shouldBe(enabled).click();
        teacherMainPage.linkHeaderCoursesList.shouldBe(enabled).click();

        String sSearchText = "Roxanne";

        courseListPage.coursesListSearchField.shouldBe(enabled).setValue(sSearchText);
        Selenide.sleep(3000L);
        courseListPage.selectedCourseCollection.get(0).pressEnter();
        courseListDetailsPage.courseProfessorField.shouldHave(text(sSearchText));
    }
}
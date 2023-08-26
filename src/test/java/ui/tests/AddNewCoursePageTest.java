package ui.tests;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.pages.AddNewCoursePage;
import ui.pages.TeacherMainPage;
import ui.pages.CourseListPage;
import java.util.Random;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Add NewCourse Page Test")
class AddNewCoursePageTest extends BasePageTest {
    private static AddNewCoursePage addNewCoursePage;
    private static TeacherMainPage teacherMainPage;
    private static CourseListPage courseListPage;
    @BeforeEach
    void setUp() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        addNewCoursePage = new AddNewCoursePage();
        teacherMainPage = new TeacherMainPage();
        courseListPage = new CourseListPage();
    }
    @Test
    @DisplayName("Create a new course as teacher")
    public void ValidAddNewCourse() {
        addNewCoursePage.login(TEACHER_EMAIL, TEACHER_PASSWORD);
        teacherMainPage.addCourseHeaderButton.shouldBe(enabled).click();

        Random random = new Random();
        String courseName = "New course " + String.format("%d",random.nextInt(1000));

        addNewCoursePage.courseNameField.shouldBe(enabled).setValue(courseName);
        addNewCoursePage.selectFacultyList.shouldBe(enabled).click();
        addNewCoursePage.selectFacultyCollection.get(random.nextInt(4)).click();
        addNewCoursePage.descriptionField.shouldBe(enabled).setValue("Description");
        addNewCoursePage.courseStartDateField.click();
        addNewCoursePage.selectDaysCollection.get(random.nextInt(5)).pressEnter();
        addNewCoursePage.courseEndDateField.click();
        addNewCoursePage.selectDaysCollection.get(5+random.nextInt(5)).pressEnter();
        addNewCoursePage.addCourseButton.click();
        teacherMainPage.linkHeaderCourses.shouldBe(enabled).click();
        teacherMainPage.linkHeaderCoursesList.shouldBe(enabled).click();
        // find added course in course list
        courseListPage.coursesListSearchField.setValue(courseName);
        Selenide.sleep(3000L);

        assertEquals(1,courseListPage.selectedCourses.size());
    }
}
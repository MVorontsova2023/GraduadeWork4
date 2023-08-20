package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
public class TeacherMainPage extends BasePage  {
    public SelenideElement linkHeaderAbout = $x("//span[text()='About Us']");

    public SelenideElement linkHeaderCourses = $x("//span[text()='Courses']").parent();
    public SelenideElement linkHeaderCoursesList = $x("//span[text()='Course list']");

    public SelenideElement linkHeaderProfessors = $x("//span[text()='Professors']");
    public SelenideElement linkHeaderStudentDirectory = $x("//span[text()='Student Directory']");
    public SelenideElement signInHeaderButton = $x("//span[text()='Sign in']");
    public SelenideElement sigUpHeaderButton = $x("//span[text()='Sign up']");
//    public SelenideElement addCourseHeaderButton = $x("//span[text()='Add course']");
    public SelenideElement addCourseHeaderButton = $x("//a[@href='/add-course']//span[contains(@class,'MuiBox-root')]").parent();
    public ElementsCollection linkCoursesCollection = $$x("//a[contains(text(),'GO TO -')]");
    public ElementsCollection linkProfessorSpotlightCollection = $$x("//div[@class='horizontal-list-item']");
    public SelenideElement viewProfileButton = $x("//a[text()='View profile']");
    public SelenideElement viewCoursesButton = $x("//a[@href='/course-list']");
    public SelenideElement avatarHeaderButton = $x("//button[contains(@class,'MuiButtonBase-root')]");
    public SelenideElement myProfilePopUpAvatarButton = $x("//span[text() = 'My Profile']");
    public ElementsCollection linkSearchedProfessorCollection = $$x("//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 test css-')]//p");

    public SelenideElement coursesProfessorListSearchField = $x("//input[@placeholder='Search by course name or professor']");
}

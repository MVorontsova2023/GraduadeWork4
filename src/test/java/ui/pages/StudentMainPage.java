package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
public class StudentMainPage extends BasePage {
    public SelenideElement linkHeaderAbout = $x("//span[text()='About Us']");
    public SelenideElement linkHeaderCourses = $x("//span[text()='Courses']");
    public SelenideElement linkHeaderCoursesList = $x("//span[text()='Course list']");
    public SelenideElement linkHeaderProfessors = $x("//span[text()='Professors']");
    public SelenideElement linkHeaderStudentDirectory = $x("//span[text()='Student Directory']");
    public SelenideElement avatarHeaderButton = $x("//button[contains(@class,'MuiButtonBase-root')]");
    public SelenideElement viewProfileButton = $x("//a[text()='View profile']");
    public SelenideElement myProfilePopUpAvatarButton = $x("//span[text() = 'My Profile']");
    public SelenideElement viewCoursesButton = $x("//a[@href='/course-list']");
    public SelenideElement meetYourPeersButton = $x("//a[text()='        Meet Your Peers       ']");
    public SelenideElement coursesProfessorListSearchField = $x("//input[@placeholder='Search by course name or professor']");
    public ElementsCollection linkSearchedProfessorCollection = $$x("//div[contains(@class,'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 test css-')]//p");

}

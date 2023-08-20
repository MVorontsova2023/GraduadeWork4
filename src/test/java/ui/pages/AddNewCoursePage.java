package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class AddNewCoursePage extends BasePage {
    public SelenideElement courseNameField = $x("//input[contains(@id,'course-documents-form-CourseName')]");
    public SelenideElement selectFacultyList = $x("//div[contains(@id,'course-documents-form-Faculty')]");
    public ElementsCollection selectFacultyCollection = $$x("//ul[@role='listbox']//li");
    public SelenideElement descriptionField = $x("//textarea[contains(@id,'course-documents-form-Description')]");
    public SelenideElement courseStartDateField = $x("//input[contains(@id,'course-documents-form-Startdate')]");
    public SelenideElement courseEndDateField = $x("//input[contains(@id,'course-documents-form-Enddate')]");
    public ElementsCollection selectDaysCollection = $$x("//div[@class ='rdrDays']//button[@class='rdrDay']");
    public SelenideElement addCourseButton = $x("//button[text()='Add']");
}

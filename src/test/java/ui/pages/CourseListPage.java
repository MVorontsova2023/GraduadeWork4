package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CourseListPage  extends BasePage{
    public SelenideElement searchField = $x("//input[contains(@placeholder,'Search by course name or professor')]");
    public SelenideElement coursesListSearchField = $x("//div[contains(@class,'MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedStart MuiInputBase-adornedEnd css')]//input");
    public ElementsCollection selectedCourses = $$x("//div[@class='list-action-wrapper']");
    public ElementsCollection courseCollection = $$x("//div[@class='list-container']//div");
    public ElementsCollection selectedCourseCollection = $$x("//a[contains(@href, '/course-details')]");
}

package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CourseListDetailsPage   extends BasePage{
    public SelenideElement courseNameField = $x("//h3[contains(@class, 'MuiBox-root css-cqzvlf')]");
    public SelenideElement courseProfessorField = $x("//h3[contains(@class,'MuiBox-root css-qgafyp')]");
}

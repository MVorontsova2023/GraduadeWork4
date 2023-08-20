package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
public class StudentDirectoryPage  extends BasePage{
    public SelenideElement searchStudentField = $x("//input[@placeholder='Start typing to search']");
    public ElementsCollection searchedStudentsCollection = $$x("//div[contains(@class, 'MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-sm-4 test css')]//span[contains(@class, 'MuiChip-label MuiChip-labelMedium css')]");
    public SelenideElement viewProfileButton = $x("//a[text()='View profile']");
    public SelenideElement emailSelectedStudentField =$x("//div[contains(@class,'MuiBox-root css-0')]//p[contains(text(),'johnr')]");
}

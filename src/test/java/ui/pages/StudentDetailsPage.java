package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
public class StudentDetailsPage extends BasePage  {
    public ElementsCollection profileEmailCollection = $$x("//p[contains(text(), 'johnr')]");
}

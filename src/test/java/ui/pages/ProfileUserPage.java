package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProfileUserPage  extends BasePage {
    public SelenideElement valueEmail = $x("//*[@id='Email']");
    public SelenideElement valueFullName = $x("//*[@id='full_name']");

    public String getEmail() {
        executeJavaScript("var esp=document.createElement(\"span\");esp.id = \"Email\";" +
                "document.getElementById(\"home-footer\").appendChild(esp);" +
                "esp.innerHTML=window.logged_in_user.Email;");
        return valueEmail.shouldBe(Condition.visible).getText();

    }

    public String getFullName() {
        executeJavaScript("var esp=document.createElement(\"span\");esp.id = \"full_name\";" +
                "document.getElementById(\"home-footer\").appendChild(esp);" +
                "esp.innerHTML=window.logged_in_user.FullName;");
        return valueFullName.shouldBe(Condition.visible).getText();
    }
}



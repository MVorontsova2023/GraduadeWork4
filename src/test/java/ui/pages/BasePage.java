package ui.pages;

import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    public void login(String email, String password) {
        $x("//span[text()='Sign in']").shouldBe(enabled).click();
        $(By.name("email")).shouldBe(enabled).setValue(email);
        $(By.name("password")).shouldBe(enabled).setValue(password);
        $("#sw-sign-in-submit-btn").click();
    }
}

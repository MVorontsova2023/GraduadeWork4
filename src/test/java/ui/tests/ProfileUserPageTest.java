package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import ui.pages.ProfileUserPage;
import ui.pages.TeacherMainPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Profile User Page Test")
class ProfileUserPageTest extends BasePageTest {
    private static ProfileUserPage profileUserPage;
    private static TeacherMainPage teacherMainPage;
    @BeforeEach
    void setUp() {
        open(BASE_URL);
        WebDriverRunner.getWebDriver().manage().window().maximize();
        profileUserPage = new ProfileUserPage();
        teacherMainPage = new TeacherMainPage();
    }

    @Test
    @DisplayName("Check registered user email in profile")
    public void ValidProfile() {
        profileUserPage.login(TEACHER_EMAIL, TEACHER_PASSWORD);

        teacherMainPage.avatarHeaderButton.shouldBe(enabled).click();
        teacherMainPage.myProfilePopUpAvatarButton.shouldBe(enabled).click();
        Selenide.sleep(3000L);

        assertEquals(profileUserPage.getEmail(),TEACHER_EMAIL);
    }
}
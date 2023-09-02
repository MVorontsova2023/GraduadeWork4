package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

class BasePageTest {

    public final String BASE_URL = "https://jere237.softr.app";
//    public final String BASE_URL = "https://erich416.softr.app";
    public final String STUDENT_EMAIL = "malik@example.com";
    public final String STUDENT_PASSWORD = "123456";
    public final String TEACHER_EMAIL = "m@example.com";
    public final String TEACHER_PASSWORD = "123456";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browser = "firefox"; // chrome
        Configuration.driverManagerEnabled = true;
//        Configuration.browserSize = "1920X1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
//        Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-popup-blocking");
//        open(BASE_URL);
//        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
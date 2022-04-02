package l.rodomanova;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.getSelectedRadio;

public class PracticeFormTests {

    @BeforeAll
    static void initDB() {
        System.out.println("### @BeforeAll");
    }
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "1920x1080";
    }

    @BeforeEach
    void openDemoqaPage() {
        System.out.println("### @BeforeEach");
        Selenide.open("https://demoqa.com/automation-practice-form");


    }

    @AfterEach
    void close() {
        System.out.println("### @AfterEach");
        WebDriverRunner.closeWindow();
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("### @AfterAll");
    }

    @Test
    void fillFormTest() {
        $(By.cssSelector("#firstName")).setValue("Maria");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("Petrova@mail.com");
        $("[class=col-md-3 col-sm-12]").selectRadio("Female");
        $("#userNumber").setValue("7000000000");
        $("#dateOfBirthInput").setValue("10 Oct 1990");
        $("#subjectsContainer").setValue("English");
        $("hobbies-checkbox").setValue("Reading");
        $("#uploadPicture").uploadFile(new File("https://klike.net/1870-milye-kartinki-40-foto.html"));
        $("#currentAddress").setValue("Moscow");
        $("#stateCity-Wrapper").click();
        $("[class=css-1wa3eu0-placeholder]").setValue("NCR");
        $("[class=css-1hwfws3]").setValue("Delhi");
        $("#submit").click();

    }
}
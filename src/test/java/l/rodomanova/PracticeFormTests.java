package l.rodomanova;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        $(By.cssSelector("#firstName")).setValue("Maria");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("Petrova@mail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("7000000000");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOption("1990");
        $("[class=react-datepicker__month-select]").selectOption("October");
        $(byText("10")).click();
        $("#subjectsInput").setValue("E").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("img/Cat.jpg"));
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("[class=modal-open]").shouldHave(text("Maria"), text("Petrova"),
                text("Petrova@mail.com"), text("Female"), text("7000000000"),
                text("10 October,1990"), text("English"), text("Reading"),
                text("Cat.jpg"), text("Moscow"), text("NCR Delhi"));

    }
}
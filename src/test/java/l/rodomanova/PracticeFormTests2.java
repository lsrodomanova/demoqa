package l.rodomanova;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTests2 {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        Selenide.zoom(0.75);
        $("#firstName").setValue("Maria");
        $("#lastName").setValue("Petrova");
        $("#userEmail").setValue("Petrova@mail.com");
        $("#genterWrapper").find(byText("Female")).click();
        $("#userNumber").setValue("7000000000");
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOption("1990");
        $("[class=react-datepicker__month-select]").selectOption("October");
        $(byText("10")).click();
        $("#subjectsInput").setValue("E").pressEnter();
        $("#hobbiesWrapper").find(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        $("#currentAddress").setValue("Moscow");
        $("#state").click();
        $("#stateCity-wrapper").find(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").find(byText("Delhi")).click();
        $("#submit").click();

        $("[class=modal-open]").shouldHave(text("Maria"), text("Petrova"),
                text("Petrova@mail.com"), text("Female"), text("7000000000"),
                text("10 October,1990"), text("English"), text("Reading"),
                text("Cat.jpg"), text("Moscow"), text("NCR Delhi"));

    }
}
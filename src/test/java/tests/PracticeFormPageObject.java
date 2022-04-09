package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormPageObject {


    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void fillFormTest() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        registrationFormPage.openPage()
                .setFirstName()
                .setLastName()
                .setUserEmail()
                .setGender("Female")
                .setUserNumber()
                .setBirthDay()
                .setSubject()
                .setHobby("Reading")
                .uploadPicture()
                .setAddress()
                .setState("NCR")
                .setCity("Delhi")
                .submit()
                .checkResult();

    }
}
package pages;

import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationFormPage {

    Faker faker = new Faker();
    String firstName=faker.name().firstName(),
            lastName=faker.name().lastName(),
            userEmail=faker.internet().emailAddress(),
            currentAddress=faker.address().fullAddress(),
            userNumber=faker.numerify("##########");

    public RegistrationFormPage openPage() {
        Selenide.open("https://demoqa.com/automation-practice-form");
        Selenide.zoom(0.75);
        return this;

    }

    public RegistrationFormPage setFirstName() {
        $("#firstName").setValue(firstName);
        return this;
    }

    public RegistrationFormPage setLastName() {
        $("#lastName").setValue(lastName);
        return this;
    }

    public RegistrationFormPage setUserEmail() {
        $("#userEmail").setValue(userEmail);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").find(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber() {
        $("#userNumber").setValue(userNumber);
        return this;
    }

    public RegistrationFormPage setBirthDay() {
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOption("1990");
        $("[class=react-datepicker__month-select]").selectOption("October");
        $(byText("10")).click();
        return this;
    }

    public RegistrationFormPage setSubject() {
        $("#subjectsInput").setValue("E").pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby(String value) {
        $("#hobbiesWrapper").find(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture() {
        $("#uploadPicture").uploadFromClasspath("Cat.jpg");
        return this;
    }

    public RegistrationFormPage setAddress() {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage setState(String value) {
        $("#state").click();
        $("#stateCity-wrapper").find(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setCity(String value) {
        $("#city").click();
        $("#stateCity-wrapper").find(byText(value)).click();
        return this;
    }

    public RegistrationFormPage submit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResult() {
        $("[class=modal-open]").shouldHave(text(firstName),text(lastName), text(userEmail), text(userNumber),
                text(currentAddress), text("Female"), text("10 October,1990"), text("English"), text("Reading"),
                text("Cat.jpg"), text("NCR Delhi"));
        return this;
    }
}

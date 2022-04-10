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
            userNumber=faker.numerify("##########"),
            year="1990",
            month="October",
            day="10",
            gender= "Female",
            hobby="Reading",
            picture="Cat.jpg",
            subject="E",
            state="NCR",
            city="Delhi",
            lang="English";


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

    public RegistrationFormPage setGender() {
        $("#genterWrapper").find(byText(gender)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber() {
        $("#userNumber").setValue(userNumber);
        return this;
    }

    public RegistrationFormPage setBirthDay() {
        $("#dateOfBirthInput").click();
        $("[class=react-datepicker__year-select]").selectOption(year);
        $("[class=react-datepicker__month-select]").selectOption(month);
        $(byText(day)).click();
        return this;
    }

    public RegistrationFormPage setSubject() {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobby() {
        $("#hobbiesWrapper").find(byText(hobby)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture() {
        $("#uploadPicture").uploadFromClasspath(picture);
        return this;
    }

    public RegistrationFormPage setAddress() {
        $("#currentAddress").setValue(currentAddress);
        return this;
    }

    public RegistrationFormPage setState() {
        $("#state").click();
        $("#stateCity-wrapper").find(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity() {
        $("#city").click();
        $("#stateCity-wrapper").find(byText(city)).click();
        return this;
    }

    public RegistrationFormPage submit() {
        $("#submit").click();
        return this;
    }

    public RegistrationFormPage checkResult() {
        $("[class=modal-open]").shouldHave(text(firstName),text(lastName), text(userEmail), text(userNumber),
                text(currentAddress), text(gender), text(day+" "+month+","+year), text(lang), text(hobby),
                text(picture), text(state+" "+city));
        return this;
    }
}

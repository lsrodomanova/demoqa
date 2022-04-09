package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.open;

public class Junit5Tests {

    @BeforeAll
    static void initDB() {
        System.out.println("### @BeforeAll");
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
    void assertTest() {
        System.out.println("###     @Test 0");
    }

    @Test
    void assertTest1() {
        System.out.println("###     @Test 1");
    }

}


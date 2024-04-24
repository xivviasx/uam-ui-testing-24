package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import pageObjects.GoogleHomePage;
import pageObjects.GoogleResultsPage;

import static com.codeborne.selenide.Selenide.*;

@ExtendWith(TextReportExtension.class)
public class SampleTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.google.com";
        Configuration.headless = true;
    }

    @BeforeEach
    public void clearCache() {
        clearBrowserCookies();
    }

    @Test
    public void sampleTest() {
        open("https://www.google.com");

        $(By.id("L2AGLb")).click();

        $(By.id("APjFqb")).
                val("Uniwersytet Adama Mickiewicza").
                pressEnter();


        $(By.id("logo")).shouldBe(Condition.visible);
        Assertions.assertTrue($(By.id("logo")).isDisplayed());

    }

    @Test
    public void pageObjectPatternApproach() {
        new GoogleHomePage().open().search("kalkulator");

        new GoogleResultsPage()
                .searchForTextInElement(0, "calculator");
    }

}

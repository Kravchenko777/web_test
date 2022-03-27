package org.example.lesson8;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideExample {


    @BeforeAll
    public static void setUp() {
       Configuration.browser = "chrome";
    }

    @Test
    void mytest(){
        open("https://www.bbc.com/");
        $(By.id("idcta-username")).click();
        $(By.id("user-identifier-input")).val("kravmaxim@gmail.com");
        $(By.id("password")).click();
        $(By.id("password-input")).sendKeys("vbPNKsk5GUFStb@");
        $(By.id("submit-button")).submit();
        $(By.id("idcta-username")).shouldHave(text("Your account"));

        WebDriver webDriver = $(By.id("id_")).getWrappedDriver();
        SelenideElement selenideElement = $(By.id("id_"));
        selenideElement.shouldBe(visible);

    }

    @Test
    void fail(){
        open("https://www.bbc.com/");
        $(By.id("idcta-username")).shouldHave(text("Your account"));
    }
}

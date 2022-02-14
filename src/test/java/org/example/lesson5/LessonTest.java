package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonTest extends AbstractTest{

    @Test
    void myActiontest(){
        getDriver().findElement(By.id("idcta-username")).click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("account.bbc.com/"));
        Assertions.assertTrue(getDriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");

        // Создадим экземпляр класса Actions
        Actions loginIn = new Actions(getDriver());

        loginIn.sendKeys(getDriver().findElement(By.id("user-identifier-input")),"kravmaxim@gmail.com")
                .click(getDriver().findElement(By.id("password")))
                .sendKeys("vbPNKsk5GUFStb@")
                .click(getDriver().findElement(By.id("submit-button")))
                .build()
                .perform();

        Assertions.assertTrue(getDriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
    }

    @Test
    void jsTest() throws InterruptedException {
        // Приводим Driver к интерфейсу Javascript
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        System.out.println("Размер окна " +windowWidth);
        jsExecutor.executeScript("window.scrollBy(0,1000)");

        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

    }

    @Test
    void cookieTest(){
        getDriver().manage().addCookie(new Cookie("promo_code", "november2"));


        for(Cookie cookie: getDriver().manage().getCookies()){
            System.out.println(cookie.getName());
        }
    }

}

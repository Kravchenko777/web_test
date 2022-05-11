package org.example.lesson6.bbc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginInTest extends AbstractTest {

    @Test
    void loginIn(){
        new BBCMainPage(getWebDriver()).goToAccountPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .setLogin("kravmaxim@gmail.com")
                .setPassword("vbPNKsk5GUFStb@")
                .loginIn();
        Assertions.assertTrue(getWebDriver().findElement(By.id("idcta-username")).getText().equals("Your account"));

    }

    @Test
    void loginInSecond(){
        new BBCMainPage(getWebDriver()).goToAccountPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("BBC – Sign in"), "страница входа недоступна");
        new LoginPage(getWebDriver())
                .loginIn("kravmaxim@gmail.com","vbPNKsk5GUFStb@");
        Assertions.assertTrue(getWebDriver().findElement(By.id("idcta-username")).getText().equals("Your account"));
    }



    @AfterEach
    void logout(){
        new BBCMainPage(getWebDriver()).goToAccountPage();
        Assertions.assertTrue(getWebDriver().getTitle().equals("BBC – account overview"), "страница аккаунта не доступна");
        new AccountPage(getWebDriver()).logOut();
        new WebDriverWait(getWebDriver(),Duration.ofSeconds(5));
        Assertions.assertTrue(getWebDriver().findElement(By.id("idcta-username")).getText().equals("Sign in"));
    }






}

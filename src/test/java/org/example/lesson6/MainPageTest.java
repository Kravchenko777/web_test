package org.example.lesson6;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class MainPageTest extends AbstractTest{

    @Test
    void mainMenuNavigateTest(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu
                .clicknauka()
                .clickabit()
                .clicksotrudniku()
                .clickstudent()
                .clickabit();
        Assertions.assertEquals("https://www.vstu.ru/abit/",getWebDriver().getCurrentUrl());
    }

    @Test
    void mainMenuWelcomeTest(){
        MainMenu mainMenu = new MainMenu(getWebDriver());
        mainMenu.clickWelcome();
        Assertions.assertEquals("https://welcome.vstu.ru/",getWebDriver().getCurrentUrl());
    }

    @Test
    void searchTest(){
        SearchPage searchPage = new SearchPage(getWebDriver());
        searchPage.toSearch("кравец");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.vstu.ru/search"));
        Assertions.assertDoesNotThrow(() ->searchPage.takeItem(9));

    }

}

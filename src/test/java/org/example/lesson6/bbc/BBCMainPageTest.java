package org.example.lesson6.bbc;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BBCMainPageTest extends AbstractTest {

    @Test
    void clickToSport(){
        new BBCMainPage(getWebDriver()).navigateToSport();
        Assertions.assertEquals("https://www.bbc.com/sport",getWebDriver().getCurrentUrl());
    }

    @Test
    void clickToTravel(){
        new BBCMainPage(getWebDriver()).navigateToTravel();
    }

    @Test
    void clickToWork(){
        new BBCMainPage(getWebDriver()).navigateToWorklife();
    }

}

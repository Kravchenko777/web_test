package org.example.lesson6;


import org.junit.jupiter.api.Test;


public class BBCMainPageTest extends AbstractTest {

    @Test
    void clickToSport(){
        new BBCMainPage(getWebDriver()).navigateToSport();
        getWebDriver().getCurrentUrl();
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

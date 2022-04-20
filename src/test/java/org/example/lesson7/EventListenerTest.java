package org.example.lesson7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class EventListenerTest extends AbstractTest{

    @Test
    void test(){
        try {
            getWebDriver().findElement(By.id("нет такого"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getWebDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }

    }


    @Test
    void test2(){
        WebElement webElement = getWebDriver().findElement(By.cssSelector(".sb-icon-search"));
        webElement.click();

    }
}

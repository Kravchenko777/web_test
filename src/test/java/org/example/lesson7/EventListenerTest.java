package org.example.lesson7;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class EventListenerTest extends AbstractTest{

    @Test
    void test(){
        WebElement webElement = getWebDriver().findElement(By.cssSelector("div.orb-nav-section.orb-nav-links.orb-nav-focus>ul>li.orb-nav-sport>a"));
        webElement.click();

        try {
            getWebDriver().findElement(By.id("нет такого"));
        } catch (NoSuchElementException e){
            MyUtils.makeScreenshot(getWebDriver(),
                    "failure- org.example.bbc.EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }

    }
}

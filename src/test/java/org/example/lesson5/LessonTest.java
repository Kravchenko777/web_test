package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LessonTest extends AbstractTest{

    @Test
    void myActiontest() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.vstu.ru"));
        Assertions.assertTrue(getDriver().getTitle().contains("университет"), "страница входа недоступна");

        // Создадим экземпляр класса Actions
        Actions search = new Actions(getDriver());

        search.click(getDriver().findElement(By.cssSelector(".sb-icon-search")))
                .pause(1000l)
                .sendKeys(getDriver().findElement(By.cssSelector(".sb-search-input")),"кравец")
                .pause(1000l)
                .click(getDriver().findElement(By.cssSelector(".sb-search-submit")))
                .build()
                .perform();

        Thread.sleep(1000);
    }

    @Test
    void jsTest() throws InterruptedException {
        // Приводим Driver к интерфейсу Javascript
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        long windowWidth = (long) jsExecutor.executeScript("return window.innerWidth");
        System.out.println("Размер окна " +windowWidth);
        jsExecutor.executeScript("window.scrollBy(0,500)");

        Thread.sleep(1000);
        getDriver().findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

    }

    @Test
    void cookieTest(){
        getDriver().manage().addCookie(new Cookie("promo_code", "november2"));
        for(Cookie cookie: getDriver().manage().getCookies()){
            System.out.println(cookie.getName() + " " + cookie.getExpiry());
        }

        getDriver().manage().deleteCookie(new Cookie("promo_code", "november2"));

    }

    @Test
    @Disabled
    void voidTest(){
        WebElement voidElement = getDriver().findElement(By.cssSelector(".sb-icon-search"));
        Actions actionProviderContext = new Actions(getDriver());
        // Perform context-click action on the element
        actionProviderContext.contextClick(voidElement).build().perform();

        Actions actionProviderDouble = new Actions(getDriver());
        // Perform double-click action on the element
        actionProviderDouble.doubleClick(voidElement).build().perform();

        Actions actionProviderMove = new Actions(getDriver());
        // Performs mouse move action onto the element
        actionProviderMove.moveToElement(voidElement).build().perform();

        Actions actionProviderOffset = new Actions(getDriver());
        // Performs mouse move action onto the offset position
        actionProviderOffset.moveByOffset(1, 1).build().perform();

        Actions actionProvider = new Actions(getDriver());
        // Performs drag and drop action of sourceEle onto the targetEle
        actionProvider.dragAndDrop(voidElement, voidElement).build().perform();

        Actions actionProviderHold = new Actions(getDriver());
        actionProviderHold.clickAndHold(voidElement).moveToElement(voidElement).build().perform();
        // Performs release event
        actionProviderHold.release().build().perform();

    }

    @Test
    @Disabled
    void voidKeyTest(){
        Actions actionProvider = new Actions(getDriver());
        Action keydown = actionProvider.keyDown(Keys.CONTROL).sendKeys("a").build();

        keydown.perform();

        actionProvider.sendKeys(Keys.ENTER).perform();
    }

    @Test
    @Disabled
    void voidBrowserTest(){
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        getDriver().navigate().to("https://selenium.dev");
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @Test
    @Disabled
    void voidElements(){
        WebElement selectElement = getDriver().findElement(By.id("selectElementID"));
        Select selectObject = new Select(selectElement);
        selectObject.selectByIndex(1);
        selectObject.selectByValue("value1");
        selectObject.selectByVisibleText("Bread");
        selectObject.deselectAll();
    }

}

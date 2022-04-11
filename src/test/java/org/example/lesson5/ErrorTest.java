package org.example.lesson5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ErrorTest extends AbstractTest {

    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.vstu.ru");
        WebElement webElement = getDriver().findElement(By.cssSelector(".sb5-icon-search"));
        webElement.click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

       // org.openqa.selenium.ElementNotInteractableException;
       // org.openqa.selenium.NoSuchElementException;

       Thread.sleep(10000);

        WebElement webElement2 = wait.until(new Function<WebDriver, WebElement>() {
                                        public WebElement apply(WebDriver driver) {
                                            return driver.findElement(By.id(".sb1-search-input"));
                                        }
                                    });


        //WebElement webElement2 = getDriver().findElement(By.cssSelector(".sb-search-input"));
        webElement2.click();
        webElement2.sendKeys("кравец");
        webElement2.submit();
    }
}

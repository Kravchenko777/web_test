package org.example.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SimpleTest {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    void test() throws InterruptedException {
        driver.get("https://www.vstu.ru");
        WebElement webElement = driver.findElement(By.cssSelector(".sb-icon-search"));
        webElement.click();
        Thread.sleep(1000);
        WebElement webElement2 = driver.findElement(By.cssSelector(".sb-search-input"));
        webElement2.click();
        webElement2.sendKeys("кравец");
        webElement2.submit();
        Assertions.assertEquals("Поиск",driver.getTitle(),"Не та страница");
    }



    @AfterAll
    static void close(){
        driver.quit();
    }

}

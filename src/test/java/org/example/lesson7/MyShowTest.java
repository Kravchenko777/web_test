package org.example.lesson7;

import io.qameta.allure.*;
import org.example.lesson6.bbc.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Story("Моя пользовательская история")
public class MyShowTest extends AbstractTest {

    @Test
    @DisplayName("Пустой скрипт")
    @Description("Тест ничего не делает - такой тест нам тут не нужен")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @TmsLink("")
    @Severity(SeverityLevel.MINOR)
    void testTrue(){
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Сделай скрин")
    @Description("Тест создает скрин")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.BLOCKER)
    void testFalse() throws InterruptedException, IOException {
        Thread.sleep(1000);
        File file = MyUtils.makeScreenshot(getWebDriver(),"failure- org.example.bbc.MyShowTest.testFalse" + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
        Assertions.assertTrue(true);
    }

    @Step("Степ 1")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Дай логи")
    @Description("Создаем логи")
    @Link("http://google.com")
    @Issue("https://bbc.com")
    @Severity(SeverityLevel.NORMAL)
    void testLogs(){
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
       /* Assertions.assertEquals(0,allLogRows.size());
        Assertions.assertTrue(allLogRows.isEmpty());*/
        if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });

        }
    }

    @Feature("Фича 1")
    @Test
    void testTrue2(){
        Assertions.assertTrue(true);
    }

    @Feature("Фича 1")
    @Test
    void testTrue3(){
        Assertions.assertTrue(true);
    }

    @Feature("Фича 1")
    @Test
    void testTrue4(){
        Assertions.assertTrue(false);
    }
}

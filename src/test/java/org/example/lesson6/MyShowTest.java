package org.example.lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;

public class MyShowTest extends AbstractTest {

    @Test
    @DisplayName("Тест ничего не делает - такой тест нам тут не нужен")
    void testTrue(){
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Сделай скрин")
    void testFalse() throws InterruptedException {
        Thread.sleep(1000);
        MyUtils.makeScreenshot(getWebDriver(),"failure- org.example.bbc.MyShowTest.testFalse" + System.currentTimeMillis() + ".png");
        Assertions.assertTrue(true);

    }

    @Test
    @DisplayName("Дай логи")
    void testLogs(){
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);


        List<LogEntry> allLogRows = browserLogs.getAll();
        Assertions.assertEquals(0,allLogRows.size());
        Assertions.assertTrue(allLogRows.isEmpty());
        if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });

        }
        Assertions.assertTrue(true);
    }
}

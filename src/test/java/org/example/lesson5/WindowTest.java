package org.example.lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class WindowTest extends AbstractTest{

    @Test
    void test() throws InterruptedException {
        System.out.println(getDriver().getWindowHandle());
        //Store the ID of the original window
        String originalWindow = getDriver().getWindowHandle();

        //getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        getDriver().navigate().to("https://www.google.com/");

        Thread.sleep(10000);
        getDriver().switchTo().window(originalWindow);

        for(String windowHandle: getDriver().getWindowHandles()){
            System.out.println(windowHandle);
        }

        getDriver().close();
    }
}

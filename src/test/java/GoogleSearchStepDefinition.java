import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class GoogleSearchStepDefinition {

    private WebDriver driver;

    @Given("I get google page")
    public void iGetGooglePage() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://google.com");


    }

    @When("I search something")
    public void iSearchSomething() {

        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("test");
        webElement.submit();
    }

    @Then("what???")
    public void what() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}

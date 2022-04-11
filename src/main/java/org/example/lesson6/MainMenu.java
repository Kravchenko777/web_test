package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainMenu extends AbstractPage {

    @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/abit/']")
    private WebElement abit;

    @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/abit/']/../ul/li")
    private List<WebElement> subAbitList;

    @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/student/']")
    private WebElement student;

    @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/nauka/otdel-aspirantury-i-doktorantury/']")
    private WebElement nauka;

    @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/sotrudniku/']")
    private WebElement sotrudniku;

    @FindBy(xpath = ".//ul[@class='menu']/li//a[@href='/vypuskniku/']")
    private WebElement vypuskniku;

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    public MainMenu clickabit(){
        abit.click();
        return this;
    }

    public MainMenu clickstudent(){
        student.click();
        return this;
    }

    public MainMenu clicknauka(){
        nauka.click();
        return this;
    }

    public MainMenu clicksotrudniku(){
        sotrudniku.click();
        return this;
    }

    public MainMenu clickvypuskniku(){
        vypuskniku.click();
        return this;
    }

    public void clickWelcome(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(abit).click(subAbitList.get(0)).build().perform();
    }


}

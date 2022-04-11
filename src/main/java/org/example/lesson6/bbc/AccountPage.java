package org.example.lesson6.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(xpath = ".//span[text()='Sign out']")
    private WebElement exit;

    public AccountPage(WebDriver driver){
        super(driver);

    }


    public void logOut(){
        this.exit.click();

    }

}

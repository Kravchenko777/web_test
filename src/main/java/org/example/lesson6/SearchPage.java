package org.example.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends AbstractPage{

    @FindBy(css = ".sb-icon-search")
    private WebElement search;

    @FindBy(css = ".sb-search-input")
    private WebElement input;

    @FindBy(css = "div.search-item")
    private List<WebElement> searchItems;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void toSearch(String value){
        search.click();
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys(value);
        input.submit();
    }

    public void takeItem(int n){
        searchItems.get(n).click();
    }
}

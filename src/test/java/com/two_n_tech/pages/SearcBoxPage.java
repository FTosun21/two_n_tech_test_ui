package com.two_n_tech.pages;

import com.two_n_tech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.two_n_tech.utilities.BrowserUtils.*;

public class SearcBoxPage extends BasePage{

    @FindBy(css = "input[type='search']")
    public WebElement searchInputBox;


    public void searchInfo(String info){
        clearAndSendKeys(searchInputBox,info, Keys.ENTER);
    }

    public void clickLinks(int selectedLink){
        WebElement link= Driver.get().findElement(By.xpath("(//h3/a)["+selectedLink+"]"));
        articleDetailEntryTitle =link.getText();
        scrollToElement(link);
        clickWithJS(link);

    }

}

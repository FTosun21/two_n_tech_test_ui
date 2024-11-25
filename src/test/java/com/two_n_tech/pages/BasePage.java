package com.two_n_tech.pages;

import com.two_n_tech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static com.two_n_tech.utilities.BrowserUtils.*;

public abstract class BasePage {
    protected BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    public String articleDetailEntryTitle;
    String expectedEntryTitle;

    @FindBy(tagName = "h1")
    public WebElement entryTitle;

    @FindBy(xpath = "//span[contains(@class,'search__popup-trigger-inner-icon')]")
    public WebElement searchIcon;


    public void navigateToMenu(String menuType) {

        By l_topMenu = By.xpath("//a[contains(@class,'nav-menu__item-link-top')]/span/..");
        By l_subMenuPattern = By.xpath(".//following-sibling::ul//a[contains(@class,'nav-menu__item-link-sub')]");

        if (menuType.equalsIgnoreCase("sub")) {
            navigateToSubMenu(l_topMenu, l_subMenuPattern);
        } else  {
            navigateToTopMenu(l_topMenu);
        }
    }
    private void navigateToTopMenu(By l_topMenu) {

        List<WebElement> topMenus = Driver.get().findElements(l_topMenu);

        topMenus.forEach(topMenu -> {
            expectedEntryTitle = topMenu.getText();

            try {
                waitForClickablility(topMenu, 5).click();
            } catch (StaleElementReferenceException staleException) {
                System.out.println("StaleElementReferenceException occurred, retrying with JS Click: " + staleException.getMessage());
                clickWithJS(topMenu);
            }catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unexpected exception occurred: " + e.getMessage());
            }

            System.out.println("expectedEntryTitle = " + expectedEntryTitle);
            verifyEntryTitleIsDisplayed(expectedEntryTitle);
            Driver.get().navigate().back();
        });
    }

    private void navigateToSubMenu(By l_topMenu, By l_subMenuPattern) {

        List<WebElement> topMenus = Driver.get().findElements(l_topMenu);

        topMenus.forEach(topMenu -> {
            hover(topMenu);

            List<WebElement> subMenus = topMenu.findElements(l_subMenuPattern);
            subMenus.forEach(subMenu -> {
                expectedEntryTitle = subMenu.getText();
                System.out.println("expectedEntryTitle = " + expectedEntryTitle);

                try {
                    waitForClickablility(subMenu, 5).click();
                } catch (StaleElementReferenceException staleException) {
                    System.out.println("StaleElementReferenceException occurred, retrying with JS Click: " + staleException.getMessage());
                    clickWithJS(subMenu);
                } catch (Exception e) {
                    System.out.println("Unexpected exception occurred: " + e.getMessage());
                }

                System.out.println("expectedEntryTitle = " + expectedEntryTitle);
                verifyEntryTitleIsDisplayed(expectedEntryTitle);
                Driver.get().navigate().back();
                hover(topMenu);
            });
        });
    }

    public void verifyEntryTitleIsDisplayed(String expectedEntryTitle){
        String actualTitle=entryTitle.getText().toUpperCase();
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedEntryTitle = " + expectedEntryTitle);
        Assert.assertTrue(actualTitle.contains(expectedEntryTitle.toUpperCase()));

    }

}

package com.two_n_tech.pages;

import com.two_n_tech.utilities.ConfigurationReader;
import com.two_n_tech.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.two_n_tech.utilities.BrowserUtils.*;

public class Two_n_tech_hr_Page extends BasePage {
    @FindBy(id = "name")
    public WebElement l_fullName_InputBox;
    @FindBy(id = "birth")
    public WebElement l_dob_InputBox;
    @FindBy(id = "tcKimlik")
    public WebElement l_tc_id_InputBox;
    @FindBy(id = "phone")
    public WebElement l_phone_InputBox;
    @FindBy(id = "email")
    public WebElement l_email_InputBox;
    @FindBy(id = "cv_field")
    public WebElement l_cv_field_InputBox;
    @FindBy(css = "[id='pdp1']~span")
    public WebElement l_pdp1_CheckBox;
    @FindBy(css = "[type='submit']")
    public WebElement l_btn_Submit;
    @FindBy(xpath = "//p[contains(@class,'text')]")
    public WebElement l_verifyMessage_Submit;

    public void fillForm() {
        clearAndSendKeys(l_fullName_InputBox, ConfigurationReader.get("fullName"));
        clearAndSendKeys(l_dob_InputBox, ConfigurationReader.get("dob"));
        clearAndSendKeys(l_tc_id_InputBox, ConfigurationReader.get("tc_id"));
        clearAndSendKeys(l_phone_InputBox, ConfigurationReader.get("phone"));
        clearAndSendKeys(l_email_InputBox, ConfigurationReader.get("email"));
        fileUpload();
        clickBtn(ConfigurationReader.get("eduInfo"));
        clickWithJS(l_pdp1_CheckBox);
        waitForClickablility(l_btn_Submit,5).click();
        clickBtn(ConfigurationReader.get("position"));
        clickBtn("Gönder");

    }

    void clickBtn(String btnText) {
        WebElement element = Driver.get().findElement(By.xpath("//*[text()='" + btnText + "']"));
        waitForClickablility(element, 5).click();
    }

    void fileUpload() {
        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/uploadFile/"+ConfigurationReader.get("fileName");
        String fullPath = projectPath + "/" + filePath;
        l_cv_field_InputBox.sendKeys(fullPath);
    }

    public void verifySubmitMessage(String expectedMessage){
       String actualMessage= l_verifyMessage_Submit.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}

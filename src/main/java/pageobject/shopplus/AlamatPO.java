package pageobject.shopplus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

public class AlamatPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public AlamatPO(WebDriver driver){
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 60), this);
    }

    /*
     * All WebElements are identified by @FindBy annotation
     *
     * @FindBy can accept tagName, partialLinkText, name, linkText, id, css,
     * className, xpath as attributes.
     */

    @FindBy(id = "txtPhoneBuyer")
    private WebElement inputPhoneNumber;

    @FindBy(id = "txtRecipientName")
    private WebElement inputRecipientName;

    @FindBy(id = "cboProvinsi")
    private WebElement provinceBox;

    @FindBy(xpath = "//textarea[@data-id=\"txtAlamatLengkap\"]")
    private WebElement inputFullAddress;

    @FindBy(id = "buttonSelanjutnyaAlamat")
    private WebElement nextButton2;

    /**
     * Enter phone number
     * @param phonenumber
     */
    public void inputPhoneNumber(String phonenumber) {
        selenium.enterText(inputPhoneNumber, phonenumber, true);
    }

    /**
     * Enter recipient name
     * @param recipientname
     */
    public void inputRecipientName(String recipientname) {
        selenium.enterText(inputRecipientName, recipientname, true);
    }

    /**
     * Click on province box
     * @throws InterruptedException
     */
//    public void clickOnProvinceBox() throws InterruptedException {
//        selenium.clickOn(provinceBox);
//    }

    /**
     * Click on province button
     * @throws InterruptedException
     */
    public void clickOnProvinceButton(String Province) throws InterruptedException {
        selenium.clickOn(provinceBox);
        String s = "//button[@data-id='btn" + Province + "']";
        By xpath = By.xpath(s);
        selenium.waitTillElementIsClickable(xpath).click();
        selenium.waitForJavascriptToLoad();
    }

    /**
     * Click on city button
     * @throws InterruptedException
     */
    public void clickOnCityButton(String City) throws InterruptedException {
        String s = "//button[@data-id='btn" + City + "']";
        By xpath = By.xpath(s);
        selenium.waitTillElementIsClickable(xpath).click();
        selenium.waitForJavascriptToLoad();
    }

    /**
     * Click on district button
     * @throws InterruptedException
     */
    public void clickOnDistrictButton(String District) throws InterruptedException {
        String s = "//button[@data-id='btn" + District + "']";
        By xpath = By.xpath(s);
        selenium.waitTillElementIsClickable(xpath).click();
        selenium.waitForJavascriptToLoad();
    }

    /**
     * Click on postal code button
     * @throws InterruptedException
     */
    public void clickOnPostalCodeButton(String PostalCode) throws InterruptedException {
        String s = "//button[@data-id='btn" + PostalCode + "']";
        By xpath = By.xpath(s);
        selenium.waitTillElementIsClickable(xpath).click();
        selenium.waitForJavascriptToLoad();
    }

    /**
     * Enter recipient name
     * @param fulladdress
     */
    public void input_full_address (String fulladdress ) {
        selenium.enterText(inputFullAddress, fulladdress, true);
    }

    /**
     * Click on next button 2
     * @throws InterruptedException
     */
    public void clickOnNextButton2() throws InterruptedException {
        selenium.clickOn(nextButton2);
    }
}

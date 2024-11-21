package pageobject.shopplus;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import utilities.SeleniumHelpers;

import java.util.NoSuchElementException;

public class DetailPesananPO {
    WebDriver driver;
    SeleniumHelpers selenium;

    public DetailPesananPO(WebDriver driver) {
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

    @FindBy(xpath = "//h1[@data-id=\"lblDetailPesanan\"]")
    private WebElement textDetailPesanan;

    @FindBy(xpath = "//span[@data-id=\"lblGuestInfo\"]")
    private WebElement textGuest;

    @FindBy(xpath = "//span[@data-id=\"btnPelajari\"]")
    private WebElement pelajariButton;

    @FindBy(xpath = "//button[@data-id=\"btnClosePelajari\"]")
    private WebElement closePelajariButton;

    @FindBy(xpath = "//p[@data-id=\"lblMasukSebagaiGuest\"]")
    private WebElement guestModal;

    @FindBy(xpath = "//div[@class=\"user-info-bar_hideUserInfoBar__LlUZN\"]")
    private WebElement hideUserInformation;

    @FindBy(xpath = "//div[@class=\"flex flex-row\"]//span[@data-id=\"lblProductPrice\"]")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@data-id=\"btnAddToCart\"]")
    private WebElement addToCartButton;

    @FindBy(id = "1")
    private WebElement nextButton;

    @FindBy(xpath = "//button[@data-id=\"btnPilihPengiriman\"]")
    private WebElement courierButton;

    @FindBy(xpath = "//span[@data-id=\"lblSaleableStock\"]")
    private WebElement stockLabel;

    @FindBy(xpath = "//div[@id=\"button-counter-wrapper\"]//div[@data-id=\"btnDecrement\"]")
    private WebElement decrementButton;

    @FindBy(xpath = "//input[@data-id=\"etQty\"]")
    private WebElement inputQty;

    @FindBy(xpath = "//div[@id=\"button-counter-wrapper\"]//div[@data-id=\"btnIncrement\"]")
    private WebElement incrementButton;

    @FindBy(xpath = "//button[@data-id=\"btnSelectedProduct\"]")
    private WebElement modalProduct;

    @FindBy(xpath = "//div[@id=\"modalProdukDipilih\"]//p[@data-id=\"lblProdukDipilih\"]")
    private WebElement modalLabelProdukDipilih;

    @FindBy(xpath = "//button[@data-id=\"btnSelectedProduct\"]//img[@data-id=\"imgVariant\"]")
    private WebElement imgProduk;

    @FindBy(xpath = "//div[@id=\"modalProdukDipilih\"]//img[@data-id=\"imgProductDetail\"]")
    private WebElement modalImgProduk;

    @FindBy(xpath = "//div[@class=\"max-h-[60vh] overflow-y-auto\"]//span[@data-id=\"lblProductPrice\"]")
    private WebElement modalPrice;

    @FindBy(xpath = "//*[@id=\"modalProdukDipilih\"]/div/div[2]/div[1]/div/div/div[2]/div/div/div[1]/button")
    private WebElement modalDeleteButton;

    @FindBy(xpath = "//div[@id=\"modalProdukDipilih\"]//div[@data-id=\"btnDecrement\"]")
    private WebElement modalDecrementButton;

    @FindBy(xpath = "//div[@id=\"modalProdukDipilih\"]//input[@data-id=\"etQty\"]")
    private WebElement modalInputQty;

    @FindBy(xpath = "//div[@id=\"modalProdukDipilih\"]//div[@data-id=\"btnIncrement\"]")
    private WebElement modalIncrementButton;

    @FindBy(xpath = "(//*[@id=\"other-products\"]//button[@data-id=\"btnTambahOtherProduct\"])[1]")
    private WebElement tambahOtherProduct1;

    @FindBy(xpath = "(//*[@id=\"other-products\"]//button[@data-id=\"btnTambahOtherProduct\"])[2]")
    private WebElement tambahOtherProduct2;

    @FindBy(xpath = "//div[@id=\"modalPilihProductVariant\"]//button[@data-id=\"btnAddToCartOtherProduct\"]")
    private WebElement addToCartOtherButton;

    @FindBy(xpath = "//div[@id=\"modalPilihProductVariant\"]//button[@data-id=\"btnClose\"]")
    private WebElement closeModalOtherButton;

    @FindBy(xpath = "//*[@data-id=\"btnPilihPembayaran\"]")
    private WebElement buttonPilihPembayaran;

    @FindBy(xpath = "//*[contains(text(), \'Go-pay\')]")
    private WebElement buttonPaymentGopay;

    @FindBy(xpath = "//*[contains(text(), \'OVO\')]")
    private WebElement buttonPaymentOvo;

    @FindBy(xpath = "//*[contains(text(), \'ShopeePay/SpayLater\')]")
    private WebElement buttonPaymentShopee;

    @FindBy(xpath = "//*[contains(text(), \'Virtual Account BCA\')]")
    private WebElement buttonPaymentBCA;

    @FindBy(xpath = "//*[contains(text(), \'Virtual Account BRI\')]")
    private WebElement buttonPaymentBRI;

    @FindBy(xpath = "//*[contains(text(), \'Virtual Account Permata\')]")
    private WebElement buttonPaymentPermata;

    @FindBy(xpath = "//*[contains(text(), \'Virtual Account MNC Bank\')]")
    private WebElement buttonPaymentMNC;

    @FindBy(id = "button-bayar")
    private WebElement buttonBayar;

    @FindBy(xpath = "//*[contains(text(), \'Selesaikan pembayaran dalam\')]")
    private WebElement textCountdown;

    @FindBy(xpath = "//span[@data-id=\"lblPaymentProviders\"]")
    private WebElement labelPaymentProviders;


    /**
     * Verify text detail pesanan is visible
     */
    public boolean displayTextDetailPesanan() {
        return selenium.isElementAppeared(textDetailPesanan);
    }

    /**
     * Verify text detail pesanan is visible
     */
    public String getTextDetailPesanan() {
        return selenium.getText(textDetailPesanan);
    }

    /**
     * Verify text guest is visible
     */
    public boolean displayTextGuest() {
        return selenium.isElementAppeared(textGuest);
    }

    /**
     * Get text guest
     *
     * @return getText
     */
    public String getTextGuest() {
        return selenium.getText(textGuest);
    }

    /**
     * Get text pelajari
     *
     * @return getText
     */
    public String getTextPelajari() {
        return selenium.getText(pelajariButton);
    }


    /**
     * Verify button pelajari is visible
     */
    public boolean displayPelajariButton() {
        return selenium.isElementAppeared(pelajariButton);
    }

    /**
     * Click on pelajari button
     * @throws InterruptedException
     */
    public void clickOnPelajariButton() throws InterruptedException {
        selenium.clickOn(pelajariButton);
    }

    /**
     * Click on close pelajari button
     *
     * @throws InterruptedException
     */
    public void clickOnClosePelajariButton() throws InterruptedException {
        selenium.clickOn(closePelajariButton);
    }

    /**
     * Verify modal guest is visible
     */
    public boolean displayGuestModal() {
        return selenium.isElementAppeared(guestModal);
    }

    /**
     * Get text pelajari
     *
     * @return getText
     */
    public String getTextGuestModal() {
        return selenium.getText(guestModal);
    }

    /**
     * Verify pelajari button is invisible
     */
    public boolean hideUserInformation() {
        return selenium.isElementAppeared(hideUserInformation);
    }

    /**
     * Get text price
     *
     * @return getText
     */
    public String getTotalPrice() {
        return selenium.getText(productPrice);
    }

    /**
     * Click on add to cart button
     *
     * @throws InterruptedException
     */
    public void clickOnAddToCartButton() throws InterruptedException {
        selenium.clickOn(addToCartButton);
    }

    /**
     * Verify button selanjutnya is visible
     */
    public boolean displayNextButton() {
        return selenium.isElementAppeared(nextButton);
    }

    /**
     * Click on next button
     *
     * @throws InterruptedException
     */
    public void clickOnNextButton() throws InterruptedException {
        selenium.clickOn(nextButton);
    }

    /**
     * Click on courier button
     *
     * @throws InterruptedException
     */
    public void clickOnCourierButton(String Courier) throws InterruptedException {
        selenium.clickOn(courierButton);
        String s = "//div[@data-id='event" + Courier + "']";
        By xpath = By.xpath(s);
        selenium.waitTillElementIsClickable(xpath).click();
        selenium.waitForJavascriptToLoad();
    }

    /**
     * Click on payment button
     *
     * @throws InterruptedException
     */
    public void clickOnPaymentButton(String Payment) throws InterruptedException {
        selenium.clickOn(buttonPilihPembayaran);
        String s = "//*[contains(text(), '"+ Payment + "')]";
        By xpath = By.xpath(s);
        selenium.waitTillElementIsClickable(xpath).click();
        selenium.waitForJavascriptToLoad();
    }

    /**
     * Click on bayar button
     *
     * @throws InterruptedException
     */
    public void clickOnPayButton() throws InterruptedException {
        selenium.clickOn(buttonBayar);
    }

    /**
     * Verify label stock is visible
     */
    public boolean isStockDisplayed() {
        try {
            return stockLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Get text stock
     *
     * @return getText
     */
    public String getSaleableStock() {
        if (isStockDisplayed()) {
            return stockLabel.getText();
        } else {
            return null;
        }
    }

    /**
     * Click on increase qty button
     *
     * @throws InterruptedException
     */
    public void clickIncrementButton(int times) throws InterruptedException {
        for (int i = 1; i < times; i++) {
            selenium.clickOn(incrementButton);
        }
    }

    /**
     * Get current qty
     *
     * @return getCurrentQty
     */
    public int getCurrentQty() {
        try {
            return Integer.parseInt(inputQty.getAttribute("value"));
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public void setQty(int qty) {
        inputQty.clear(); // Clear existing input
        inputQty.sendKeys(String.valueOf(qty)); // Input desired quantity
    }

    // Method to verify the max purchase limit
    public boolean isQtyWithinMaxLimit(int maxLimit) {
        int currentQty = getCurrentQty();
        return currentQty <= maxLimit;
    }

    // Method to check if increment button is disabled
    public boolean isIncrementButtonDisabled() {
        return !incrementButton.isEnabled(); // Verifikasi jika tombol tidak diaktifkan
    }

    // Method to click the increment button
    public void clickonIncrementButton() throws InterruptedException {
        selenium.clickOn(incrementButton);
    }

    // Method to click increment button up to max limit
    public void clickIncrementButtonUntilMax(int maxLimit) throws InterruptedException {
        int currentQty = getCurrentQty();
        while (currentQty < maxLimit) {
            clickonIncrementButton();
            currentQty = getCurrentQty();
            if (currentQty >= maxLimit) {
                break; // Stop clicking if max limit is reached
            }
        }
    }

    /**
     * Verify modal product is invisible
     */
    public boolean modalProduct() {
        return selenium.isElementAppeared(modalProduct);
    }

    /**
     * Click on modal product button
     * @throws InterruptedException
     */
    public void clickOnModalProduct() throws InterruptedException {
        selenium.clickOn(modalProduct);
    }

    /**
     * Verify image is invisible
     */
    public boolean imageProduct() {
        return selenium.isElementAppeared(imgProduk);
    }

    /**
     * Click on modal increment qty button
     * @throws InterruptedException
     */
    public void clickOnModalIncrementQty(int times) throws InterruptedException {
        for (int i = 0; i < times; i++) {
            selenium.clickOn(modalIncrementButton);
        }
    }

    /**
     * Click on modal increment qty button
     * @throws InterruptedException
     */
    public void clickOnDeleteButton() throws InterruptedException {
            selenium.clickOn(modalDeleteButton);
    }

    /**
     * Click on tambah other product 1 button
     *
     * @throws InterruptedException
     */
    public void clickOnAddToCartOther1() throws InterruptedException {
        selenium.clickOn(tambahOtherProduct1);
    }

    /**
     * Click on tambah other product 2 button
     *
     * @throws InterruptedException
     */
    public void clickOnAddToCartOther2() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", tambahOtherProduct2);

        // Tunggu sebentar untuk memastikan scroll selesai (opsional)
        Thread.sleep(500);  // Anda bisa menyesuaikan waktu tunggu ini

        // Klik tombol "Add to Cart Other"
        selenium.clickOn(tambahOtherProduct2);
    }

    /**
     * Click on add to cart other product button
     *
     * @throws InterruptedException
     */
    public void clickOnAddToCartOtherButton() throws InterruptedException {
        selenium.clickOn(addToCartOtherButton);
    }

    /**
     * Click on close other product button
     *
     * @throws InterruptedException
     */
    public void clickOnCloseOtherButton() throws InterruptedException {
        selenium.clickOn(closeModalOtherButton);
    }

    /**
     * Click on button pilih pembayaran
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaran() throws InterruptedException {
        selenium.clickOn(buttonPilihPembayaran);
    }

    /**
     * Click on button pilih pembayaran gopay
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranGopay() throws InterruptedException {
        selenium.clickOn(buttonPaymentGopay);
    }

    /**
     * Click on button pilih pembayaran shopee
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranShopee() throws InterruptedException {
        selenium.clickOn(buttonPaymentShopee);
    }

    /**
     * Click on button pilih pembayaran OVO
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranOVO() throws InterruptedException {
        selenium.clickOn(buttonPaymentOvo);
    }

    /**
     * Click on button pilih pembayaran BCA
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranBCA() throws InterruptedException {
        selenium.clickOn(buttonPaymentBCA);
    }

    /**
     * Click on button pilih pembayaran BRO
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranBRI() throws InterruptedException {
        selenium.clickOn(buttonPaymentBRI);
    }

    /**
     * Click on button pilih pembayaran Permata
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranPermata() throws InterruptedException {
        selenium.clickOn(buttonPaymentPermata);
    }

    /**
     * Click on button pilih pembayaran MNC Bank
     *
     * @throws InterruptedException
     */
    public void clickOnPilihPembayaranMNC() throws InterruptedException {
        selenium.clickOn(buttonPaymentMNC);
    }

    /**
     * Verify count down is invisible
     */
    public boolean countdownIsVisible() {
        return selenium.isElementAppeared(textCountdown);
    }

    /**
     * Verify metode pembayaran is invisible
     */
    public boolean paymentProvidersIsVisible() {
        return selenium.isElementAppeared(labelPaymentProviders);
    }

}

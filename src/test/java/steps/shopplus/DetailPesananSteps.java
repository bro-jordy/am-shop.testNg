package steps.shopplus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.cucumber.java.sl.In;
import io.cucumber.messages.types.Ci;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.shopplus.DetailPesananPO;
import utilities.ThreadManager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DetailPesananSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private DetailPesananPO pesanan = new DetailPesananPO(driver);

    @Then("system display title page : Detail Pesanan")
    public void system_display_title() {
        Assert.assertTrue(pesanan.displayTextDetailPesanan(),"System not display next button");
        Assert.assertEquals(pesanan.getTextDetailPesanan(), "Detail Pesanan", "Message error not match!");
    }

    @Then("system display text \"kamu masuk sebagai guest\" on top")
    public void system_display_text_guest() {
        Assert.assertTrue(pesanan.displayTextGuest(),"System not display next button");
        Assert.assertEquals(pesanan.getTextGuest(), "Kamu masuk sebagai guest", "Message error not match!");
    }

    @And("system display button pelajari")
    public void system_display_button_pelajari() {
        Assert.assertTrue(pesanan.displayPelajariButton(),"System not display next button");
        Assert.assertEquals(pesanan.getTextPelajari(), "Pelajari", "Message error not match!");
    }

    @And("user click on pelajari button")
    public void user_click_pelajari_button() throws InterruptedException {
        pesanan.clickOnPelajariButton();
    }

    @Then("system display modal guest information")
    public void system_display_modal_guest_info() {
        Assert.assertTrue(pesanan.displayGuestModal(),"System not display next button");
        Assert.assertEquals(pesanan.getTextGuestModal(), "Masuk Sebagai Guest", "Message error not match!");
    }

    @Then("user click close pelajari")
    public void user_click_close_pelajari() throws InterruptedException {
        pesanan.clickOnClosePelajariButton();
    }

    @Then("system hide user information")
    public void system_hide_user_information() {
        Assert.assertTrue(pesanan.hideUserInformation(),"System not display next button");
    }

    @Then("the total price should be {string}")
    public void theTotalPriceShouldBe(String expectedPrice) {
        String actualPrice;
        try {
            actualPrice = pesanan.getTotalPrice();
        } catch (NoSuchElementException e) {
            Assert.fail("The total price element is not present on the page.");
            return;
        }

        if (actualPrice == null || actualPrice.isEmpty() || actualPrice.equals("Rp-")) {
            Assert.fail("The total price is not displayed correctly on the page.");
            return;
        }

        String actualPriceNumeric = actualPrice.replaceAll("[Rp.,\\s]", "");
        String expectedPriceNumeric = expectedPrice.replaceAll("[Rp.,\\s]", "");

        Assert.assertEquals(actualPriceNumeric, expectedPriceNumeric,"The total price is incorrect" );
    }

    @Then("system display stock of product")
    public void saleableStockShouldBeDisplayed() {
        // Cek apakah elemen stok muncul di halaman
        if (!pesanan.isStockDisplayed()) {
            Assert.fail("The saleable stock element is not present on the page.");
        } else {
            // Lanjutkan dengan validasi jika elemen stok ada
            String stockText = pesanan.getSaleableStock();
            if (stockText == null || stockText.isEmpty() || stockText.equals("")) {
                Assert.fail("The saleable stock is not displayed correctly.");
            } else {
                System.out.println("Saleable stock displayed: " + stockText);
                // Lakukan validasi lebih lanjut jika diperlukan
            }
        }
    }

    @When("user clicks the increment button {int} times")
    public void userClicksTheIncrementButtonMultipleTimes(int times) throws InterruptedException {
        pesanan.clickIncrementButton(times);
    }

    @Then("the quantity should increase by {int} times")
    public void quantityShouldIncreaseByTimes(int expectedIncrement) throws InterruptedException {
        int newQty = pesanan.getCurrentQty();

        Assert.assertEquals(newQty, expectedIncrement, "The quantity did not increase correctly.");
    }

    @When("user tries to input a quantity of {int} times")
    public void userTriesToInputAQuantityOf(int qty) {
        pesanan.setQty(qty);
    }

    @When("user clicks increment button until max limit of {int}")
    public void userClicksIncrementButtonUntilMaxLimit(int maxLimit) throws InterruptedException {
        pesanan.clickIncrementButtonUntilMax(maxLimit);
    }

    @Then("the quantity should not exceed the max limit of {int}")
    public void quantityShouldNotExceedMaxLimit(int maxLimit) {
        Assert.assertTrue(pesanan.isQtyWithinMaxLimit(maxLimit), "The quantity exceeds the maximum purchase limit.");
    }

    @Then("the increment button should be disabled")
    public void incrementButtonShouldBeDisabled() {
        Assert.assertTrue( pesanan.isIncrementButtonDisabled(),"The increment button is not disabled when max quantity is reached.");
    }

    @Then("system verify product added on modal")
    public void system_verify_product_added_on_modal() {
        Assert.assertTrue(pesanan.modalProduct(), "The modal product is not display");
        Assert.assertTrue(pesanan.imageProduct(), "The image is not display");
        Assert.assertTrue(pesanan.displayNextButton(), "Button Selanjutnya is not display");
    }

    @When("user click on add to cart")
    public void user_click_add_to_cart_button() throws InterruptedException{
        pesanan.clickOnAddToCartButton();
    }

    @Then("system display next button")
    public void system_display_button_selanjutnya() {
        Assert.assertTrue(pesanan.displayNextButton(),"System not display next button");
    }

    @And("user click on next button to address")
    public void user_click_next_button() throws InterruptedException{
        pesanan.clickOnNextButton();
    }

    @And("user click courier button {string}")
    public void user_click_courier_button(String Courier) throws InterruptedException{
        pesanan.clickOnCourierButton(Courier);
    }

    @And("user select payment {string}")
    public void user_click_payment_button(String Payment) throws InterruptedException{
        pesanan.clickOnPaymentButton(Payment);
        pesanan.clickOnPayButton();
        Thread.sleep(7000);
    }

    @And("system display thankyou page")
    public void system_display_thankyou_page() throws InterruptedException {
        pesanan.countdownIsVisible();
        Assert.assertTrue(pesanan.countdownIsVisible(), "Selesaikan pembayaran dalam");
        pesanan.paymentProvidersIsVisible();
        Thread.sleep(7000);
    }

    @And("user click on modal product")
    public void user_click_modal_product() throws InterruptedException {
        pesanan.clickOnModalProduct();
    }

    @Then("system display detail of product")
    public void system_display_detail_of_product() {
        Assert.assertTrue(pesanan.imageProduct());
    }
    @When("user add {int} qty")
    public void userAddQty(int times) throws InterruptedException {
        pesanan.clickOnModalIncrementQty(times);
    }

    @Then("user click on delete button")
    public void user_click_on_delete_button() throws InterruptedException {
        pesanan.clickOnDeleteButton();
    }

    @Then("user click on add to cart other product 1")
    public void user_click_on_other_product1_button() throws InterruptedException {
        pesanan.clickOnAddToCartOther1();
        pesanan.clickOnAddToCartOtherButton();
        pesanan.clickOnCloseOtherButton();
    }

    @Then("user click on add to cart other product 2")
    public void user_click_on_other_product2_button() throws InterruptedException {
        pesanan.clickOnAddToCartOther2();
        pesanan.clickOnAddToCartOtherButton();
        pesanan.clickOnCloseOtherButton();
    }

    @Then("user select payment MNC Bank")
    public void user_select_payment() throws InterruptedException {
        pesanan.clickOnPilihPembayaran();
        pesanan.clickOnPilihPembayaranMNC();

    }
}

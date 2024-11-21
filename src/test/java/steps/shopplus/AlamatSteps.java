package steps.shopplus;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pageobject.shopplus.AlamatPO;
import pageobject.shopplus.DetailPesananPO;
import utilities.ThreadManager;

public class AlamatSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private AlamatPO address = new AlamatPO(driver);

    @And("user input phone number {string}")
    public void user_input_phone_number(String phonenumber){
        address.inputPhoneNumber(phonenumber);
    }

    @And("user input recipient name {string}")
    public void user_input_recipient_name(String recipientname){
        address.inputRecipientName(recipientname);
    }

    @Then(("user input province {string}"))
    public void user_input_address(String Province) throws InterruptedException {
        address.clickOnProvinceButton(Province);
    }

    @And(("user input city {string}"))
    public void user_input_city(String City) throws InterruptedException {
        address.clickOnCityButton(City);
    }

    @And(("user input district {string}"))
    public void user_input_district(String District) throws InterruptedException {
        address.clickOnDistrictButton(District);
    }

    @And(("user input postal code {string}"))
    public void user_input_postal_code(String PostalCode) throws InterruptedException {
        address.clickOnPostalCodeButton(PostalCode);
    }

    @And("user input full address {string}")
    public void user_input_full_address(String fulladdress){
        address.input_full_address(fulladdress);
    }

    @Then("user click on next button to shipping")
    public void user_click_next_button_2() throws InterruptedException{
        address.clickOnNextButton2();
    }
}

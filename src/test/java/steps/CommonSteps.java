package steps;

import com.dieselpoint.norm.Database;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utilities.Products;
import utilities.SeleniumHelpers;
import utilities.ThreadManager;

import java.util.List;

public class CommonSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private SeleniumHelpers selenium = new SeleniumHelpers(driver);

    @Given("user access page {string}")
    public void user_access_page(String url) {
        selenium.navigateToPage(url);
    }

    @Given("user access page shop plus {string}")
    public void user_access_page_shop_plus(String productID) {
        selenium.navigateToPage("https://shop.aladinmall.id/checkout/" + productID);
    }

    @Given("user access page shop plus 1680582")
    public void user_access_page_shop_plus_1680582() {
        selenium.navigateToPage("https://shop.aladinmall.id/checkout/1680582?userId=27adb220cf2191b627431dec1e5b66433d750262a1a0aa1cf4ca2f0a837df8fab2766281ab613cec" );
    }

    @Given("user access page shop plussss")
    public void user_access_page_shop_plus_db() {
        Database db = new Database();
        db.setJdbcUrl("jdbc:postgresql://supabase-common-pg.aladinmall.id:5432/catalogue_custom");
        db.setUser("supa_common");
        db.setPassword("d3f293a12a91e57c");
//        Long id = db.sql("select id from products where id = '1340064'").first(Long.class);
//        selenium.navigateToPage("https://shop.aladinmall.id/checkout/" + id);
        List<Products> result = db.sql("select p.id from products as p join product_variants pv on p.id = pv.product_id where p.is_active = 'true' and p.status = 'APPROVED' AND CURRENT_DATE BETWEEN pv.special_price_start_date AND pv.special_price_end_date group by p.id order by id asc;").results(Products.class);
        for (int i = 0; i < 2; i++){
            selenium.navigateToPage("https://shop.aladinmall.id/checkout/" + result.get(i).id);
        }
    }

    @Then("compare current url with {string}")
    public void compare_url(String url){
        Assert.assertEquals(url, selenium.getURL());
   }
}
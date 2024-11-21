package steps.shopplus;

import com.dieselpoint.norm.Database;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobject.shopplus.DetailPesananPO;
import utilities.ProductVariants;
import utilities.ThreadManager;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;

public class DetailSteps {
    private WebDriver driver = ThreadManager.getDriver();
    private DetailPesananPO pesanan = new DetailPesananPO(driver);

    @And("user price same as db")
    public void system_display_price() {
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

        Database db = new Database();
        db.setJdbcUrl("jdbc:postgresql://supabase-common-pg.aladinmall.id:5432/catalogue_custom");
        db.setUser("supa_common");
        db.setPassword("d3f293a12a91e57c");
        List<ProductVariants> productVariants = db.sql("SELECT\n" +
                "                p.id,\n" +
                "                        CASE\n" +
                "                WHEN pv.special_price IS NULL THEN p.main_price\n" +
                "                ELSE pv.special_price\n" +
                "                END AS special_price,\n" +
                "                        pv.special_price_start_date,\n" +
                "                        pv.special_price_end_date\n" +
                "                FROM\n" +
                "                products AS p\n" +
                "                        JOIN\n" +
                "                product_variants AS pv\n" +
                "                ON p.id = pv.product_id\n" +
                "                WHERE\n" +
                "                p.is_active = 'true'\n" +
                "                AND p.status = 'APPROVED'\n" +
                "                AND CURRENT_DATE BETWEEN pv.special_price_start_date AND pv.special_price_end_date\n" +
                "                GROUP BY\n" +
                "                p.id, pv.special_price, pv.special_price_start_date, pv.special_price_end_date\n" +
                "                ORDER BY\n" +
                "                p.id ASC;").results(ProductVariants.class);
        for (int i = 0; i < 2; i++) {
            String actualPriceNumeric = actualPrice.replaceAll("[Rp.,\\s]", "");
            Assert.assertEquals(actualPriceNumeric,  productVariants.get(i).specialPrice.toString().replaceAll("[Rp.,\\s]", ""), "The total price is incorrect");
//    }
//        String actualPriceNumeric = actualPrice.replaceAll("[Rp.,\\s]", "");
//        ProductVariants productVariants = db.sql("select special_price from product_variants where product_id = '1340064'").first(ProductVariants.class);
//        String actualPriceNumeric = actualPrice.replaceAll("[Rp.,\\s]", "");
//        Assert.assertEquals(actualPriceNumeric, productVariants.specialPrice.toString().replaceAll("[Rp.,\\s]", ""),"The total price is incorrect" );
//    }

        }
    }
}
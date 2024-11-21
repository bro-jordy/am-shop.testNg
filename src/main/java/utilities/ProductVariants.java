package utilities;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name="product_variants")
public class ProductVariants {

    @Column(name = "special_price")
    public BigDecimal specialPrice;
}
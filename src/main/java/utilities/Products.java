package utilities;

import javax.persistence.Column;
import javax.persistence.Table;
@Table(name="products")
public class Products {

    @Column(name = "id")
    public Long id;
}
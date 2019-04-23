package productshop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProductseedDTO {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    public ProductseedDTO() {
    }


    @NotNull(message = "Name cannot be null.")
    @Size(min = 3, message = "name must be at least 3 symbol long.")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "Price cannot be null.")
    @Positive(message = "Price must be positive number.")
    @DecimalMin(value = "0.01", message = "Price must be at least 0.01")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

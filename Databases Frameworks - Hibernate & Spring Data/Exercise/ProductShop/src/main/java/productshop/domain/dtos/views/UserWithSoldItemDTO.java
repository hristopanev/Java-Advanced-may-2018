package productshop.domain.dtos.views;

import com.google.gson.annotations.Expose;

import java.util.List;

public class UserWithSoldItemDTO {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private List<SoldProductDTO> soldProducts;

    public UserWithSoldItemDTO() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SoldProductDTO> getSoldProducts() {
        return this.soldProducts;
    }

    public void setSoldProducts(List<SoldProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}

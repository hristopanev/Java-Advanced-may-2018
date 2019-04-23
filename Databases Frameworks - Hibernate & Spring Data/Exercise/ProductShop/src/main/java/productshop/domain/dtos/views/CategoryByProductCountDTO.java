package productshop.domain.dtos.views;

import java.math.BigDecimal;

public class CategoryByProductCountDTO {

    private String name;
    private Integer productCount;
    private Double averagePrice;
    private BigDecimal totalRevenue;

    public CategoryByProductCountDTO() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductCount() {
        return this.productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getAveragePrice() {
        return this.averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return this.totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}

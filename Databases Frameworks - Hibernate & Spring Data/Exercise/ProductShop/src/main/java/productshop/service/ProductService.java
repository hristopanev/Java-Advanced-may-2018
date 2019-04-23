package productshop.service;

import productshop.domain.dtos.views.ProductInRangeDTO;
import productshop.domain.dtos.ProductseedDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void seedProducts(ProductseedDTO[] productSeedDTOS);

    List<ProductInRangeDTO> productsInRange(BigDecimal more, BigDecimal less);



}

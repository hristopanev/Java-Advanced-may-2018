package productshop.web.Controllers;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import productshop.domain.dtos.CategorySeedDTO;
import productshop.domain.dtos.views.CategoryByProductCountDTO;
import productshop.domain.dtos.views.ProductInRangeDTO;
import productshop.domain.dtos.ProductseedDTO;
import productshop.domain.dtos.UserSeedDTO;
import productshop.domain.dtos.views.UserWithSoldItemDTO;
import productshop.service.CategoryService;
import productshop.service.ProductService;
import productshop.service.UserService;
import productshop.util.FileIOUtil;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@Transactional
public class ProductShopController implements CommandLineRunner {


    private final static String USER_FILE_PATH  ="D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\ProductShop\\src\\main\\resources\\files\\users.json";
    private final static String CATEGORIES_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\ProductShop\\src\\main\\resources\\files\\categories.json";
    private final static String PRODUCTS_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\ProductShop\\src\\main\\resources\\files\\products.json";

    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final FileIOUtil fileIOUtil;
    private final Gson gson;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, ProductService productService, FileIOUtil fileIOUtil, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.fileIOUtil = fileIOUtil;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
       /* this.seedUsers();
        this.seedCategories();
        this.seedProducts();
       productInRange();*/
        this.soldProduct();
    }

    private void seedUsers() throws IOException {
        String userFileContent = this.fileIOUtil.readFile(USER_FILE_PATH);

        UserSeedDTO[] userSeedDTOS = this.gson
                .fromJson(userFileContent, UserSeedDTO[].class);

        this.userService.seedUsers(userSeedDTOS);
    }

    private void seedCategories() throws IOException {
        String categoryFileContent = this.fileIOUtil.readFile(CATEGORIES_FILE_PATH);

        CategorySeedDTO[] categorySeedDTOS = this.gson
                .fromJson(categoryFileContent, CategorySeedDTO[].class);

        this.categoryService.seedCategories(categorySeedDTOS);
    }

    private void seedProducts() throws IOException {
        String productsFileContent = this.fileIOUtil.readFile(PRODUCTS_FILE_PATH);

        ProductseedDTO[] productSeedDTOS = this.gson
                .fromJson(productsFileContent, ProductseedDTO[].class);

        this.productService.seedProducts(productSeedDTOS);
    }

    private void productInRange() throws IOException {
        List<ProductInRangeDTO> productInRangeDTOS = this.productService
                .productsInRange(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        String productInRangeJson = this.gson.toJson(productInRangeDTOS);

        System.out.println(productInRangeJson);

        File file = new File("D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\ProductShop\\src\\main\\resources\\files\\output\\cars-and-parts.json");
        FileWriter writer = new FileWriter(file);
        writer.write(productInRangeJson);
        writer.close();
    }

    private void soldProduct(){
        List<UserWithSoldItemDTO> userWithSoldItemDTOS = this
                .userService.getAllBySellContainsProductBuyer();
        String soldProductJson = this.gson.toJson(userWithSoldItemDTOS);
        System.out.println(soldProductJson);
    }

    private void CategoryByProductCount(){
        List<CategoryByProductCountDTO> categoryByProductCountDTOS = (List<CategoryByProductCountDTO>) this.categoryService.getRandom();
    }
}

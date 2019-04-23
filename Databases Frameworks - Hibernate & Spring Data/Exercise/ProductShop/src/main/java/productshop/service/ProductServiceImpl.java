package productshop.service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.views.ProductInRangeDTO;
import productshop.domain.dtos.ProductseedDTO;
import productshop.domain.entities.Category;
import productshop.domain.entities.Product;
import productshop.domain.entities.User;
import productshop.repository.CategoryRepository;
import productshop.repository.ProductRepository;
import productshop.repository.UserRepository;
import productshop.util.ValidatorUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedProducts(ProductseedDTO[] productSeedDTOS) {

        for (ProductseedDTO productseedDTO : productSeedDTOS) {
            if (!this.validatorUtil.isValid(productseedDTO)) {
                this.validatorUtil.violations(productseedDTO)
                        .forEach(v -> System.out.println(v.getMessage()));

                continue;
            }

            Product entity = this.modelMapper
                    .map(productseedDTO, Product.class);

            entity.setSeller(this.getRandomUser());

            Random random = new Random();

            if (random.nextInt() % 13 != 0) {
                entity.setBuyer(this.getRandomUser());
            }

            entity.setCategories(this.getRandomCategories());

            this.productRepository.saveAndFlush(entity);
        }
    }

    private User getRandomUser() {
        Random random = new Random();

        return this.userRepository.getOne(random
                .nextInt((int) this.userRepository.count() - 1) + 1);
    }

    private List<Category> getRandomCategories() {
        Random random = new Random();

        List<Category> categories = new ArrayList<>();

        int categoriesCount = random.nextInt((int) this.categoryRepository.count() - 1) + 1;

        for (int i = 0; i < categoriesCount; i++) {
            categories.add(this.categoryRepository
                    .getOne(random
                            .nextInt((int) this.categoryRepository.count() - 1) + 1));

        }
        return categories;
    }


    @Override
    public List<ProductInRangeDTO> productsInRange(BigDecimal more, BigDecimal less) {
        List<Product> productEntities = this.productRepository
                .findAllByPriceBetweenAndBuyerOrderByPrice(more, less, null);

        List<ProductInRangeDTO> productInRangeDTOS = new ArrayList<>();
        for (Product productEntity : productEntities) {
            ProductInRangeDTO productInRangeDTO = this.modelMapper.map(productEntity, ProductInRangeDTO.class);
            productInRangeDTO.setSeller(String.format("%s %s",productEntity.getSeller().getFirstName(), productEntity.getSeller().getLastName()));
            productInRangeDTOS.add(productInRangeDTO);
        }
        return productInRangeDTOS;
    }


}

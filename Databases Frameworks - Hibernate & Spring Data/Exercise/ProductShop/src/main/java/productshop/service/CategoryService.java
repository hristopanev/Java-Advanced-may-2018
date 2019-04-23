package productshop.service;

import productshop.domain.dtos.CategorySeedDTO;
import productshop.domain.entities.Category;

public interface CategoryService {

    void seedCategories(CategorySeedDTO[] categorySeedDTOS);

    Category getRandom();
}

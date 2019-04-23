package productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productshop.domain.dtos.CategorySeedDTO;
import productshop.domain.dtos.views.CategoryByProductCountDTO;
import productshop.domain.entities.Category;
import productshop.repository.CategoryRepository;
import productshop.util.ValidatorUtil;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public void seedCategories(CategorySeedDTO[] categorySeedDTOS) {
        for (CategorySeedDTO categorySeedDTO : categorySeedDTOS) {
            if (!this.validatorUtil.isValid(categorySeedDTO)){
                this.validatorUtil.violations(categorySeedDTO)
                        .forEach(violation -> System.out.println(violation.getMessage()));
                continue;
            }

            Category entity = this.modelMapper.map(categorySeedDTO, Category.class);
            this.categoryRepository.saveAndFlush(entity);
        }
    }

    @Override
    public  Category getRandom(){
        return this.categoryRepository.getRandomEntity();
    }

    public List<CategoryByProductCountDTO> getCategoryByProductCount() {
        return this.categoryRepository.getcategoryByProductCount();
    }
}

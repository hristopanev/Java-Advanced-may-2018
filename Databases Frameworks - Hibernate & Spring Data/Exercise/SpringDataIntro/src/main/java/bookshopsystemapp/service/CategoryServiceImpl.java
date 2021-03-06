package bookshopsystemapp.service;


import bookshopsystemapp.domain.entities.Category;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CategoryServiceImpl implements CategoryService{

    private static final String CATEGORIES_FILE_PATH = "D:\\Project\\Java\\Java-Fundamentals\\Databases Frameworks - Hibernate & Spring Data\\Exercise\\SpringDataIntro\\src\\main\\resources\\files\\categories.txt";

    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }


    @Override
    public void seedCategories() throws IOException {
        if (this.categoryRepository.count() != 0){
            return;
        }

        String[] categoryFileContent = this.fileUtil.getFileContent(CATEGORIES_FILE_PATH);

        for (String line : categoryFileContent) {

            Category category = new Category();
            category.setName(line);

            this.categoryRepository.saveAndFlush(category);
        }
    }
}

package judgesystem.service;

import judgesystem.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final FileUtil fileUtil;

    @Autowired
    public CategoryServiceImpl(FileUtil fileUtil) {
        this.fileUtil = fileUtil;
    }

    @Override
    public String importCategories(String categoriesFileContent) {
        return null;
    }
}

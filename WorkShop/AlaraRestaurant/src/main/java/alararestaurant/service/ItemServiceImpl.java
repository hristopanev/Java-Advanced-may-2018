package alararestaurant.service;

import alararestaurant.domain.dtos.ItemImportDto;
import alararestaurant.domain.entities.Category;
import alararestaurant.domain.entities.Item;
import alararestaurant.repository.CategoryRepository;
import alararestaurant.repository.ItemRepository;
import alararestaurant.util.FileUtil;
import alararestaurant.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ItemServiceImpl implements ItemService {

    private final static String ITEM_FILE_IMPORT_JSON = System.getProperty("user.dir") + "/src/main/resources/files/items.json";

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, Gson gson, FileUtil fileUtil, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public Boolean itemsAreImported() {
        return this.itemRepository.count() > 0;
    }

    @Override
    public String readItemsJsonFile() throws IOException {
        return this.fileUtil.readFile(ITEM_FILE_IMPORT_JSON);    }

    @Override
    public String importItems(String items) {
        StringBuilder importResult = new StringBuilder();

        ItemImportDto[] itemImportDtos = this.gson.fromJson(items, ItemImportDto[].class);

        Arrays.stream(itemImportDtos)
                .forEach(itemImportDto -> {

                    Category categoryEntity = this.modelMapper.map(itemImportDto, Category.class);

                    categoryEntity.setName(itemImportDto.getCategory());

                    if (!this.validationUtil.isValid(categoryEntity)){

                        importResult.append("Invalid data format.").append(System.lineSeparator());

                        return;
                    }

                    this.categoryRepository.saveAndFlush(categoryEntity);


                    Item itemEntity = this.modelMapper.map(itemImportDto, Item.class);
                    itemEntity.setCategory(categoryEntity);
                    this.itemRepository.saveAndFlush(itemEntity);

                    importResult.append(String.format("Record %s successfully imported.",
                            itemEntity.getClass().getSimpleName(), itemEntity.getName())).append(System.lineSeparator());



                });
        return importResult.toString().trim();
    }
}

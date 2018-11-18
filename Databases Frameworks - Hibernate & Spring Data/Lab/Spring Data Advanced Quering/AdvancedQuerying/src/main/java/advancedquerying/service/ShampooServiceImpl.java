package advancedquerying.service;

import advancedquerying.domain.entities.Ingredient;
import advancedquerying.domain.entities.Shampoo;
import advancedquerying.domain.entities.Size;
import advancedquerying.repository.IngredientRepository;
import advancedquerying.repository.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {

    private final ShampooRepository shampooRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository, IngredientRepository ingredientRepository) {
        this.shampooRepository = shampooRepository;
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public List<String> selectShampoosBySize(String inputSize) {
        Size size = Size.valueOf(inputSize.toUpperCase());

        List<Shampoo>shampoos = this.shampooRepository
                .findAllBySizeOrderById(size);

        return shampoos
                .stream()
                .map(shampoo ->
                    String.format("%s %s %.2flv",
                            shampoo.getBrand(), shampoo.getSize().name(), shampoo.getPrice())
                ).collect(Collectors.toList());
    }


    @Override
    public List<String> selectShampoosByIngredients(List<String> ingredientNames) {

        Set<Ingredient> ingredients = this.ingredientRepository.findAllByNameIn(ingredientNames);
        List<Shampoo> shampoos = this.shampooRepository.findByIngredientsIn(ingredients);
        return shampoos
                .stream()
                .map(s -> s.getBrand()).collect(Collectors.toList());
    }
}

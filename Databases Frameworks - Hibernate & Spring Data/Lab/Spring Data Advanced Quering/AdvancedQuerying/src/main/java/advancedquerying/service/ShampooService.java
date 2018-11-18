package advancedquerying.service;


import java.util.List;

public interface ShampooService {

    List<String> selectShampoosBySize(String inputSize);

    List<String> selectShampoosByIngredients(List<String> ingredientNames);
}

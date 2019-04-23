package hell.entities.items;

import hell.interfaces.Recipe;

import java.util.Collections;
import java.util.List;

public class RecipeItem extends BaseItem implements Recipe {

    private List<String> requireItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus,
                      int intelligenceBonus, int hitPointsBonus, int damageBonus, List<String> requireItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requireItems = requireItems;
    }

    @Override
    public List<String> getRequiredItems() {
        return Collections.unmodifiableList(this.requireItems);
    }
}

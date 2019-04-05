package hell.entities.miscellaneous;

import hell.interfaces.Inventory;
import hell.interfaces.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroInventoryTest {

    private static final int VALUE = Integer.MAX_VALUE;
    private static final String STRENGTH_MESSAGE = "strength is not correct";
    private static final String AGILITY_MESSAGE = "agility is not correct";
    private static final String INTELLIGENCE_MESSAGE = "intelligence is not correct";
    private static final String HIT_POINTS_MESSAGE = "hit points is not correct";
    private static final String DAMAGE_MESSAGE = "damage is not correct";

    private Inventory inventory;


    @Before
    public void setUp() throws Exception {
        this.inventory = new HeroInventory();
    }

    private Item createCommonItemMock(){
        Item commonItem = Mockito.mock(Item.class);

        Mockito.when(commonItem.getStrengthBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getName()).thenReturn(String.valueOf(Math.random()));
        Mockito.when(commonItem.getAgilityBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getIntelligenceBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getHitPointsBonus()).thenReturn(VALUE);
        Mockito.when(commonItem.getDamageBonus()).thenReturn(VALUE);

        return commonItem;
    }

    private void seedCommonItems(){
       this.inventory.addCommonItem(this.createCommonItemMock());
       this.inventory.addCommonItem(this.createCommonItemMock());
       this.inventory.addCommonItem(this.createCommonItemMock());
    }

    @Test
    public void getTotalStrengthBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actualTotalStrengthBonus = this.inventory.getTotalStrengthBonus();
        long expectedTotalStrengthBonus = 3L * VALUE;

        // Assert
        Assert.assertEquals(STRENGTH_MESSAGE, expectedTotalStrengthBonus, actualTotalStrengthBonus);

    }

    @Test
    public void getTotalAgilityBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actualTotalBonus = this.inventory.getTotalAgilityBonus();
        long expectedTotalBonus = 3L * VALUE;

        // Assert
        Assert.assertEquals(AGILITY_MESSAGE, expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void getTotalIntelligenceBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actualTotalBonus = this.inventory.getTotalIntelligenceBonus();
        long expectedTotalBonus = 3L * VALUE;

        // Assert
        Assert.assertEquals(INTELLIGENCE_MESSAGE, expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void getTotalHitPointsBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actualTotalBonus = this.inventory.getTotalHitPointsBonus();
        long expectedTotalBonus = 3L * VALUE;

        // Assert
        Assert.assertEquals(HIT_POINTS_MESSAGE, expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void getTotalDamageBonus() {
        // Arrange
        this.seedCommonItems();

        // Act
        long actualTotalBonus = this.inventory.getTotalDamageBonus();
        long expectedTotalBonus = 3L * VALUE;

        // Assert
        Assert.assertEquals(DAMAGE_MESSAGE, expectedTotalBonus, actualTotalBonus);
    }

    @Test
    public void addCommonItem() {
    }

    @Test
    public void addRecipeItem() {
    }
}
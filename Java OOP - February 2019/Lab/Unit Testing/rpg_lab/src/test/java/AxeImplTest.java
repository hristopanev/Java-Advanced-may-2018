import org.junit.Before;
import org.junit.Test;
import rpg_lab.AxeImpl;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

public class AxeImplTest {



    private Dummy dummy;

    @Before
    public void beforeEach() {
        dummy = new Dummy(BASE_HP, BASE_XP);
    }

    @Test
    public void axeShouldLoseDurabilityAfterAttack() {
        AxeImpl axeImpl = new AxeImpl(BASE_ATTACK, BASE_DURABILITY);
        axeImpl.attack(dummy);

        assertEquals(BASE_DURABILITY - 1, axeImpl.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeShouldThrowIfNegativeDurability() {
        AxeImpl axeImpl = new AxeImpl(BASE_ATTACK, -BASE_DURABILITY);

        axeImpl.attack(dummy);
    }
}

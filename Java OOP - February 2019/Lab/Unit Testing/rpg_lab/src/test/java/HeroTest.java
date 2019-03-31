import fakes.FakeAxe;
import fakes.FakeTarget;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Axe;
import rpg_lab.Hero;
import rpg_lab.Target;

import static utils.Constants.BASE_XP;

public class HeroTest {

    @Test
    public void shouldReceiveXPWhenTargetDies(){
        Hero hero = new Hero(new FakeAxe(), "Krum");
        Target target = new FakeTarget();

        hero.attack(target);

        Assert.assertEquals(hero.getExperience(), BASE_XP);
    }

    @Test
    public void shouldGetLootAfterTargetKill(){
        Axe loot = new FakeAxe();

        Hero hero = new Hero(new FakeAxe(), "Kilio");
        Target target = Mockito.mock(Target.class);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.getLoot()).thenReturn(loot);

        hero.attack(target);

        Assert.assertEquals(loot, hero.getInventory().get(0));

    }
}

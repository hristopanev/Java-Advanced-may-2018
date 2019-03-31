import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Dummy;

import static org.junit.Assert.assertEquals;
import static utils.Constants.BASE_ATTACK;
import static utils.Constants.BASE_HP;
import static utils.Constants.BASE_XP;

public class DummyTest {


    private Dummy dummy;


    @Before
    public void beforeEach(){
        dummy = new Dummy(BASE_HP, BASE_XP);
    }

    @Test
    public void shouldLoseHealthWhenAttacked(){
        dummy.takeAttack(BASE_ATTACK);

        assertEquals("Dummy health not correct after attack",
                BASE_HP - BASE_ATTACK, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenDeadOnAttack(){
        Dummy dummy = new Dummy(-BASE_HP, BASE_XP);

        dummy.takeAttack(BASE_ATTACK);
    }

    @Test
    public void shouldGiveXPIfDead(){
//        Dummy mocked = Mockito.mock(Dummy.class);
//        Mockito.when(mocked.giveExperience()).thenReturn(BASE_XP);

        Dummy dummy = new Dummy(-BASE_HP, BASE_XP);

        int actual = dummy.giveExperience();

        assertEquals(BASE_XP, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionIfGettingExperienceOnALive(){
        dummy.giveExperience();
    }
}

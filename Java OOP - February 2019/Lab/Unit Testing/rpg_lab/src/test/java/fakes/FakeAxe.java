package fakes;

import rpg_lab.Axe;
import rpg_lab.Target;

import static utils.Constants.BASE_ATTACK;

public class FakeAxe implements Axe {

    public void attack(Target target) {
    }

    public int getAttackPoints() {
        return BASE_ATTACK;
    }

    public int getDurabilityPoints() {
        return 0;
    }
}

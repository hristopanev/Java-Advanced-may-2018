package app.models.participants;

import app.constants.Config;
import app.contracts.Targetable;

public class Boss extends AbstractActor {


    public Boss(String name) {
        super(name, Config.BOSS_HEALTH, Config.BOSS_DAMAGE, Config.BOSS_GOLD);
    }

    @Override
    public double getDamage() {
        return Config.BOSS_DAMAGE;
    }

    @Override
    public void receiveReward(double reward) {
        super.addGold(reward * Config.BOSS_GOLD_MULTIPLIER);
    }

    @Override
    public void giveReward(Targetable targetable) {
        targetable.receiveReward(Config.BOSS_INDIVIDUAL_REWARD);
    }

    @Override
    public void levelUp() {
        this.setHealth(Config.BOSS_HEALTH);
    }

}

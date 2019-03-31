package rpg_lab;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int experience;
    private Axe weapon;
    private List<Axe> inventory;

    public Hero(Axe axe, String name) {
        this.name = name;
        this.experience = 0;
        this.weapon = axe;
        this.inventory = new ArrayList<Axe>();
    }

    public List<Axe> getInventory(){
        return this.inventory;
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Axe getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.getLoot());
        }
    }
}

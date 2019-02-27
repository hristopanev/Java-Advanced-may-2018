package heroRepository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class HeroRepository {
    private Map<String, Hero> data;

    public HeroRepository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Hero hero){
        data.putIfAbsent(hero.getName(), hero);
    }

    public void remove(String  hero){
        if (data.size() > 1){
            for (String s : data.keySet()) {
                if (s.equalsIgnoreCase(hero)){
                    data.remove(s);
                    return;
                }
            }
        }

    }

    public Hero getHeroWithHighestStrength(){
        int hightStrength = 0;
        String name = "";

        for (Hero value : data.values()) {
            int  strength = value.getItem().getStrength();

            if (strength > hightStrength){
                hightStrength = strength;
                name = value.getName();
            }
        }
        return this.data.get(name);
    }

    public Hero getHeroWithHighestAgility(){
        int hightAgility = 0;
        String name = "";

        for (Hero value : data.values()) {
            int  agility = value.getItem().getAgility();

            if (agility > hightAgility){
                hightAgility = agility;
                name = value.getName();
            }
        }
        return this.data.get(name);
    }

    public Hero getHeroWithHighestIntelligence(){
        int hightIntelligence = 0;
        String name = "";

        for (Hero value : data.values()) {
            int  iligence = value.getItem().getIntelligence();

            if (iligence > hightIntelligence){
                hightIntelligence = iligence;
                name = value.getName();
            }
        }
        return this.data.get(name);
    }

    public int getCount(){
        return this.data.size();


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Hero> entry : data.entrySet()) {
            sb.append(String.format("%s", entry.getValue())).append(System.lineSeparator());

//            sb.append(String.format("Hero: %s - %s", entry.getValue().getName(), entry.getValue().getLevel())).append(System.lineSeparator())
//                    .append(String.format("   *   Strength: %d%n   *   Agility: %d%n   *   Intelligence: %d",
//                            entry.getValue().getItem().getStrength(),
//                            entry.getValue().getItem().getAgility(),
//                            entry.getValue().getItem().getIntelligence())).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
//  * Strength: 23
//  * Agility: 35
//  * Intelligence: 48

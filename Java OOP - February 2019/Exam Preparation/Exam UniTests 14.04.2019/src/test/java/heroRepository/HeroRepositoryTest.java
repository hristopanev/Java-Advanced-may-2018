package heroRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroRepositoryTest {

    private HeroRepository heroRepository;

    @Before
    public void setUp() throws Exception {
        this.heroRepository = new HeroRepository();
        Item items = new Item(10, 10, 10);
        Hero peter = new Hero("Peter", 12, items);
        this.heroRepository.add(peter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowExceptionWhenDuplicateHero() {
       Item newItem = new Item(10, 10, 10);
        Hero peter =  new Hero("Peter", 12, newItem);

        this.heroRepository.add(peter);
    }

    @Test
    public void add() {
        Item newItem = new Item(10, 10, 10);
        Hero ivan =  new Hero("Ivan", 12, newItem);

        this.heroRepository.add(ivan);
    }

    @Test
    public void remove() {
        this.heroRepository.remove("Peter");
    }

    @Test(expected = NullPointerException.class)
    public void removeWhenNotExist() {
        this.heroRepository.remove("Ivan");
    }

    @Test
    public void getHeroWithHighestStrength() {
        Item newItem = new Item(30, 10, 10);
        Hero ivan =  new Hero("Ivan", 12, newItem);
        this.heroRepository.add(ivan);
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthThrowExceptionWhenHeroNotExist() {
        this.heroRepository.remove("Peter");
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestAgility() {
        Item newItem = new Item(30, 80, 10);
        Hero ivan =  new Hero("Ivan", 12, newItem);
        this.heroRepository.add(ivan);
        this.heroRepository.getHeroWithHighestAgility();
    }
    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityThrowExceptionWhenHeroNotExist() {
        this.heroRepository.remove("Peter");
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestIntelligence() {
        Item newItem = new Item(30, 10, 80);
        Hero ivan =  new Hero("Ivan", 12, newItem);
        this.heroRepository.add(ivan);
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceThrowExceptionWhenHeroNotExist() {
        this.heroRepository.remove("Peter");
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getCount() {
        assertEquals(1, this.heroRepository.getCount());
    }
}
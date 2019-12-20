import java.util.ArrayList;
import java.util.List;

public class SortList {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();

        players.add(new Player("John", 3));
        players.add(new Player("Ivan", 8));
        players.add(new Player("Alex", 23));
        players.add(new Player("Vladimir", 12));
        players.add(new Player("Don", 88));
        players.add(new Player("Peter", 1));

        BubbleSort bubbleSort = new BubbleSort();
        players = bubbleSort.sortList(players);

        System.out.println("Sort List of Players by Name:");
        players.forEach(player -> System.out.println(player.toString()));
        System.out.println("_______________________________ \n");

        players = bubbleSort.sortListByNumber(players);
        System.out.println("Sort List of Players by Number:");
        players.forEach(player -> System.out.println(player.toString()));
    }
}

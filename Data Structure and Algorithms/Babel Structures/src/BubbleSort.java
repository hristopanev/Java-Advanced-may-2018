import java.util.List;

public class BubbleSort {

    public int[] sortNumber(int[] array) {
        int temp;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j +1];
                    array[j +1] = temp;
                }
            }
        }
        return array;
    }

    public String[] sortString(String[] stringArray) {
        String temp;

        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int j = 0; j < stringArray.length - 1; j++) {
                if (stringArray[j].compareTo(stringArray[j +1]) > 0) {
                    temp = stringArray[j];
                    stringArray[j] = stringArray[j +1];
                    stringArray[j +1] = temp;
                }
            }
        }

        return stringArray;
    }

    public List<Player> sortList(List<Player> playerList) {

        Player player;

        for (int i = 0; i < playerList.size() - 1; i++) {
            for (int j = 0; j < playerList.size() - 1; j++) {
                if (playerList.get(j).compareTo(playerList.get(j +1)) > 0) {
                    player = playerList.get(j);
                    playerList.set(j, playerList.get(j + 1));
                    playerList.set(j +1, player);
                }
            }
        }
        return playerList;
    }

    public List<Player> sortListByNumber(List<Player> players) {

        Player player;

        for (int i = 0; i < players.size() -1; i++) {
            for (int j = 0; j < players.size() - 1; j++) {
                if (players.get(j).getNumber() > players.get(j +1).getNumber()) {
                    player = players.get(j);
                    players.set(j, players.get(j +1));
                    players.set(j +1, player);
                }
            }
        }

        return players;
    }
}

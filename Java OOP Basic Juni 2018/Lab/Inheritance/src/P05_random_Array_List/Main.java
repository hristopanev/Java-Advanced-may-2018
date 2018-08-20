package P05_random_Array_List;

public class Main {
    public static void main(String[] args) {

        RandomArrayList myArrayList = new RandomArrayList();


        myArrayList.add(5);
        myArrayList.add(15);
        myArrayList.add(25);
        myArrayList.add(35);
        myArrayList.add(45);


        System.out.println(myArrayList.getRandomElement());
    }
}

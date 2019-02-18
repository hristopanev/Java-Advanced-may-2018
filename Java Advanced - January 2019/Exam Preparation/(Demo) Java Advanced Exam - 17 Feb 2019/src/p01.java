import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] leftSocksInput = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] rightSocksInput = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> leftSocks = new ArrayDeque<>();
        ArrayDeque<Integer> rightSocks = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        fillItems(leftSocksInput, leftSocks);
        fillItems(rightSocksInput, rightSocks);

        int leftIndex = 0;
        int rightIndex = 0;

        while (!leftSocks.isEmpty()){
            if (leftSocks.isEmpty() || rightSocks.isEmpty()){
                break;
            }
            leftIndex = leftSocks.pollLast();
            rightIndex = rightSocks.pop();

            if (leftIndex == rightIndex){
                leftSocks.add(leftIndex + 1);
            }else if (rightIndex > leftIndex){
                rightSocks.addFirst(rightIndex);
            }else {
                result.add(leftIndex + rightIndex);
            }
        }

        rightIndex = 0;
        for (Integer integer : result) {
            if (rightIndex < integer){
                rightIndex = integer;
            }
        }
        System.out.println(rightIndex);
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }


    }

    private static void fillItems(int[] SocksInput, ArrayDeque<Integer> socks) {
        for (int sock : SocksInput) {
            socks.add(sock);
        }
    }


}

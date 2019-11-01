package algorithms.implementation;

import java.util.Scanner;
import java.util.stream.IntStream;

public class BeautifulTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        int[] array = new int[n];
        IntStream.range(0, n).forEach(el ->
                array[el] = in.nextInt()
        );
        Result res = new Result();

        for (int middle =1; middle < array.length - 1; middle++) {
            for (int left =0; left < middle; left++) {
                if (array[middle] - array[left] < d){
                    break;
                }
                for (int right =middle; right < array.length; right++) {
                    if (array[right] - array[middle] > d){
                        break;
                    }
                    checkIfConditionIsMet(res, d, array[left],
                            array[middle], array[right]);
                }
            }
        }
        System.out.println(res.counter);
    }

    public static void checkIfConditionIsMet(Result res, int d, int
            left, int middle, int right) {
        if (2 * middle - left - right == 0) {
            res.counter++;
        }
    }
}

class Result {
    int counter = 0;
}

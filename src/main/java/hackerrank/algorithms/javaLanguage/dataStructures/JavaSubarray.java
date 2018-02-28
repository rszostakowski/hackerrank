package hackerrank.algorithms.javaLanguage.dataStructures;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int counter = IntStream.range(0, n)
                .map(pos -> (int) IntStream.range(1, n - pos + 1)
                        .mapToObj((int len) -> Arrays.copyOfRange(arr, pos, pos + len))
                        .map((int[] choppedArr) -> Arrays.stream(choppedArr).sum())
                        .filter(sum -> sum < 0)
                        .count())
                .sum();
        System.out.println(counter);
    }
}
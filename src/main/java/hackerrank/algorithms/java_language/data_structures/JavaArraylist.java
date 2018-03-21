package hackerrank.algorithms.java_language.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaArraylist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List list = new ArrayList<int[]>();
        int numOfArrays = in.nextInt();

        IntStream.range(0, numOfArrays)
                .forEach(el -> {
                    int numOfElems = in.nextInt();
                    int[] arr = new int[numOfElems];
                    IntStream.range(0, numOfElems)
                            .forEach(idx -> arr[idx] = in.nextInt());
                    list.add(arr);
                });

        int numOfInserts = in.nextInt();
        IntStream.range(0, numOfInserts)
                .forEach(el -> {
                    int arrNum = in.nextInt();
                    int elem = in.nextInt();
                    System.out.println(getElement(list, arrNum, elem));
                });
    }

    private static String getElement(List<int[]> list, int arrNum, int elem) {
        int[] givenArr = list.get(arrNum - 1);
        if (elem > givenArr.length) {
            return "ERROR!";
        } else {
            return Integer.toString(givenArr[elem - 1]);
        }
    }
}

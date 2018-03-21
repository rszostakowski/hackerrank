package hackerrank.algorithms.java_language.data_structures;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaList {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List myList = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            myList.add(in.nextInt());
        }

        int numOfOperations = in.nextInt();
        IntStream.range(0, numOfOperations)
                .forEach(el -> {
                    String operation = in.next();
                    if ("Insert".equals(operation)) {
                        int insertIdx = in.nextInt();
                        int numToInsert = in.nextInt();
                        myList.add(insertIdx, numToInsert);
                    } else {
                        int idxToDelete = in.nextInt();
                        myList.remove(idxToDelete);
                    }
                });
        System.out.println(myList.stream()
                .map(i -> i.toString())
                .collect(Collectors.joining(" ")));
    }

}

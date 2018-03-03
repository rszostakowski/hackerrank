package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.BitSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class JavaBitSet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        BitSet first = new BitSet(n);
        BitSet second = new BitSet(n);

        IntStream.range(0, m)
                .forEach(el -> {
                    String op = in.next();
                    int s1 = in.nextInt();
                    int s2 = in.nextInt();
                    parseOperation(first, second, op, s1, s2);
                    System.out.println(first.cardinality() + " " + second.cardinality());
                });
    }

    private static void parseOperation(BitSet first, BitSet second, String op, int s1, int s2) {
        switch (op) {
            case "AND":
                first.and(second);
                break;
            case "SET":
                if (s1 ==1)
                    first.set(s2);
                else
                    second.set(s2);
                break;
            case "FLIP":
                if (s1 ==1)
                    first.flip(s2);
                else
                    second.flip(s2);
                break;
            case "OR":
                second.or(first);
                break;
            default:
                throw new RuntimeException();
        }
    }
}
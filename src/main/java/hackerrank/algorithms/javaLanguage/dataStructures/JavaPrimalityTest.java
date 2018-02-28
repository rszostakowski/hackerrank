package hackerrank.algorithms.javaLanguage.dataStructures;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaPrimalityTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        in.close();
        if (n.isProbablePrime(90)) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
}

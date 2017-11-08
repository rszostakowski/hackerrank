package hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num1 = 1;
        int num2 = 99999;
        String collected = IntStream.range(num1, num2)
                .filter(ModifiedKaprekarNumbers::checkIfKaprekarNumber)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(" "));

        System.out.println(collected.length() == 0 ? "INVALID RANGE" : collected);
    }

    public static boolean checkIfKaprekarNumber(int num){
        BigInteger bigNum = BigInteger.valueOf(num);
        BigInteger sqr = bigNum.multiply(bigNum);
        String squaredString = String.valueOf(sqr);
        int length = squaredString.length();
        String s1 = squaredString.substring(0, length/2);
        String s2 = squaredString.substring(length/2, length);
        int l = s1.length() == 0 ? 0 : Integer.valueOf(s1);
        int r = s2.length() == 0 ? 0 : Integer.valueOf(s2);
        int sum =  l + r;
        return sum == num;
    }
}

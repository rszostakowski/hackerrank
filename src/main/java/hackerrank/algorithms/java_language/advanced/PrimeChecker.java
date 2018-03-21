package hackerrank.algorithms.java_language.advanced;

import java.util.Arrays;

public class PrimeChecker {

    public static void main(String[] args) {
        int[] chars = new int[]{2, 1, 3, 4, 5};
        PrimeChecker ob = new PrimeChecker();
        ob.checkPrime(2);
        ob.checkPrime(2, 1);
        ob.checkPrime(2, 1, 3);
        ob.checkPrime(2, 1, 3, 4);
        ob.checkPrime(2, 1, 3, 4, 5);
    }

    private void checkPrime(int... chars) {

        Arrays.stream(chars)
                .filter(this::isPrime)
                .forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    private boolean isPrime(int n) {
        if (n == 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        // squere root is always in the middle
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

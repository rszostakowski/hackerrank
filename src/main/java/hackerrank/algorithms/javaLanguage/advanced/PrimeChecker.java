package hackerrank.algorithms.javaLanguage.advanced;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimeChecker {
    void checkPrime(int... chars) {

        Arrays.stream(chars)
                .filter(el -> el>1)
                .forEach(this::isPrime);

    }

    private void isPrime(int i) {

        if (i == 2) System.out.println(i);

        IntStream.range(3,i)
                .filter(el -> i % el != 0)
                .forEach(
                        el -> System.out.println(el)
                );
    }
}

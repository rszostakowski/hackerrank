package hackerrank.algorithms.java_language.oop;

import java.util.stream.IntStream;

public class JavaInterface {

    interface AdvancedArithmetic{
        int divisor_sum(int n);
    }

    class MyCalculator implements AdvancedArithmetic {

        @Override
        public int divisor_sum(int n) {
            return IntStream.range(1, n+1)
                    .filter(el-> n%el == 0)
                    .sum();
        }
    }
}

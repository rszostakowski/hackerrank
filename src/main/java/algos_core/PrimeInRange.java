package algos_core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrimeInRange {
    public static void main(String[] args) {
        List<Long> inputs = new LinkedList<>();
        inputs.add(10l);
        inputs.add(17l);


        long max = inputs.stream().max(Long::compareTo).orElse(0l);
        List<Integer> primeInRange = new ArrayList<>();
        int min = 2;

        for(int n=min;n<=max;n++) {
            if(isPrime(n)) {
                primeInRange.add(n);
            }
        }

    }

    public static boolean isPrime(long num) {
        for(int i = 2; i <= num/i; ++i) { // HERE IS THE MOST IMPORTANT BIT
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

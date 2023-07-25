package contents.project_euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenFibonacciNumbers {

    public static void main(String[] args) {
        long n = 100;
        List<Long> cache = new ArrayList<>();

        cache.add(1l);
        cache.add(1l);
        cache.add(2l);

        for (int i = 1; i <= n; i++) {
            long res = calculateFibo(cache, i);
            if (res > n) {
                break;
            }
        }

        long sumRes = cache.stream().filter(el -> el % 2 == 0 && el < n).mapToLong(el -> el).sum();
        System.out.println(sumRes);
    }

    public static long calculateFibo(List<Long> cache, int n) {
        if (cache.size() > n) {
            return cache.get(n);
        }
        long result = calculateFibo(cache, n-1) + calculateFibo(cache, n-2);
        cache.add(result);
        return result;
    }
}

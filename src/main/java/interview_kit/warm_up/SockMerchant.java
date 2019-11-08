package interview_kit.warm_up;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        System.out.println(Arrays.toString(ar));

        Map<Integer, Integer> freqs = new HashMap<>();
        for (int c : ar) {
            freqs.merge(c,
                    1,
                    Integer::sum);
        }
        freqs.forEach((k, v) -> System.out.println("k: " + k + " v: " + v));

        int sum = freqs.values().stream().mapToInt(v -> v / 2).sum();
        System.out.println(sum);

        return sum;
    }
}
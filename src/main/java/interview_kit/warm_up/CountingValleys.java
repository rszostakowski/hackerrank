package interview_kit.warm_up;
import java.util.*;
import java.util.stream.IntStream;

public class CountingValleys {

    // Complete the sockMerchant function below.
    static int countingValleys(int n, String s) {

        int counted = (int) IntStream.range(0, n-1)
		.mapToObj(num -> s.substring(num, num+2))
		.filter(str -> str.equals("UD") || str.equals("DU"))
                // .forEach(k-> System.out.println(k));
		.count();

	System.out.println(counted);
        return counted;
    }

    public static void main(String[] args) {
        countingValleys(8,"UDDDUDUU");
    }
}


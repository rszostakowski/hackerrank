package contents.project_euler;

import java.util.LinkedList;
import java.util.List;

public class LargestPrimeFactor
{
    public static void main(String[] args) {


        List<Long> inputs = new LinkedList<>();
        inputs.add(34l);
        inputs.add(81l);

        inputs.stream().forEach(LargestPrimeFactor::findLargestDiv);

    }

    public static void findLargestDiv(long num) {
        long largestDiv = 0;
        for(int i = 2; i <= num/i; ++i) {
            if(num % i == 0 && isPrime(num/i)) {
                largestDiv = Math.max(largestDiv, num/i);
            } else if (num % i == 0 && isPrime(i)){
                largestDiv = Math.max(largestDiv, i);
            }
        }
        if (largestDiv == 0) {
            largestDiv = num;
        }
        System.out.println(largestDiv);
    }

    public static boolean isPrime(long num) {
        for(int i = 2; i <= num/i; ++i) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

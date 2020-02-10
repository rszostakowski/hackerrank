package interview_kit.warm_up;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountingValleys {

    // Complete the sockMerchant function below.
    static int countingValleys(int n, String s) {

	int prev = 0;
	int current = 0;
	int counter = 0;
	for (int i = 1; i < n+1; i++) {
		
		String letter = s.substring(i-1,i);
		if(letter.equals("U")){
			current ++;
		} else {
			current --;
		}
			
		System.out.println("prev: " + prev+ " current: " + current);
		if ( prev < 0 && current == 0) {
			counter ++;
		}
		prev = current;
		
	}
		
	System.out.println(counter);
        return counter;
    }

    public static void main(String[] args) {
        // countingValleys(10,"UDUUUDUDDD");
        countingValleys(8,"UDDDUDUU");
    }
}


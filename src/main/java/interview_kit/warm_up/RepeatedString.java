package interview_kit.warm_up;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class RepeatedString {

    static long repeatedString(String s, long n) {
	
	char firstLetter = s.charAt(0);

	long count = s.chars().filter(ch -> ch == firstLetter).count();

	long numOfOcc = n / (long) s.length();
	long rest = n - numOfOcc * (long) s.length(); 

	System.out.println("x : " + numOfOcc + " rest: " +rest);
	System.out.println(count);

	long restCounter = 0l;
	if (rest != 0l) {
		restCounter  = s.substring(0, (int) rest).chars().filter(ch -> ch == firstLetter).count();
	}
	
	return count * numOfOcc + restCounter;
    }

    public static void main(String[] args) {
	// repeatedString("aba", 10);
	// System.out.println(repeatedString("a",1000000000000l));
	System.out.println(repeatedString("ceebbcb",817723));
    }
}

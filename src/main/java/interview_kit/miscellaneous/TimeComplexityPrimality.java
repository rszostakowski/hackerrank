package interview_kit.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class TimeComplexityPrimality {

	static String primality(int n) {
		if(n == 1) {
			return "Not prime";
		}
		int i = 2;
		while (i <= Math.sqrt(n)){
			if ( n % i == 0) {
				return "Not prime";
			}
			i++;
		}
		return "Prime";

	}
	public static void main(String[] args) {
		System.out.println(primality(2));
		System.out.println(primality(3));
		System.out.println(primality(4));
	}
}

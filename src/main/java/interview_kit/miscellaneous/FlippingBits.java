
package interview_kit.miscellaneous;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class FlippingBits {

	// Complete the sockMerchant function below.
	static long flippingBits(long n) {
		


	return 4294967295l - n;
	}

	// static String convertToBinary(long n) {
	// 	String result = "
	// 	if (n == 1) {
	// 		return "1";
	// 	}
        //
	// 	if( n == 0) {
	// 		return "0";
	// 	}
	// 	for (int i =1; i<=32; i++) {
        //
	// 		int powered = Math.pow(
	// 	}
	// }
        //
	// public static String repeat(int count, String with) {
	// 	return new String(new char[count]).replace("\0", with);
	// }
        //
	// static long flipBits(long n) {
	// 	return 0l;
	// }

	public static void main(String[] args) {
		System.out.println(flippingBits(2147483647));
		System.out.println(flippingBits(1));
		System.out.println(flippingBits(0));
		// System.out.println(convertToBinary(8));
		// System.out.println(convertToBinary(1));
		// System.out.println(convertToBinary(2));
		// System.out.println(convertToBinary(3));
		// System.out.println(convertToBinary(4));
		// System.out.println(convertToBinary(8));
	}
// https://www.rapidtables.com/convert/number/decimal-to-binary.html
}

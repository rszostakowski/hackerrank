
package interview_kit.warm_up;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
	System.out.println(Arrays.toString(c));

	int counter = 0;
	int i = 0;

	while (i < c.length-1) {
		if (i < c.length -2 && c[i+2] == 1) {
			System.out.println("i: " + i + " c[i+2]: " + c[i+2]);
			i++;
		} else {
			i=i+2;
		}
	
		System.out.println("After incrementing: " + i);
		counter++;
	}
		
	System.out.println(counter);
	return counter;
    }

    public static void main(String[] args) {
	int[] input = new int[] {0, 0, 1, 0, 0, 1, 0};
        jumpingOnClouds(input);
    }
}

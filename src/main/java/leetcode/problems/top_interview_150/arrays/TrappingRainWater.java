package leetcode.problems.top_interview_150.arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(arr);
    }
    // my solution
    public int trapMy(int[] height) {

        int n = height.length;
        if (n == 1) {
            return 0;
        }

        int max = 0;
        int idxOfMax = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] >= max) {
                max = height[i];
                idxOfMax = i;
            }
        }

        int counter = 0;

        int left = 0;
        for (int i = 0; i < idxOfMax; i++) {
            if (height[i] < left) {
                counter += (left - height[i]);
            }
            left = Math.max(left, height[i]);
        }

        int right = 0;
        for (int i = n-1; i > idxOfMax; i--) {
            if (height[i] < right) {
                counter += (right - height[i]);
            }
            right = Math.max(right, height[i]);
        }

        return counter;
    }

    public static int trap(int[] A){
        int a=0;
        int b=A.length-1;
        int max=0;
        int leftmax=0;
        int rightmax=0;
        while(a<=b){
            leftmax=Math.max(leftmax,A[a]);
            rightmax=Math.max(rightmax,A[b]);
            if(leftmax<rightmax){
                max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                a++;
            }
            else{
                max+=(rightmax-A[b]);
                b--;
            }
        }
        return max;
    }
}

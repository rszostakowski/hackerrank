package leetcode.problems.top_interview_150.arrays;

public class Candy
{
    public static void main(String[] args) {
        int[] arr = {1,2,87,87,87,2,1};
        candy(arr);
    }
    public static int candy(int[] ratings) {

        int n = ratings.length;
        if (n == 1) {
            return 0;
        }

        int counter = 0;
        for (int i = 0; i<n; i++) {
            if (i == 0) {
                if (ratings[i] > ratings[i+1]) {
                    counter++;
                }
            } else if (i == n-1) {
                if (ratings[i-1] < ratings[i]) {
                    counter++;
                }
            }
            else {
                if (ratings[i-1] < ratings[i] || ratings[i] > ratings[i+1]) {
                    counter++;
                }
            }
            counter++;
        }
        return counter;
    }
}

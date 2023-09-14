package leetcode.problems.math;

public class CountingBits {

    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            String bin = Integer.toBinaryString(i);
            res[i] = count(bin);
        }

        return res;
    }

    private static int count(String bin) {
        char[] chars = bin.toCharArray();
        int sum = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (chars[i] == '1') {
                sum++;
            }
        }
        return sum;
    }

    // best soltuoin from the comments section
    public int[] countBits_best(int n) {
        int res[] = new int[n + 1]; // create one result array,
        // & our array size is n + 1 because we have to cover 0 as well

        for(int i = 0; i <= n; i++){ // run a loop to store all the values we get from a solve function
            res[i] = solve(i);
        }
        return res;
    }
    public int solve(int n){
        // base condition
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(n % 2 == 0) return solve(n / 2); // handling even case
        else return 1 + solve(n / 2); // handling odd case
    }

    // beatiful nlogn solution:
    /*
        vector<int> countBits(int n) {
        vector<int> ans;

		// iterating fromt 0 to n
        for(int i = 0; i<=n; i++)
        {
			// sum is initialised as 0
            int sum = 0;
            int num = i;
			// while num not equals zero
            while(num != 0)
            {
				// we have to count 1's in binary representation of i, therefore % 2
                sum += num%2;
                num = num/2;
            }
			// add sum to ans vector
            ans.push_back(sum);
        }
		// return
        return ans;
    }
     */
}

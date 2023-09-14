package leetcode.problems.math;

import java.util.*;

public class UglyNumber2 {

    public static void main(String[] args) {
        UglyNumber2 un2 = new UglyNumber2();
        System.out.println(un2.nthUglyNumber_best(12));
    }

    // really ugly solution but works...

    public int nthUglyNumber(int n) {
        if (n==1)
            return 1;
        HashSet<Integer> numberHashSet = new HashSet<>();
        backTracking(numberHashSet);
        ArrayList<Integer> arrayList = new ArrayList(numberHashSet);
        Collections.sort(arrayList);
        return arrayList.get(n-1);
    }

    void backTracking(HashSet<Integer> numberHashSet) {
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                for (int k = 0; k <= 34; k++) {
                    int val = (int) (Math.pow(2, k) * Math.pow(3, j) * Math.pow(5, i));
                    numberHashSet.add(val);
                }
            }
        }
    }

    // best solution from the internet
    // with the best explanation here: https://leetcode.com/problems/ugly-number-ii/solutions/69368/elegant-c-solution-o-n-space-time-with-detailed-explanation/
    public int nthUglyNumber_best(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }


// 2^1*3^0*5^0 = 2
// 2^2*3^0*5^0 = 4
// 2^1*3^1*5^0 = 6
// 2^3*3^0*5^0 = 8
// 2^1*3^0*5^1 = 10
// 2^0*3^1*5^1 = 15
// 2^4*3^0*5^0 = 16















    LinkedHashSet<Integer> uglyNumbers = new LinkedHashSet<>();
    long lastChecked = 0;
    public int nthUglyNumber_notFastEnough(int n) {
        int num = 1;

        while(num <1691) {
            if (isUgly(num)) {
                uglyNumbers.add(num);
            }
            num++;
        }

        int idx = 0;
        Integer next = null;
        Iterator<Integer> iterator = uglyNumbers.iterator();
        while (idx < n ) {
            next = iterator.next();
            idx++;
        }

        return next.intValue();
    }


    public boolean isUgly(int n) {
        boolean isThere = uglyNumbers.contains(n);
        if (lastChecked > n && !isThere) {
            return false;
        } else if (lastChecked > n && isThere) {
            return true;
        }

        if (n > lastChecked) {
            lastChecked = n;
        }

        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 == 0) {
            return isUgly(n/2);
        }

        if (n % 3 == 0) {
            return isUgly(n/3);
        }
        if (n % 5 == 0) {
            return isUgly(n/5);
        }
        return false;
    }
}

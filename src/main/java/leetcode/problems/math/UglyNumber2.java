package leetcode.problems.math;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class UglyNumber2 {

    public static void main(String[] args) {
        UglyNumber2 un2 = new UglyNumber2();
        System.out.println(un2.nthUglyNumber(1352));
    }

    LinkedHashSet<Integer> uglyNumbers = new LinkedHashSet<>();
    long lastChecked = 0;
    public int nthUglyNumber(int n) {
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

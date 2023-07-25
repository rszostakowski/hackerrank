package contents.project_euler;


/*
https://www.hackerrank.com/contests/projecteuler/challenges/euler001/problem?isFullScreen=true
-
 */
public class MultiplesOf3And5 {
    public static void countMultiples(int n) {
        long n3 = (long) Math.floor((n-1)/3);
        long n5 = (long) Math.floor((n-1)/5);
        long n15 = (long) Math.floor((n-1)/15);

        long sum3 = 3 * (n3*(n3+1))/2;
        long sum5 = 5 * (n5*(n5+1))/2;
        long sum15 = 15 * (n15*(n15+1))/2;

        System.out.println(sum3 + sum5 - sum15);
    }
}

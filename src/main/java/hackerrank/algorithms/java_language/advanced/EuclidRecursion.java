package hackerrank.algorithms.java_language.advanced;

public class EuclidRecursion {

    //https://introcs.cs.princeton.edu/java/23recursion/
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
    public static int gcd2(int p, int q) {
        while (q != 0) {
            int temp = q;
            q = p % q;
            p = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = 1440;
        int q = 408;
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}

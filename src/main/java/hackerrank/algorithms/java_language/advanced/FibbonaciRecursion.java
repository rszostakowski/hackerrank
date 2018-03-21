package hackerrank.algorithms.java_language.advanced;

public class FibbonaciRecursion {

    public static int fib(int n) {
        if(n <= 1) {
            System.out.println("Returning n " + n);
            return n;
        } else {
            System.out.println("Returning fib for" + n);
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
    }
}

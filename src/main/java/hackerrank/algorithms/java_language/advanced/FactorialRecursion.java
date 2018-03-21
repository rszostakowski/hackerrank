package hackerrank.algorithms.java_language.advanced;

public class FactorialRecursion {
    public static long factorial(int n) {
        System.out.println("n "+n);
        if (n == 1) {
            System.out.println("returning 1 ");
            return 1;
        }
        long mutiplied = n * factorial(n - 1);
        System.out.println("multiplied "+mutiplied);
        return mutiplied;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}


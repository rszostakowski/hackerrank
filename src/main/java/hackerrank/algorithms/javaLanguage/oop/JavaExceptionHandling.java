package hackerrank.algorithms.javaLanguage.oop;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class JavaExceptionHandling {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String obj1 = in.next();
        String obj2 = in.next();

        int num1 = getInteger(obj1);
        int num2 = getInteger(obj2);

        Optional.of(num2)
                .filter(el -> el != 0)
                .orElseThrow(() -> {
                    System.out.println("java.lang.ArithmeticException: / by zero");
                    return new ArithmeticException("/ by zero");
                });

        System.out.println(num1 / num2);

    }

    private static int getInteger(String obj1) {
        try {
            return Integer.valueOf(obj1);
        } catch (Exception e) {
            System.out.println("java.util.InputMismatchException");
            throw new InputMismatchException();
        }
    }
}

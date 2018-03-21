package hackerrank.algorithms.java_language.oop;

public class JavaInheritanceII {

    class Arithmetic {
        int add(int a, int b) {
            return a + b;
        }
    }

    class Adder extends Arithmetic {
        int add(int a, int b) {
            return super.add(a, b);
        }
    }
}

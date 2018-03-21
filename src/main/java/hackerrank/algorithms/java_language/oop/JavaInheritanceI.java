package hackerrank.algorithms.java_language.oop;

public class JavaInheritanceI {

    class Animal{
        void walk()
        {
            System.out.println("I am walking");
        }
    }

    class Bird extends Animal
    {
        void fly()
        {
            System.out.println("I am flying");
        }

        void sing()
        {
            System.out.println("I am singing");
        }
    }
}

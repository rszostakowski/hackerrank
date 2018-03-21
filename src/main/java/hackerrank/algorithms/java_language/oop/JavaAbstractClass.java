package hackerrank.algorithms.java_language.oop;

public class JavaAbstractClass {

    abstract class Book{
        String title;
        abstract void setTitle(String s);
        String getTitle(){
            return title;
        }
    }

    class MyBook extends Book {
        @Override
        void setTitle(String s) {
            super.title = s;
        }
    }
}

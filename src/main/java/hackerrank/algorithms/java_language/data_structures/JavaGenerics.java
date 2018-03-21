package hackerrank.algorithms.java_language.data_structures;

public class JavaGenerics<T> {

    public void printArray(T[] array) {
        for(T i : array) {
            System.out.println(i);
        }
    }
}

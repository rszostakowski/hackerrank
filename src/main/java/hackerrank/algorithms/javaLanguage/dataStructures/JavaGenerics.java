package hackerrank.algorithms.javaLanguage.dataStructures;

public class JavaGenerics<T> {

    public void printArray(T[] array) {
        for(T i : array) {
            System.out.println(i);
        }
    }
}

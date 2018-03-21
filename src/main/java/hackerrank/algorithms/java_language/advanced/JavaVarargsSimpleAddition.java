package hackerrank.algorithms.java_language.advanced;

public class JavaVarargsSimpleAddition {

    class Add {
        void add(int... values) {
            String sumString = "";
            int sum =  0;
            for (int i = 0; i < values.length-1; i++) {
                sumString += values[i] + "+";
                sum += values[i];
            }
            sumString += values[values.length-1];
            sum += values[values.length-1];
            sumString += "="+sum;
            System.out.println(sumString);
        }
    }

}

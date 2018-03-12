package hackerrank.algorithms.javaLanguage.advanced;

public class JavaVarargsSimpleAddition {

    class Add {
        void add(int... values) {
            String sumString = "";
            int sum =  0;
            for (int i = 1; i < values.length; i++) {
                sumString += i + "+";
                sum +=i;
            }
            sumString += values[values.length-1];
            sum += values[values.length-1];
            sumString += "="+sum;
            System.out.println(sumString);
        }
    }

}

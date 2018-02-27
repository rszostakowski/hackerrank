package hackerrank.algorithms.javaLanguage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class JavaMap {
    public static void main(String[] arg) {
        Map myMap = new HashMap();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            in.nextLine();
            myMap.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.nextLine();
            System.out.println(myMap.containsKey(s) ? s + "=" + myMap.get(s) : "Not found");
        }
    }
}

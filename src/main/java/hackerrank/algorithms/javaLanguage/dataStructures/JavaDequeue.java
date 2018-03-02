package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.*;
public class JavaDequeue {
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         Deque deque = new ArrayDeque<>();
         int n = in.nextInt();
         int m = in.nextInt();

         int maxUnique = 0;
         Set uniquesSet = new HashSet();

         for (int i = 0; i < n; i++) {
             int num = in.nextInt();
             uniquesSet.add(num);
             deque.addLast(num);

             if (deque.size() == m) {
                 maxUnique = uniquesSet.size() > maxUnique ? uniquesSet.size() : maxUnique;
                 int first = (int) deque.pollFirst();
                 if (!deque.contains(first)) {
                     uniquesSet.remove(first);
                 }
             }
         }
         System.out.println(maxUnique);
     }
 }




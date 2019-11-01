package algorithms.implementation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SpecialPalindromAgain {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int counter = 0;
        for (int i=2; i < n; i++) {
            for (int j=0; j < n-i+1; j++) {
                String cutted = s.substring(j,j+i);
                if (isSpecialPalindrom(cutted)){
                    counter++;
                }
            }
        }
        if (isSpecialPalindrom(s)){
            counter++;
        }

        return s.length()+counter;
    }
    static boolean isSpecialPalindrom(String s) {
        if (s.length() % 2 == 1) {  
            String cutted = s.substring(0, s.length()/2) + s.substring(s.length()/2 + 1, s.length());
            return areAllCharactersTheSame(cutted);
        } else {
            return areAllCharactersTheSame(s);
        }
    }
   
    static boolean areAllCharactersTheSame(String s){
         System.out.println("s: " +  s);

         for (int i = 0; i < s.length() -1; i++) {
            int j = i + 1;
             System.out.println("chars: " +  s.charAt(j) + " " +  s.charAt(i));
            if( s.charAt(j) != s.charAt(i)){
                
                System.out.println("false: " +  s.charAt(j) + s.charAt(i));
                return false;
            }
         }
        System.out.println("true");
        return true;
    }
}

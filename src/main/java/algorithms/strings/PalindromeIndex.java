package algorithms.strings;

import java.io.*;

public class PalindromeIndex {
    static int palindromeIndex(String s) {
	if (isPalindrom(s)){
		return -1;
	}

	for (int i = 0; i < s.length(); i++) {
		StringBuilder sb = new StringBuilder(s);
		sb.deleteCharAt(i);
		String sPrime = sb.toString();
		if(isPalindrom(sPrime)){
			return i;	
		}
	}
        
        return -1;
    }

    // private static boolean isPalindrom(String word){
	// return word.equals(new StringBuilder(word).reverse().toString());
    // }
	private static boolean isPalindrom(String word){
            int start = 0;
	    int end = word.length();
		
	    while(start > end) {
		if(word.charAt(start) !=  word.charAt(end)){
			return false;
		}
		start++;    
		end++;
	    }
	    return true;
	}


    public static void main(String[] args) throws IOException {
	    System.out.println(palindromeIndex("aaab"));
	    System.out.println(palindromeIndex("baa"));
	    System.out.println(palindromeIndex("aaa"));
	}
    
}


package section_algorithms.strings;

public class PalindromeIndex {
	static int palindromeIndex(String s){
		for(int i =0,j =s.length()-1; i<j; i++, j--)
			if(s.charAt(i)!=s.charAt(j)) {
				System.out.println("char i: " + s.charAt(i) + " char j: "+ s.charAt(j));
				if(isPalindrome(s, i))
					return i;
				else if(isPalindrome(s, j))
					return j;
			}
		return -1;
        }
    
	static boolean isPalindrome(String s, int index){
		System.out.println("String s: " + s + " index: "+ index);
		for(int i =index+1,j =s.length()-1-index; i<j; i++, j--){
			if(s.charAt(i)!=s.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// System.out.println(PalindromeIndex.palindromeIndex("aaab"));
		// System.out.println(PalindromeIndex.palindromeIndex("baa"));
		// System.out.println(PalindromeIndex.palindromeIndex("aaa"));
		System.out.println(PalindromeIndex.palindromeIndex("abcdefgh"));
		// System.out.println(PalindromeIndex.palindromeIndex("nylsjxeiyadwscfmipfsxjqoovgbalppkdkvcoebojbjlgwvyeomckowqlrfhnoq"));
	}
}


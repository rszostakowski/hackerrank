package leetcode.problems.top_interview_150.trie;

public class DesignAddAndSearchWordsDataStructure {

    public static void main2(String[] args) {
        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        DesignAddAndSearchWordsDataStructure struct = new DesignAddAndSearchWordsDataStructure();
        struct.addWord("bad");
        struct.addWord("dad");
        struct.addWord("mad");
        System.out.println(struct.search("bad"));
        System.out.println(struct.search(".ad"));
        System.out.println(struct.search("b.."));
    }


    //["WordDictionary","addWord","addWord","search","search","search","search","search","search"]
    //,["."],["a"],["aa"],["a"],[".a"],["a."]]
    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure struct = new DesignAddAndSearchWordsDataStructure();
        struct.addWord("a");
        struct.addWord("a");
//        System.out.println(struct.search("."));
//        System.out.println(struct.search("a"));
//        System.out.println(struct.search("aa"));
//        System.out.println(struct.search("a"));
//        System.out.println(struct.search(".a"));
        System.out.println(struct.search("a."));
    }


    TrieNode root;
    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        char[] chars = word.toCharArray();

        for (char ch: chars) {
            int idx = ch-'a';
            if (current.children[idx] == null) {
                current.children[idx] = new TrieNode();
            }
            current = current.children[idx];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return isInDict(root, word);
    }

    private boolean isInDict(TrieNode current, String word) {
        char[] chars = word.toCharArray();
        int n = word.length();

        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (current.children[j] != null && isInDict(current.children[j], word.substring(i + 1, n))) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = ch-'a';
                if (current.children[idx] == null) {
                    return false;
                }
                current = current.children[idx];
            }
        }

        return current.isEndOfWord;
    }
}
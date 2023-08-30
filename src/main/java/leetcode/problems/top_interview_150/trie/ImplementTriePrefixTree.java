package leetcode.problems.top_interview_150.trie;

class ImplementTriePrefixTree {
    private TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int length = word.length();

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++)
        {
            int index = word.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }

        // mark last node as leaf
        pCrawl.isEndOfWord = true;
    }

    public boolean search(String word) {
        int length = word.length();

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++)
        {
            int index = word.charAt(level) - 'a';
            if (pCrawl.children[index] != null)
                pCrawl = pCrawl.children[index];
            else
                return false;
        }

        return pCrawl.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        int length = prefix.length();

        TrieNode pCrawl = root;

        for (int level = 0; level < length; level++)
        {
            int index = prefix.charAt(level) - 'a';
            if (pCrawl.children[index] != null)
                pCrawl = pCrawl.children[index];
            else
                return false;
        }

        return true;
    }
}

class TrieNode {
    static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;
}

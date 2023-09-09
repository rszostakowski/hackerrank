package leetcode.problems.graphs;

import java.util.*;

public class WordLadder {

    public static void main3(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        wordLadder.ladderLength(beginWord, endWord, wordList);
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new LinkedList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("tog");
        wordList.add("cog");
        wordLadder.ladderLength(beginWord, endWord, wordList);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, GraphNode> nodes = new HashMap<>();
        if (!wordList.contains(endWord)) {
            return 0;
        }

        if (!wordList.contains(beginWord))
            wordList.add(beginWord);

        for(String word: wordList) {
            GraphNode node = new GraphNode(word);
            nodes.put(word, node);
        }


        for(String parentWord: wordList) {
            GraphNode parentNode = nodes.get(parentWord);
            for(GraphNode child: nodes.values()) {
                if (areClose(parentNode, child)) {
                    parentNode.children.add(child);
                    //child.children.add(parentNode);
                }
            }
        }

        Queue<GraphNode> st = new LinkedList<>();
        st.add(nodes.get(beginWord));
        int level = 0;

        HashSet<GraphNode> alreadyVisited  = new HashSet<>();
        while (!st.isEmpty()) {
            int size = st.size();
            level++;
            for (int i = 0; i < size; i++) {
                GraphNode node = st.poll();
                alreadyVisited.add(node);
                if (node.word.equals(endWord)) {
                    return level;
                }

                for (GraphNode child : node.children){
                    if (!alreadyVisited.contains(child)){
                        st.add(child);
                    }
                }
            }

            if (level >= wordList.size()) {
                return 0;
            }
        }

        return 0;
    }

    private boolean areClose(GraphNode parent, GraphNode child) {
        if (parent.word.length() == child.word.length()) {
            char[] chars1 = parent.word.toCharArray();
            char[] chars2 = child.word.toCharArray();

            int diff = 0;
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) {
                    diff++;
                    if (diff > 1) {
                        return false;
                    }
                }
            }
            return diff == 1;
        }
        return false;
    }
}


class GraphNode {
    public GraphNode(String word) {
        this.word = word;
    }

    String word;
    List<GraphNode> children = new ArrayList<>();
}
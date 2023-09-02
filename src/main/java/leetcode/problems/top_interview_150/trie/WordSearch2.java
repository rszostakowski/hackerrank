package leetcode.problems.top_interview_150.trie;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class WordSearch2 {
    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> words1 = findWords(board, words);
        System.out.println(words1);
    }

    // TODO not finished. I do not know how to add all words to TRIE
    public static List<String> findWords(char[][] board, String[] words) {

        int startingPointX = 0;
        int startingPointY = 0;
        //addSeq(xCor, yCor, "");

        return new LinkedList<>();
    }



    public static List<String> findWords2(char[][] board, String[] words) {
        int nRows = board.length;
        int nCols = board[0].length;
        ImplementTriePrefixTree trie = new ImplementTriePrefixTree();

        // add all rows
        for (int i = 0; i <nRows; i++) {
            char[] row = board[i];
            String word = new String(row);
            trie.insert(word);
            for (int j = 1; j < nCols; j++) {
                trie.insert(word.substring(j, nCols));
            }
        }

        // add all columns
        for (int col = 0; col < nCols; col++) {
            char[] extractedColumn = new char[nRows];
            for (int row = 0; row < nRows; row++) {
                extractedColumn[row] = board[row][col];
            }
            String word = new String(extractedColumn);
            trie.insert(word);
            for (int j = 1; j < nCols; j++) {
                trie.insert(word.substring(j, nCols));
            }
        }

        return Arrays.stream(words).filter(trie::search).collect(Collectors.toList());
    }
}

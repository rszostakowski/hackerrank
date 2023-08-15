package leetcode.problems.top_interview_150.graph_general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1','1'},
                {'0', '1','0'},
                {'1', '1','1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int c = grid[0].length;

        List<Set<String>> islands = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < c; j++) {
                char el = grid[i][j];
                if (el == '1') {
                     createIslands(islands, i, j, m, c);
                }
            }
        }
        return islands.size();
    }

    private static void createIslands(List<Set<String>> islands, int rowIdx, int colIdx, int maxRowN, int maxColN) {
        int size = islands.size();

        List<String> neighbours = getNeighbours(rowIdx, colIdx, maxRowN, maxColN);
        boolean found = false;
        for (int i = 0; i < size; i++) {
            Set<String> island = islands.get(i);
            for (String neighbour : neighbours) {
                if (island.contains(neighbour)) {
                    island.add("" + rowIdx + colIdx);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            HashSet<String> newSet = new HashSet<String>();
            newSet.add("" + rowIdx + colIdx);
            islands.add(newSet);
        }
    }

    private static List<String> getNeighbours(int rowIdx, int colIdx, int maxRowN, int maxColN) {
        List<String> result = new ArrayList<>();
        if (rowIdx >=1){
            int movedRowIdx = rowIdx -1;
            result.add("" + movedRowIdx + colIdx);
        }

        if (rowIdx+1 <= maxRowN-1) {
            int movedRowIdx = rowIdx +1;
            result.add("" + movedRowIdx + colIdx);
        }
        if (colIdx >=1){
            int movedColIdx = colIdx -1;
            result.add("" + rowIdx + movedColIdx);
        }

        if (colIdx+1 <= maxColN-1) {
            int movedColIdx = colIdx +1;
            result.add("" + rowIdx + movedColIdx);
        }
        return result;
    }

}

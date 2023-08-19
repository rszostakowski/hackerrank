package leetcode.problems.math;

import java.util.LinkedList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList();

        List<Integer> prev = new LinkedList();
        for (int i =0; i <numRows; i++) {
            if (i == 0 ){
                List lst = new LinkedList();
                lst.add(1);
                res.add(lst);
            } else if (i == 1 ){
                List lst = new LinkedList();
                lst.add(1);
                lst.add(1);
                res.add(lst);
                prev = lst;
            } else {
                List lst = new LinkedList();
                lst.add(1);
                for (int j = 0; j < prev.size()-1; j++) {
                    lst.add(prev.get(j)+ prev.get(j+1));
                }
                lst.add(1);
                res.add(lst);
                prev = lst;
            }
        }

        return res;
    }
}

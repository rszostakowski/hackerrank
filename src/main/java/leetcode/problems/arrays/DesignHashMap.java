package leetcode.problems.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DesignHashMap {
    int size = 1000001;
    ArrayList<Integer> map;
    public DesignHashMap() {
        map = new ArrayList(size);

        for (int i = 0; i < size; i++) {
            map.add(i, -1);
        }
    }

    public void put(int key, int value) {
        map.set(key, value);
    }

    public int get(int key) {
        return map.get(key);
    }

    public void remove(int key) {
        map.set(key, -1);
    }
}

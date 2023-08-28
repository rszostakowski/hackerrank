package leetcode.problems.binary_search;

import com.sun.tools.javac.util.Pair;

import java.util.*;

//https://leetcode.com/problems/time-based-key-value-store/description/
public class TimeBasedKeyValueStore {

    public static void main2(String[] args) {
        TimeBasedKeyValueStore kvStore = new TimeBasedKeyValueStore();
        kvStore.set("foo","bar",1);
        //System.out.println(kvStore.get("foo",1));
        //System.out.println(kvStore.get("foo",3));
        kvStore.set("foo","bar2",4);
        System.out.println(kvStore.get("foo",4));
        //System.out.println(kvStore.get("foo",5));
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore kvStore = new TimeBasedKeyValueStore();
        kvStore.set("love","high",10);
        kvStore.set("love","low",20);
        System.out.println(kvStore.get("love",5));
        System.out.println(kvStore.get("love",10));
        System.out.println(kvStore.get("love",15));
        System.out.println(kvStore.get("love",20));
        System.out.println(kvStore.get("love",25));
    }

    HashMap<String, List<Data>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Data> list = map.get(key);
        return search(list, timestamp);
    }


    public String search(List<Data> list, int timestamp) {
        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (list.get(mid).time <= timestamp) {
                start = mid;
            }else {
                end = mid - 1;
            }
        }
        return list.get(start).time <= timestamp
                ? list.get(start).val
                : "";
    }

    // the best solution from the comments section
    public class TimeMap {

        private Map<String,TreeMap<Integer,String>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key)) {
                map.put(key,new TreeMap<>());
            }
            map.get(key).put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer,String> treeMap = map.get(key);
            if(treeMap==null) {
                return "";
            }
            Integer floor = treeMap.floorKey(timestamp);
            if(floor==null) {
                return "";
            }
            return treeMap.get(floor);
        }
    }
}
class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}

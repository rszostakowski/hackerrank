package leetcode.problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    //["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
    //[[],[1],[2],[],[3],[]]
    public static void main(String[] args) {
        FindMedianFromDataStream median = new FindMedianFromDataStream();
        median.addNum(1);
        median.addNum(2);
        System.out.println(median.findMedian());
        median.addNum(3);
        System.out.println(median.findMedian());
    }

    PriorityQueue<Integer> pqL;
    PriorityQueue<Integer> pqR;

    public FindMedianFromDataStream() {
        pqL = new PriorityQueue(Comparator.reverseOrder());
        pqR = new PriorityQueue();
    }

    public void addNum(int num) {
        if (pqL.size() == 0) {
            pqL.add(num);
        } else {
            int leftPeek = pqL.peek();
            if (leftPeek >= num) {
                pqL.add(num);
                if (pqL.size() > pqR.size()) {
                    pqR.add(pqL.poll());
                }
            } else {
                pqR.add(num);
                if (pqR.size() > pqL.size()) {
                    pqL.add(pqR.poll());
                }
            }
        }
    }

    public double findMedian() {
        int leftSize = pqL.size();
        int rightSize = pqR.size();
        if (leftSize > rightSize) {
            return pqL.peek();
        } else if (rightSize > leftSize) {
            return pqR.peek();
        } else  {
            return (double) (pqR.peek() + pqL.peek()) / 2;
        }
    }
}
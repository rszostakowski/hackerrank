package hackerrank.algorithms.java_language.advanced;

public class ListNodeReversal {

    static class ListNode {
        public String data;
        public ListNode next;

        public ListNode(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data='" + data +
                    '}';
        }
    }
    ///https://stackoverflow.com/questions/354875/reversing-a-linked-list-in-java-recursively
    static ListNode reverse(ListNode list)
    {
        if(list == null) return null;
        if(list.next == null) return list;

        ListNode nextEl = list.next;

        list.next = null;

        ListNode reversed = reverse(nextEl); //odwrócamy wszystko co jest od drugiego elementu

        nextEl.next = list;
        return reversed;
    }

    public static void main(String[] args) {
        ListNode el1 =  new ListNode("el1");
        ListNode el2 =  new ListNode("el2");
        ListNode el3 =  new ListNode("el3");
        ListNode el4 =  new ListNode("el4");
        ListNode el5 =  new ListNode("el5");
        ListNode el6 =  new ListNode("el6");
        el1.next = el2;
        el2.next = el3;
        el3.next = el4;
        el4.next = el5;
        el5.next = el6;
        el6.next = null;

        ListNode reversed = reverse(el1);
        do {
            System.out.println(reversed);
            reversed = reversed.next;
        } while(reversed != null);
    }
}

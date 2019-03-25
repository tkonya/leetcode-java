public class LC0023_MergeKSortedLists {

    public static void main(String[] args) {

        LC0023_MergeKSortedLists merge = new LC0023_MergeKSortedLists();
        merge.test();

    }

    public void test() {
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        ListNode result = mergeKLists(lists);
        System.out.println("yes");
    }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode inOrder = null;

        while (true) {
            int lowestIndex = findLowestIndex(lists);
            if (lowestIndex >= 0) {

                PoppedResult poppedResult = new PoppedResult(lists[lowestIndex]);
                if (inOrder == null) {
                    inOrder = poppedResult.popped;
                } else {
                    appendToEnd(inOrder, poppedResult.popped);
                }
                lists[lowestIndex] = poppedResult.remaining;

            } else {
                break;
            }
        }

        return inOrder;
    }

    public static int findLowestIndex(ListNode[] lists) {
        int lowestValue = Integer.MAX_VALUE;
        int lowestIndex = -1;
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) {
                if (lists[i].val <= lowestValue) {
                    lowestValue = lists[i].val;
                    lowestIndex = i;
                }
            }
        }
        return lowestIndex;
    }

    public static ListNode appendToEnd(ListNode host, ListNode child) {
        if (host.next == null) {
            host.next = child;
            return host;
        } else {
            return appendToEnd(host.next, child);
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next) { val = x; this.next = next;}
    }

    public class PoppedResult {
        ListNode popped;
        ListNode remaining;
        PoppedResult(ListNode listNode) {
            this.popped = new ListNode(listNode.val);
            this.remaining = listNode.next;
        }
    }


}

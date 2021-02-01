public class MergeTwoSortedLists {

  /**
   * Merge two sorted linked lists and return it as a sorted list.
   * @see <a href="https://leetcode.com/problems/merge-two-sorted-lists/">Leetcode Link</a>
   * @return the head of the merged list
   */
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    curr.next = l1 == null ? l2: l1;
    return dummy.next;
  }
}

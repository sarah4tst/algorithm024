public class SinglyList {

  public static void main(String[] args) {
    SinglyList test = new SinglyList();
    ListNode head = test.createSinglyList(new int[]{1, 2, 3, 4, 5});
    test.printSinglyList(test.swapNodes(head, 1));
  }

  private ListNode createSinglyList(int[] nums) {
    ListNode dummy = new ListNode();
    ListNode p = dummy;
    for (int n : nums) {
      ListNode node = new ListNode(n, null);
      p.next = node;
      p = p.next;
    }
    return dummy.next;
  }

  private void printSinglyList(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.printf(curr.val + "，");
      curr = curr.next;
    }
  }

  // 1721. Swapping Nodes in a Linked List
  public ListNode swapNodes(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);
    ListNode slow = dummy, fast = dummy;

    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }
    ListNode kth = fast;

    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }

    swapValue(kth, slow);

    return dummy.next;
  }

  private void swapValue(ListNode a, ListNode b) {
    int tmp = a.val;
    a.val = b.val;
    b.val = tmp;
  }

  // 方法二：递归
  public ListNode reverseListRecur(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = reverseListRecur(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }

  // 92. Reverse Linked List II
  public ListNode reverseBetween(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0, head);
    int i = 1;
    ListNode prev = dummy;
    // prev 移动到第left-1结点
    while (i < left) {
      prev = prev.next;
      i++;
    }

    // 记录下反转前的连接点
    ListNode prefix = prev;

    // 反转 right-left 次,最终prev指向反转后的新头结点，curr指向postfix连接点
    ListNode curr = prev.next;
    while (i <= right) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      i++;
    }

    // 连接
    prefix.next.next = curr; // 后部相接：prefix原next结点与postfix连接
    prefix.next = prev; // 前部相接：prefix指向反转后的新头结点

    return dummy.next;
  }

  // 25. Reverse Nodes in k-Group
  // 方法一：递归
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode curr = head;
    int count = 0;

    // Move k steps.
    while (count < k) {
      if (curr == null) {
        return head;
      }
      curr = curr.next;
      count++;
    }

    // Solve the subproblems, save it as prev
    ListNode prev = reverseKGroup(curr, k);
    // Reverse the first k nodes
    // 1.  Move the curr pointer to head, do reverse.
    curr = head;
    while (count > 0) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count++;
    }
    // Return the prev
    return prev;
  }

  // 25. Reverse Nodes in k-Group
  // 方法二：非递归
  public ListNode reverseKGroupIterative(ListNode head, int k) {
    ListNode dummy = new ListNode(0, head);

    // pre 代表待翻转链表的前驱，end 代表待翻转链表的末尾
    ListNode pre = dummy;
    ListNode end = dummy;

    while (end != null) {
      for (int i = 0; i < k && end != null; i++) {
        end = end.next;
      }
      if (end == null) {
        break;
      }

      // 记录现场:下一次开始翻转的头节点，本次要翻转链表的头节点
      ListNode next = end.next, start = pre.next;
      // 断开连接，以使用通用的reverse
      end.next = null;

      // 连接
      pre.next = reverseListInterative(start);
      start.next = next;

      pre = start;
      end = start;

    }
    return dummy.next;
  }

  // 206. 反转链表:
  // 方法一： 循环
  public ListNode reverseListInterative(ListNode head) {
    ListNode prev = null, curr = head, next = null;
    while (curr != null) {
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }

  // 92. Reverse Linked List II: 下标从1开始
  public ListNode reverseBetweenII(ListNode head, int left, int right) {
    ListNode dummy = new ListNode(0, head);
    ListNode pre = dummy; // 待翻转结点前驱

    // 移动到待翻转点前驱
    for (int i = 1; i < left; i++) {
      pre = pre.next;
    }

    // 记录现场
    ListNode prefix = pre, start = pre.next;
    for (int i = left; i <= right; i++) {
      ListNode next = start.next;
      start.next = pre;
      pre = start;
      start = next;
    }

    prefix.next.next = start;
    prefix.next = pre;

    return dummy.next;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return "ListNode{" +
          "val=" + val +
          '}';
    }
  }
}

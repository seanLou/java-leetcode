package cn.louguanyang.code.recursion;

/**
 * 两数相加
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0] 输出：[0] 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内 0 <= Node.val <= 9 题目数据保证列表表示的数字不含前导零
 *
 * @author louguanyang
 * @createAt 2021/3/20 3:09 下午
 */
public class AddTwoNumbers {

  public static void main(String[] args) {

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      if (l2 != null && l2.val >= 10) {
        ListNode next = new ListNode(l2.val / 10);
        l2.val = l2.val - 10;
        l2.next = addTwoNumbers(l2.next, next);
      }
      return l2;
    }
    if (l2 == null) {
      if (l1.val >= 10) {
        ListNode next = new ListNode(l1.val / 10);
        l1.val = l1.val - 10;
        l1.next = addTwoNumbers(l1.next, next);
      }
      return l1;
    }
    int sum = l1.val + l2.val;
    if (sum >= 10) {
      l1.val = sum % 10;
      if (l1.next == null) {
        l1.next = new ListNode((sum / 10));
      } else {
        l1.next.val = l1.next.val + (sum / 10);
      }
    } else {
      l1.val = sum;
    }
    l1.next = addTwoNumbers(l1.next, l2.next);
    return l1;
  }

  public static class ListNode {

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
  }
}

package com.pinfall.exam;

class ListNode {
    int value;
    ListNode next;

    ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class DetectLinkedListCycle {
    public ListNode detectCycle(ListNode head) {
        // 初始化快慢指针，都从链表头开始
        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针遍历链表，快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果快慢指针相遇，说明链表存在环
            if (slow == fast) {
                break;
            }
        }

        // 如果快指针或者快指针的下一个节点为空，说明链表不存在环
        if (fast == null || fast.next == null) {
            return null;
        }

        // 将慢指针重新指向链表头
        slow = head;
        // 快慢指针以相同速度前进，再次相遇的节点即为环的起始节点
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // 创建链表节点
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // 构建链表关系
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 形成环

        DetectLinkedListCycle solution = new DetectLinkedListCycle();
        ListNode cycleStart = solution.detectCycle(node1);
        if (cycleStart != null) {
            System.out.println(cycleStart.value);
        } else {
            System.out.println("None");
        }
    }
}    

package com.toy.data.structure.link.math;

import com.toy.data.structure.link.SingleSortLink;

public class TestSingleLink {

    public static void main(String[] args){
        SingleSortLink<Integer> node1 = new SingleSortLink(1);
        SingleSortLink<Integer> node2 = new SingleSortLink<Integer>(2);
        SingleSortLink<Integer> node3 = new SingleSortLink<Integer>(3);
        SingleSortLink<Integer> node4 = new SingleSortLink<Integer>(4);
        SingleSortLink<Integer> node5 = new SingleSortLink<Integer>(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        TestSingleLink main = new TestSingleLink();

        SingleSortLink<Integer> head = null;
        head = main.reverse(node1);
        while (head != null ){
            System.out.println(head.value);
            head = head.next;
        }
    }




    /**
     * 将单链表进行逆置(通过遍历的方式)
     * @param head
     * @return
     */
    public SingleSortLink<Integer> reverse(SingleSortLink<Integer> head){
        if(head == null || head.next == null){
            return head;
        }

        SingleSortLink cur = head;
        SingleSortLink pre = null;
        while(cur !=null){
            SingleSortLink<Integer> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    // 递归能不能解决这个问题
}

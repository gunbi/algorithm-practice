package com.pioneertao.algorithm;

class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode reverseKLink(ListNode head,int k){
        ListNode pre=null,cur=head,next=null;

        ListNode pnext=null,global_head=null;
        int i=0;
        ListNode tmp=null;

        while(cur!=null){
            next = cur.next;

            if(tmp==null) tmp=cur;   //tmp记录当前组反转完最后一个节点
            if(pnext!=null) pnext.next = cur;  //pnext是上一组反转完最后一个节点

            cur.next = pre;
            pre=cur;
            cur = next;

            i++;
            if(i>=k){  //当前组反转完成的时候
                if(global_head==null){
                    global_head=pre;
                }
                if(pnext!=null){  //将上一组反转完的最后一个节点指向 当前组反转完后的第一个节点
                    pnext.next = pre;
                }
                pnext=tmp; //迭代

                i=0;  //新的一组反转时 关键数据初始化
                tmp=null;
                pre=null;
            }
        }
        return global_head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        int k = 3;
        ListNode result = reverseKLink(head, k);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}


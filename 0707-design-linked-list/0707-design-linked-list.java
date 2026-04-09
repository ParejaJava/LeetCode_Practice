class MyLinkedList {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    private int size;

    private ListNode head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode curr = head;
        while (index + 1 > 0) {
            curr = curr.next;
            index--;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        ListNode newnode = new ListNode(val);
        newnode.next = head.next;
        head.next = newnode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newnode = new ListNode(val);
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newnode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        else if (index == 0) {
            addAtHead(val);
        }
        else if (index == size) {
            addAtTail(val);
        }
        else {
            ListNode newnode = new ListNode(val);
            ListNode curr = head;
            while (index > 0) {
                curr = curr.next;
                index--;
            }
            newnode.next = curr.next;
            curr.next = newnode;
            size++;
        }
    }
    
    public void deleteAtIndex(int index) {
        ListNode curr = head;
        while (index > 0) {
            curr = curr.next;
            index--;
        }
        curr.next = curr.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
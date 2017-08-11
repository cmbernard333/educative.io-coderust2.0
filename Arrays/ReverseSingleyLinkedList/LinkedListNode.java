class LinkedListNode<E> {

    private LinkedListNode<E> next;
    private E data;

    public LinkedListNode(E data)
    {
        this(data, null);
    }

    public LinkedListNode(E data, LinkedListNode<E> next)
    {
        this.data = data;
        this.next = next;
    }

    public void setNext(LinkedListNode<E> next)
    {
        this.next = next;
    }

    public LinkedListNode<E> getNext()
    {
        return this.next;
    }

    public E getData()
    {
        return this.data;
    }

    /* 
        traverse the linked list and point the pointer in the other direction 
        0->1->2->3->4->5->null

        null<-0<-1<-2<-3<-4<-5
    */
    public static <E> LinkedListNode<E> reverse(LinkedListNode<E> head) {
        LinkedListNode<E> cur = head;
        LinkedListNode<E> prev = head;
        while(cur.getNext()!=null)
        {
            prev = cur;
            cur = cur.getNext(); // grab the next pointer first
            cur.setNext(prev); // set next pointer to previous pointer
        }
        return cur;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinkedListNode<E> cur = this;
        while(cur != null) {
            builder.append(cur.getData().toString() + ((cur.getNext() != null) ? "->" : ""));
            cur = cur.getNext();
        }
        return builder.toString();
    }

    public static void main(String [] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> tmp = head;
        for(int i = 1;i < 6;i++) {
            tmp.setNext(new LinkedListNode<Integer>(i));
            tmp = tmp.getNext();
        }
        // reverse a linked list
        System.out.println(head);
        LinkedListNode.reverse(head);
        System.out.println(head);
    }
}
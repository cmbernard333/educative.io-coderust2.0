class LinkedListNode<E> {

    public static boolean DEBUG_MODE = false;

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
        LinkedListNode<E> cur = head, prev = null, next = head;
        /* prev starts at head */
        while((next = cur.getNext()) != null)
        {
            System.out.println("Node: data("+cur.getData()+"), next->"+cur.getNext().getData());
            /*
            prev = cur;
            cur = cur.getNext(); // grab the next pointer
            next = cur.getNext(); // grab the next-next pointer
            cur.setNext(prev); // set next pointer to previous pointer
            cur = next;
            */
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        cur.setNext(prev);
        System.out.println("Reverse finished");
        return cur;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        LinkedListNode<E> cur = this;
        if(DEBUG_MODE)
        {
            System.out.println("Printing list");
        }
        while(cur != null) {
            if(DEBUG_MODE)
            {
                System.out.println(cur.getData().toString() + ((cur.getNext() != null) ? "->" : ""));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) { /* don't care */}
            }
            builder.append(cur.getData().toString() + ((cur.getNext() != null) ? "->" : ""));
            cur = cur.getNext();
        }
        return builder.toString();
    }

    public static void main(String [] args) {
        LinkedListNode<Integer> head = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> tmp = head;
        LinkedListNode.DEBUG_MODE = false;
        if(System.getProperty("Debug") != null)
        {
            LinkedListNode.DEBUG_MODE = System.getProperty("Debug").equalsIgnoreCase("true");
        }
        for(int i = 1;i < 6;i++) {
            tmp.setNext(new LinkedListNode<Integer>(i));
            tmp = tmp.getNext();
        }
        // reverse a linked list
        System.out.println(head);
        head = LinkedListNode.reverse(head);
        System.out.println(head);
    }
}
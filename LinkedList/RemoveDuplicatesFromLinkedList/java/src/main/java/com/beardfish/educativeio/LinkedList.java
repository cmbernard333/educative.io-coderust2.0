package com.beardfish.educativeio;

public class LinkedListNode<E> 
{
    public LinkedListNode (E ele)
    {
        this.data = ele;
        this.next = null;
    }

    public void setNext(LinkedListNode next)
    {
        this.next = next;
    }

    public LinkedListNode getNext()
    {
        return this.next;
    }

    public E getData() 
    {
        return data;
    }

    public void setData(E ele)
    {
        if(ele == null)
        {
            throw new NullPointerException();
        }
        this.data = ele;
    }

    private LinkedListNode next;
    private E data;
}

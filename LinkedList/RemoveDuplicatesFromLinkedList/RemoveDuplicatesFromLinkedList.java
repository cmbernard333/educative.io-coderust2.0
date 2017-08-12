import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

class RemoveDuplicatesFromLinkedList {

    public static <E> void printList(List<E> lst)
    {
        System.out.println("--list--");
        for(E ele : lst)
        {
            System.out.println(ele);
        }
        System.out.println("--list--");
    }

    public static void main(String [] args)
    {
        Set<Integer> duplicateCheck = new HashSet<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        for(int i = 0; i <= 10; i++)
        {
            linkedList.add(i);
            /* add all the evens twice */
            if(i%2==0)
            {
                linkedList.add(i);
            }
        }
        RemoveDuplicatesFromLinkedList.printList(linkedList);
        /* check for duplicates */
        for(Iterator<Integer> it = linkedList.iterator(); it.hasNext(); )
        {
            Integer i = it.next();
            if(duplicateCheck.contains(i))
            {
                it.remove();
            } else {
                duplicateCheck.add(i);
            }
        } 
        RemoveDuplicatesFromLinkedList.printList(linkedList);
    }
}

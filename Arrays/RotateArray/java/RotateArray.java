import java.util.Arrays;

/*
 * Given an array of integers, rotate the array by N elements. Here, N is an integer.
 * Examples:
 * 1, 10, 20, 0, 59, 86, 32, 11, 9, 40
 * -1 rotations = 
 * 10, 20, 0 , 59, 86, 32, 11, 9, 40, 1
 * +2 rotations =
 * 9, 40, 1, 10, 20, 0, 59, 86, 32, 11 
 */
public class RotateArray {
    public static <T> void swap(T [] arr, int x, int y)
    {
        T tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public <T> void reverse(T [] arr, int start, int end)
    {
        System.out.println("--- Reverse arr="+Arrays.toString(arr)+" from "+start+" to "+end+" ----");
        int size = end; // you don't use absolute size because we are counting from the back
        for(int i = end; i > ((size)/2); i--)
        {
            // System.out.println(String.format("Swapping arr[%d]=%d, arr[%d]=[%d]",i, arr[i], (size-i), arr[size-i]));
            swap(arr, i, ((end)-i)+start); // have to add start in case start isn't 0 - we don't want negative indices
        }
        System.out.println("--- Reverse ----");
    }

    public <T> void rotateArray(T [] arr, int rotate)
    {
        this.reverse(arr,0,arr.length-1); // reverse the whole thing
        System.out.println(Arrays.toString(arr));
        this.reverse(arr,0,rotate-1); // reverse the elements included in the rotation
        System.out.println(Arrays.toString(arr));
        this.reverse(arr,rotate,arr.length-1); // reverse the upper half back to original order
        return;
    }

    public static void main(String [] args)
    {
        /* this has to be the Integer wrapper type because you can't convert from primitives to objects */
        Integer hello[] = {1,10,20,0,59,86,32,11,9,40};
        RotateArray r = new RotateArray();
        System.out.println(Arrays.toString(hello));
        // r.reverse(hello,0,hello.length-1);
        r.rotateArray(hello, 2);
        System.out.println(Arrays.toString(hello));
        
    }
}

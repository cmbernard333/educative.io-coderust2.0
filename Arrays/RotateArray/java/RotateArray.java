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
        int size = end - start;
        for(int i = end; i > ((size)/2); i--)
        {
            swap(arr,i, (size)-i);
        }
    }

    public <T> void rotateArray(T [] arr, int rotate)
    {
        this.reverse(arr,0,arr.length-1);
        this.reverse(arr,0,rotate-1);
        this.reverse(arr,rotate,arr.length-1);
        return;
    }

    public static void main(String [] args)
    {
        /* this has to be the Integer wrapper type because you can't convert from primitives to objects */
        Integer hello[] = {1,10,20,0,59,86,32,11,9,40};
        Integer trivial[] = {1,2,3};
        RotateArray r = new RotateArray();
        System.out.println(Arrays.toString(hello));
        r.reverse(hello,0,hello.length-1);
        r.reverse(trivial,0,trivial.length-1);
        System.out.println(Arrays.toString(hello));
        System.out.println(Arrays.toString(trivial));
        r.rotateArray(hello, 2);
    }
}

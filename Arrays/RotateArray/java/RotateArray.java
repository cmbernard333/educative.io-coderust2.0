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
        for(int i = end; i > ((end)/2); i--)
        {
            if(i > ((end-i)+start)) // this fixes the issue of swapping the middle twice
            {
                swap(arr, i, (end-i)+start); // calculate for negative indices
            }
        }
    }

    public <T> void rotateArray(T [] arr, int rotate)
    {
        rotate = rotate % arr.length;
        if(rotate<0)
        {
            rotate = rotate + arr.length;
        }
        this.reverse(arr,0,arr.length-1); // reverse the whole thing
        this.reverse(arr,0,rotate-1); // reverse the elements included in the rotation
        this.reverse(arr,rotate,arr.length-1); // reverse the upper half back to original order
    }

    public static void main(String [] args)
    {
        /* this has to be the Integer wrapper type because you can't convert from primitives to objects */
        Integer hello[] = {1,10,20,0,59,86,32,11,9,40};
        Integer trivial[] = {1,2,3};
        RotateArray r = new RotateArray();
        // positive rotation
        System.out.println(Arrays.toString(hello));
        r.rotateArray(hello, 2);
        System.out.println(Arrays.toString(hello));
        // negative rotation
        System.out.println(Arrays.toString(trivial));   
        r.rotateArray(trivial, -1);
        System.out.println(Arrays.toString(trivial));
        
    }
}

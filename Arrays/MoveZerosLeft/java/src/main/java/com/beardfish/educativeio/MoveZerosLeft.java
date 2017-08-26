package com.beardfish.educativeio;

/*
 Description

 Given an integer array, move all elements containing '0' to the left while maintaining the order of other elements in the array. Let's look at the following integer array.
 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 
 1  10  20   0   59  63  0   88  0

 After moving all zero elements to the left, the array should look like this. We need to maintain the order of non-zero elements.

  
 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 
 0   0   0   1   10  20  59  63  88

Hints:
    -Counting
    -Reader/Writer


Runtime complexity : O(n)
Memory complexity: O(1)

*/

import java.util.Arrays;

public class MoveZerosLeft {

    public static void swap(int [] arr, int x, int y)
    {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void moveZerosLeft(int [] arr)
    {
        /* writer will always be a place where a zero hasn't been written yet */
        int writer = arr.length - 1;
        for(int i = arr.length - 1 ; i >= 0 ; i--)
        {
            if ( arr [i] != 0 )
            {
                swap(arr, i, writer);
                writer--;
            }
        }
    }

    public static void printMoveZerosLeft(int [] arr)
    {
        System.out.println("arr@start:"+ Arrays.toString(arr));
        MoveZerosLeft.moveZerosLeft(arr);
        System.out.println("arr@end:"+Arrays.toString(arr));
        System.out.println();
    }

    public static void main(String [] args)
    {
        int [] arr = {1, 10, 20, 0, 59, 63, 0, 88, 0};
        int [] arrTwo = { 0, 8, 9, 22, 0, 99, 200};
        int [] pair = {1,0};

        printMoveZerosLeft(arr);
        printMoveZerosLeft(arrTwo);
        printMoveZerosLeft(pair);
    }
}

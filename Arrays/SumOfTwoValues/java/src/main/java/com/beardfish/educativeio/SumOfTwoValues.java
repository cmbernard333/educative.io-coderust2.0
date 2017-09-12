package com.beardfish.educativeio;
/* Sum of Two Values
-----
Given an array of integers and a value, determine if there are any two integers in the array which sum equal to the given value.
-----

Description:

Given an array of integers and a value, determine if there are any two integers in the array which sum equal to the given value.

Consider this array and target sums.

{5, 7, 1, 2, 8, 4, 3 }
Target Sum | 10 | 7 + 3 = 10, 2 + 8 = 10 | 
Target Sum | 19 | No 2 values sum up to 19 |

Hints
    -Hashable
    -Sort array

Example array sorted:
{1, 2, 3, 4, 5, 7, 8 }

*/

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class SumOfTwoValues {


	public boolean sumOfTwoValues(int [] arr, int target) {
        /* sorting puts the biggest value last */
        Arrays.sort(arr);
        /* keep in mind - have to use only two values */
        /* i = left, j = right */
        for(int i = 0, j = arr.length-1; i<j; ) 
        {
            System.out.println(String.format("i:%d, arr[i]=%d, j:%d, arr[j]=%d",i,j,arr[i],arr[j]));
            /* check for target */
            if ( (arr[i] + arr[j]) == target )
            {
                return true;
            } 

            /* shift the smaller number if we undershoot */
            if ( (arr[i] + arr[j] ) < target )
            {
                i++;
            }

            /* larger values will always be at the end */
            if ( (target - arr[j]) <= 0 ) {
                j--;
            } 
        }
        return false; 
	}

	public static void main(String [] args) {
		SumOfTwoValues stv = new SumOfTwoValues();
		int [] arr = {5,7,1,2,8,4,3};
        System.out.println(Arrays.toString(arr));
        /* happy path */
		System.out.println(String.format("Target sum | %d | %s",10, Boolean.toString(stv.sumOfTwoValues(arr, 10))));
        /* failure path */
		System.out.println(String.format("Target sum | %d | %s",19, Boolean.toString(stv.sumOfTwoValues(arr, 19))));
        /* edge cases */
        System.out.println(String.format("Target sum | %d | %s",3, Boolean.toString(stv.sumOfTwoValues(arr, 3))));
        System.out.println(String.format("Target sum | %d | %s",15, Boolean.toString(stv.sumOfTwoValues(arr,15))));
        System.out.println(String.format("Target sum | %d | %s",9, Boolean.toString(stv.sumOfTwoValues(arr,9))));
	}

}

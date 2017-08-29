package com.beardfish.educativeio;
/* 
 Description

 Given an array (list) of intervals as input where each interval has a start and end timestamps. Input array is sorted by starting timestamps. You are required to merge overlapping intervals and return output array (list).

 Consider below input array. Intervals (1, 5), (3, 7), (4, 6), (6, 8) are overlapping so should be merged to one big interval (1, 8). Similarly intervals (10, 12) and (11, 15) are also overlapping intervals and should be merged to (10, 15).
 
 Hints
 -Linear Scan
 -Intervals are sorted by starting timestamps

     Runtime Complexity: Linear, O(n)
     Memory Complexity: Constant O(1)
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeOverlappingIntervals {

    public static List<Pair<Integer,Integer>> createIntervalList(Pair<Integer,Integer>... pairs)
    {
        return Arrays.asList(pairs);
    }

    /* returns -1,-1 if they don't overlap */
    private static Pair<Integer,Integer> getMergedInterval(Pair<Integer,Integer> left, Pair<Integer,Integer> right)
    {
        int start = -1;
        int end = -1;
        Pair<Integer,Integer> mergedInterval = null;
        /* example 1,5 & 3,7 - overlap */
        /* example 1,7 & 4,6 - overlap */
        /* example 1,7 & 8,10 - do not overlap */ 

        if (left.getLeft() < right.getRight() &&
                left.getRight() >= right.getLeft())
        {
            start = Math.min(left.getLeft(), right.getLeft());
            end = Math.max(left.getRight(), right.getRight());
        }

        if ( start == -1 || end == -1)
        {
           mergedInterval = new Pair<>(-1,-1); 
        } else {
            mergedInterval = new Pair<>(start,end);
        }
        return mergedInterval;
    }

    public static List<Pair<Integer,Integer>> mergeOverlappingIntervals(List<Pair<Integer,Integer>> intervals)
    {
        List<Pair<Integer,Integer>> mergedIntervals = new ArrayList<>();
        Pair<Integer,Integer> curInterval = intervals.get(0), mergeInterval = null;
        /* iterate until you find an interval that doesn't merge with the current one */
        for(int i = 1; i < intervals.size(); i++)
        {
            /* check for overlapping intervals */
            mergeInterval = MergeOverlappingIntervals.getMergedInterval(curInterval, intervals.get(i));
            if ( mergeInterval.getLeft() == -1 || mergeInterval.getRight() == -1) {
                mergedIntervals.add(curInterval);
                curInterval = intervals.get(i);
            } else {
                curInterval = mergeInterval;
            }
            /* TODO : edge case is end of list or beginning of list or list of one value */
        }

        /* may have accumulated an interval - need to add it if it legit */
        System.out.println("End mergeInterval"+mergeInterval);
        mergedIntervals.add(curInterval);

        return mergedIntervals;
    }

    public static void main(String [] args)
    {
        List<Pair<Integer,Integer>> intervals = MergeOverlappingIntervals.createIntervalList(
            new Pair<Integer,Integer>(1,5),
            new Pair<Integer,Integer>(3,7),
            new Pair<Integer,Integer>(4,6),
            new Pair<Integer,Integer>(6,8));
        List<Pair<Integer,Integer>> intervalsTwo = MergeOverlappingIntervals.createIntervalList(
            new Pair<Integer,Integer>(10,15),
            new Pair<Integer,Integer>(11,15));
        List<Pair<Integer,Integer>> intervalsThree = MergeOverlappingIntervals.createIntervalList(
            new Pair<Integer,Integer>(1,7),
            new Pair<Integer,Integer>(8,10),
            new Pair<Integer,Integer>(11,13));

        List<Pair<Integer,Integer>> mergedIntervals = MergeOverlappingIntervals.mergeOverlappingIntervals(intervals);
        List<Pair<Integer,Integer>> mergedIntervalsTwo = MergeOverlappingIntervals.mergeOverlappingIntervals(intervalsTwo);
        List<Pair<Integer,Integer>> mergedIntervalsThree = MergeOverlappingIntervals.mergeOverlappingIntervals(intervalsThree);

        /* intervalsOne */
        System.out.println("Intervals: "+ Arrays.toString(intervals.toArray()));
        System.out.println("Merged Intervals: "+Arrays.toString(mergedIntervals.toArray()));
        /* intervalsTwo */
        System.out.println("Intervals: "+ Arrays.toString(intervalsTwo.toArray()));
        System.out.println("Merged Intervals: "+Arrays.toString(mergedIntervalsTwo.toArray()));
        /* intervalsThree - TODO: broken*/
         System.out.println("Intervals: "+ Arrays.toString(intervalsThree.toArray()));
        System.out.println("Merged Intervals: "+Arrays.toString(mergedIntervalsThree.toArray()));
        
    } 
}

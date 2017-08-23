package com.beardfish.educativeio;

import java.util.List;
import java.util.Comparator;
import java.util.Arrays;

public class FindHighLowIndex {

    public static <E> int binarySearch(List<E> lst, int low, int high, E key, Comparator<E> comprar)
    {
        while( low <= high )
        {
            int mid = low + (high - low)/2;
            E midVal = lst.get(mid);

            if ( comprar.compare( key, midVal ) == 0 ) {
                return mid;
            }

            if ( comprar.compare( key, midVal ) <= 0 ) {
                high = mid - 1;
            } else if ( comprar.compare( key, midVal ) > 0 ) {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static <E> Pair<Integer, Integer> findHighLowIndex(List<E> lst, int low, int high, E key, Comparator<E> comprar)
    {
        int midFind = -1;
        int highFind = -1;
        int lowFind = -1;
        int tmp = -1;

        midFind = FindHighLowIndex.binarySearch(lst,low,high,key,comprar);
        lowFind = midFind;
        highFind = midFind;
        tmp = midFind;

        if(midFind != -1) {

            // search top half
            while( -1 != (midFind = FindHighLowIndex.binarySearch(lst,midFind+1,high,key,comprar)))
            {
                highFind = midFind;
            }

            // search bottom half
            midFind = tmp;
            while ( -1 != (midFind = FindHighLowIndex.binarySearch(lst,low,midFind-1,key,comprar)))
            {
                lowFind = midFind;
            }
        }

        return new Pair<Integer,Integer>(lowFind,highFind);
    }

    public static void main (String [] args) {
        List<Integer> someIntegers = Arrays.asList(1,2,3,5,10,27,82,100);
        List<Integer> someMoreIntegers = Arrays.asList(1,2,5,5,5,5,5,5,5,5,20);
        IntegerComparator intComparator = new IntegerComparator();
        Pair<Integer,Integer> lowHigh = null;
        Timer timer = new Timer();

        /* java 8 streams approach + lambdas for printing a list - handy */
        someIntegers.stream().forEach((k)->System.out.print(k + " "));
        System.out.println();
        someMoreIntegers.stream().forEach((k)->System.out.print(k + " "));
        System.out.println();

        for(Integer val : someIntegers) {
            int found = FindHighLowIndex.binarySearch(someIntegers,0,someIntegers.size()-1, val, intComparator);
            System.out.println(String.format("Found %d at index %d",val,found));
        }

        timer.start();
        for(Integer val : Arrays.asList(1,2,5,6,7,8,10,20))
        {
            lowHigh = FindHighLowIndex.findHighLowIndex(someMoreIntegers,0,someMoreIntegers.size()-1,val,intComparator);
            System.out.println(String.format("Found %d at low (%d) and high (%d)", val, lowHigh.getLeft(), lowHigh.getRight()));
        }
        timer.end();

        System.out.println(String.format("Executed in %f seconds",timer.elapsedSeconds()));
        
    }

}

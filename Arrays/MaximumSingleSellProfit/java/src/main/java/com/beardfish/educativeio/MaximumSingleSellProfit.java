package com.beardfish.educativeio;

/*
Find maximum single sell profit

Given a list of stock prices for n days, find the maximum profit with a single buy/sell activity.
Description

Given a list of day stock prices (integers for simplicity), find the maximum single sell profit.

We need to maximize the single buy/sell profit and in case we can't make any profit, we'll try to minimize the loss. For below examples, buy and sell prices for making maximum profit are highlighted.

8 [5] 12 9 [19] 1 --> buy 5 and sell 19

21 [12] [11] 9 6 3 --> buy 12 and sell 11

The values in the array represent the cost of a stock on each day. 

As we can only buy and sell the stock only once, we need to find the best buy and sell prices for which our profit is maximized (or loss is minimized) over a given span of time.

Summary:

Buy low, sell high = sale price - buy price = maximum profit

Hints
    Kadane's algorithm.

Runtime Complexity : Linear, O(n).
Memory Complexity : Constant, O(1).

*/

import java.util.Arrays;

public class MaximumSingleSellProfit
{
    // public static int maxSingleSellProfit(int [] arr)
    public static Pair<Integer,Integer> maxSingleSellProfit(int [] arr)
    {
        /* 
         * single buy/sell activity 
         * profit = sell_price - buy_price
         * buy should be lower than sell
         * switch buy as soon as we find a smaller one
         * */
        int cur_profit = 0, max_profit = 0;
        int buy = 0, sell = 1;
        /* you have to buy before you can sell - i.e. you can't buy at 1 and sell at 19 because it already passed */
        int i = 0, j = 1;
        /* set the initial profit - we need this to for negative profit */
        cur_profit = arr[j] - arr[i];
        while( j < arr.length ) {
            if ( arr[j] - arr[i] > cur_profit )
            {
                cur_profit = arr[j] - arr[i];
                buy = i;
                sell = j;
            }
            /* move buy if sell is less */
            if ( arr[j] < arr[i] )
            {
                i++;
            }
            j++;
        }
        System.out.println(String.format("Estimated sale prices %s",Arrays.toString(arr)));
        System.out.println(String.format("Buy={%d}, Sell={%d}. Max profit={%d}",arr[buy],arr[sell],cur_profit));
        return new Pair<Integer,Integer>(buy,sell);
        // return cur_profit;
    }

    public static void main (String [] args)
    {
        int [] exampleStocksOne = { 8, 5, 13, 9, 19, 1 };
        int [] exampleStocksTwo = { 8, 5, 13, 9, 19, 20 };
        int [] exampleStocksThree = { 2, 5, 13, 9, 19, 20 };
        int [] exampleStocksFour = { 21, 12, 11, 9, 6, 3 };
        MaximumSingleSellProfit.maxSingleSellProfit(exampleStocksOne);
        MaximumSingleSellProfit.maxSingleSellProfit(exampleStocksTwo);
        MaximumSingleSellProfit.maxSingleSellProfit(exampleStocksThree);
        MaximumSingleSellProfit.maxSingleSellProfit(exampleStocksFour);
    }
}

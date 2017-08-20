using System;
using System.Collections;
using System.Collections.Generic;

namespace FindHighLowIndex
{
    public class BinarySearch<T>
    {
        int Search(List<T> list, int size, int low, int high, T key)
        {
            while (low < high)
            {
                int mid = low + (high - low) / 2;

                if (list[mid] == key)
                {
                    return mid;
                }

                if (key >= list[mid])
                {
                    low = mid + 1;
                }
                else if (key < list[mid])
                {
                    high = mid - 1;
                }
            }

            return -1;

        }
    }
}

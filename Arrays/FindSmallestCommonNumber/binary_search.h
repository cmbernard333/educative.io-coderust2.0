#pragma once
#include "binary_search.h"
#include <vector>

template<typename T> 
int binary_search(std::vector<T>& arr, T ele, int low, int high)
{
    if (low > high)
    {
        return -1;
    }

    int mid = low + (high - low)/2;

    if (ele == arr[mid]) 
    {
        return mid;
    }
    else if ( ele < arr[mid])
    {
        return binary_search(arr,ele,low,mid-1);
    }
    else if ( ele > arr[mid])
    {
        return binary_search(arr,ele,mid+1,high);
    }
    return -1;
}

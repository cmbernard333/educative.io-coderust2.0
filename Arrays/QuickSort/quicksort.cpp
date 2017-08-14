#include <iostream>
#include <utility>
#include <cstdlib>
#include "stack.hpp"

typedef unsigned int uint32;
#define ARR_SIZE(x) (sizeof(x)/sizeof(x[0]))

template<typename T>
void print_arr(T* arr, std::size_t size)
{
    std::cout<<"{";
    for(int i = 0;i<size;i++)
    {
        std::cout<< arr[i] << ((i!=size-1) ? "," : "}");  
    }
    std::cout<<std::endl;
}

class SortAscending  
{
    public:
    /* compareTo
     * if x comes before y : return < 0
     * if x equals y : return 0
     * if x comes after y : return > 0 
     */
    int operator() (int x, int y) const {
        return x - y; 
    }
};

/* template function for comparison - c++11 aliases */
template<typename T>
using ComprarFunc = int(*)(const T& x, const T& y);

static int sort_descending_int(const int& x, const int& y)
{
    return y - x;
}

template<typename T>
void swap(T* x, T* y)
{
    T tmp = *x;
    *x = *y;
    *y = tmp;
}

template<typename T, class Comparator>
int partition(T* arr, uint32 start, uint32 end, Comparator comprar)
{
    int pivot = arr[start];
    int i = start;
    int j = end;

    /* iterate while start is less than end */
    /* essentially start from the ends and move in */
    while(i < j) 
    {
        /* while we don't pass the upper one and the value we are at shouldn't pass the pivot */
        // while(i <= end && arr[i] <= pivot) i++;
        while(i <= end && comprar(arr[i],pivot) <= 0) i++;
        /* while we are greater than the pivot move left */
        // while(arr[j] > pivot) j--;
        while(comprar(arr[j],pivot) > 0) j--;

        /* if we should swap these lets do it */
        if(i < j)
        {
            swap(&arr[i],&arr[j]);
        }
        else
        {
            break;
        }
    }
    
    arr[start] = arr[j];
    arr[j] = pivot;

    return j;
}

template<typename T, class Comparator>
void quicksort(T* arr, uint32 start, uint32 end, Comparator comprar)
{
    if(start < end)
    {
        int p = partition(arr, start, end, comprar);
        quicksort(arr, start, p, comprar);
        quicksort(arr, p + 1, end, comprar);
    }
} 

int main(int argc, char** argv)
{
    int arr[10] = {-10,27,3,5,1,22,63,14,100,90};
    ComprarFunc<int> f = sort_descending_int;
    print_arr(arr,10);
    // quicksort(arr,0,ARR_SIZE(arr)-1,SortAscending());
    quicksort(arr,0,ARR_SIZE(arr)-1,SortAscending());
    print_arr(arr,10);
    return 0;
}

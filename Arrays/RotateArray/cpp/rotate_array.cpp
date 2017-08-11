#include <iostream>
#include <cstdlib>
template<typename T>
void swap(T* x, T* y)
{
    T tmp = *x;
    *x = *y;
    *y = tmp;
}
/*
 * Rotate the given array with the size by the given rotate value
 * @param arr - the input array
 * @param size - the size of the array
 * @param rotate - the amount of times to rotate a number
 * @return none
 */
template<typename T>
void reverse(T* arr, std::size_t size, int start, int end)
{
    /* size = 3; stop at 1 */
    /* size = 4; stop at 2 */
    T* pstart = &arr[start];
    T* pend = &arr[end];
    while(pstart < pend)
    {
        swap(pstart,pend);
        pstart++;
        pend--;
    }
}

template<typename T>
void rotate_array(T* arr, std::size_t size, int rotate)
{
    rotate = rotate % size;
    if(rotate < 0)
    {
        rotate = rotate + size;
    }
    reverse(arr, size, 0, size-1);
    reverse(arr, size, 0, rotate-1);
    reverse(arr, size, rotate,size-1);
    return;
}

template<typename T>
void print_arr(T* arr, std::size_t size)
{
    for(std::size_t i = 0; i < size; i++)
    {
        std::cout<< arr[i] << ((i==size-1) ? "" : " ");
    }
    std::cout<<std::endl;
}

int main(int argc, char** argv)
{
    int hello[10] = {1,10,20,0,59,86,32,11,9,40};
    print_arr(hello,10);
    rotate_array(hello,10,2);
    // reverse(hello,10,0,9);
    print_arr(hello,10);
    return 0;
}

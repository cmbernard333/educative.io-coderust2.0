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
void reverse(T* arr, std::size_t size)
{
    /* size = 3; stop at 1 */
    /* size = 4; stop at 2 */
    for(std::size_t i = size-1; i > (size/2)-1; i--)
    {
       /* 1 2 3 -> 3 2 1*/
       /* 8 7 4 2 -> 2 4 7 8 */ 
        swap(&arr[i], &arr[(size-1)-i]);
    } 
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
    reverse(hello,10);
    print_arr(hello,10);
    return 0;
}

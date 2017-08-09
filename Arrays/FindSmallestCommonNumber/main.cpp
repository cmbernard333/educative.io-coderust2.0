#include <iostream> 
#include <cstddef>
#include <algorithm>

/*
Given three integer arrays sorted in ascending order, 
find the smallest number that is common in all three arrays. 
For example, let's look at the below three arrays. 

int[] first = {6,7,10,25,30,63,64};
int[] second = {-1,4,5,6,7,8,50};
int[] third = {1,6,10,14};

Here 6 is the smallest number that's common in all the arrays.
*/

void print_arr(int* arr, std::size_t size)
{
    for(int i = 0; i < size; i++)
    {
        std::cout<< arr[i] << " ";
    }
    std::cout<<std::endl;
}

int find_smallest_common_number(
    int* first, std::size_t f_size, 
    int* second, std::size_t s_size, 
    int* third, std::size_t t_size)
{
    int fp = 0, sp = 0, tp = 0;
    int cur_smallest = 0;
    while(fp < f_size && sp < s_size && tp < t_size)
    {
        /* did we find the smallest common between the three ?*/
        if (first[fp] == second[sp] && second[sp] == third[tp]) 
        {
            cur_smallest = first[fp];
            break;
        }
        /* calculate min between the three */
        cur_smallest = std::min(first[fp], second[sp]);
        cur_smallest = std::min(cur_smallest, third[tp]);
        /* check for advancement based on min */
        if (first[fp] == cur_smallest) 
        {
            std::cout<<"First array has smallest value of " << first[fp] << ". Advancing pointer" << std::endl;
            fp++;
        }
        if (second[sp] == cur_smallest) 
        {
            std::cout<<"Second array has smallest value of " << second[sp] << ". Advancing pointer" << std::endl;
            sp++;
        }
        if (third[tp] == cur_smallest)
        {
            std::cout<<"Third array has smallest value of " << third[tp] << ". Advancing pointer" << std::endl;
            tp++;
        }
    }
    return cur_smallest;
}

int main(int argc, char** argv)
{
    int first[7] = {6,7,10,25,30,63,64};
    int second[7] = {-1,4,5,6,7,8,50};
    int third[4] = {1,6,10,14};

    print_arr(first, 7);
    print_arr(second, 7);
    print_arr(third, 4);

    int smallest = find_smallest_common_number(first, 7, second, 7, third, 4);

    std::cout<<"Smallest number in arrays is " << smallest << std::endl;

}

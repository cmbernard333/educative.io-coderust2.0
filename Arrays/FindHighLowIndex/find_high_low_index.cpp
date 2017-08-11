#include <iostream>
#include <cstdlib>
#include <vector>
#include <utility>

/*
Given a sorted array of integers, return the low and high index of the given key. Return -1 if not found. The array length can be in millions with lots of duplicates.
In the following example, low and high indices would be:

0| 1| 2| 3| 4| 5| 6| 7| 8| 9| 10
1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20

Key: 1, Low=0 and High=0

Key: 2, Low=1 and High=1

Key: 5, Low=2 and High=9

key: 20, Low=10 and High=10

edge cases

middle third
0| 1| 2| 3| 4| 5|
1, 2, 2, 4, 5, 6

upper third
0| 1| 2| 3| 4| 5|
1, 2, 3, 4, 4, 5 

front
0| 1| 2| 3| 4| 5|
1, 1, 2, 3, 4, 5

back
0| 1| 2| 3| 4| 5|
1, 2, 3, 4, 5, 5

*/

#define print_index(_num, _index) std::cout<<"Found "<<_num<<" at " << _index <<std::endl

template<typename T>
int binary_search(const std::vector<T>& vec, int low, int high, T& key)
{
    while(low <= high) // have to consider front and back indices
    {
        int mid = low + (high - low)/2;
        if(vec[mid] == key) 
        {
            return mid;
        }

        if(key > vec[mid]) 
        {
            low = mid+1; // +1 because we already searched the middle 
        }
        else if(key < vec[mid])
        {
            high = mid-1; // -1 because we already searched the middle
        }
    }

    return -1;
}

template<typename T>
std::pair<int,int> find_high_low_index(const std::vector<T>& vec, T& key)
{
    /* Idea: search until you don't find it in each half*/
    int mid_index = 0; // first found
    int r = 0; // temp
    int low_index = 0; // low_index
    int high_index = 0; // high_index
    /* binary seach on the whole thing - find where the value is */
    mid_index = binary_search(vec,0,vec.size()-1,key);
    r = mid_index;
    /* the high or low index could be the first one found */
    low_index = r;
    high_index = r;
    /* search to the right of it - (r+1) because we already found it at mid_index*/
    std::cout<<"Key="<<key<<" Mid_index="<<mid_index<<std::endl;
    while( (r = binary_search(vec,r+1,vec.size()-1,key)) != -1)
    {
        high_index = r; 
    }
    /* reset */
    r = mid_index;
    /* search to the left of it - (r-1) because we already found it at mid_index */
    while( (r = binary_search(vec,0,r-1,key)) != -1)
    {
        low_index = r;
    }

    return std::make_pair(low_index,high_index);
}

int main(int argc, char** argv)
{
    // std::vector<int> vec = {1, 2, 5, 5, 5, 5, 5, 5, 5, 5, 20}; // requires c++11 > --std=c++11
    std::vector<int> vec = {1,1,2,2,3,4,4,5}; // requires c++11 > --std=c++11
    std::vector<int> find = {1, 2, 3, 4, 5}; // requires c++11 > --std=c++11
    std::pair<int,int> found;
    for(auto i : find)
    {
        found = find_high_low_index(vec,i);
        std::cout<<"Key: "<<i<<" Low=("<<found.first<<") and High=("<<found.second<<")"<<std::endl;
    }
    return 0;
}
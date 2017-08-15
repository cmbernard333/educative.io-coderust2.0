#include <iostream>
#include <cassert>
#include "linked_list.hpp"

template<typename T>
using ComprarFunc = int(*)(const T& x, const T& y);

static int sort_ascending(const int& x, const int &y)
{
    return x - y;
}

int main(int argc, char **argv)
{
    LinkedListHead<int> head(0), *cur = &head;
    ComprarFunc<int> f = sort_ascending;
    int arr[10] = {-10,27,3,5,1,22,63,14,100,90};
    for(int i = 0; i < 10; i++)
    {
        cur->next = new LinkedListHead<int>(arr[i]);
        std::cout << cur->data << ((i < 9) ? "->" : "\n");
        cur = cur->next;
    }
    cur = &head;
    mergesort(&cur, f);
    return 0;
}
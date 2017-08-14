#include <iostream>
#include <cassert>
#include "linked_list.hpp"

int main(int argc, char **argv)
{
    linked_list_head<int> head(0), *cur = &head;
    for(int i = 0; i<10; i++)
    {
        cur->next = new linked_list_head<int>(i);
        std::cout << cur->data << ((i<9) ? "->" : "\n");
        cur = cur->next;
    }
    return 0;
}
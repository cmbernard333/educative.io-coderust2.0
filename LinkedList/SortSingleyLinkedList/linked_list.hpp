#pragma once
#include <iostream>
#include <sstream>
#include <cstddef>


template <typename T> 
struct delete_it;

/* 
    template specialization
    its really cooky looking
 */
template <typename T> struct delete_it<T*>
{
    static void do_delete (const T* ptr) { delete ptr; }
};

template <> struct delete_it<char>
{
    static void do_delete (const char ptr) {}
};

template <> struct delete_it<int>
{
    static void do_delete (const int ptr) {}
};

template <> struct delete_it<short>
{
    static void do_delete (const short ptr) {}
};

template <> struct delete_it<long>
{
    static void do_delete (const long ptr) {}
};
/*
template <> struct delete_it<byte>
{
    static void do_delete (const byte ptr) {}
};
*/

template <> struct delete_it<float>
{    
    static void do_delete (const float ptr) {}
};

template <> struct delete_it<double>
{    
    static void do_delete (const double ptr) {}
};
/*
template <> struct delete_it<real>
{    
    static void do_delete (const real ptr) {}
};
*/
template <> struct delete_it<bool>
{
    static void do_delete (const bool ptr) {}
};


template<typename T>
struct LinkedListHead {

    LinkedListHead(const T& ele) : data(ele) {
        next = nullptr;
    }

    ~LinkedListHead()
    {
        LinkedListHead* cur = this;
        while(cur->next != nullptr)
        {
            delete_it<T>::do_delete(data); // call destructor
            cur = cur->next;
            free(cur);
        }
    }



    /* struct memebers are public by default */
    LinkedListHead<T>* next;
    const T& data;
};

/* toString - provides an override for ostream */
template<typename T>
std::ostream& operator<<(std::ostream& o, const LinkedListHead<T>& head)
{
    const LinkedListHead<T>* cur = &head;
    std::stringstream ss;

    while( cur != nullptr )
    {
        
        ss << cur->data;
        ss << (( cur->next != nullptr ) ? "->" : "");
        cur = cur->next;
    }

    return o << ss.str();
}

/* sorting stuff */

template<typename T>
static void frontbacksplit(LinkedListHead<T>* src, LinkedListHead<T>** front, LinkedListHead<T>** back)
{
    /*
        need to split the list in two for mergesort
        10->1->2->8->7->87->20

        start = 0
        end = 6

        (start + end)/2 = 3

        sublists:

        lower:          upper:

        10->1->2->8    7->87->20

        since linkedlists typically do not have a size param and are not allocated contiguously - then you have to find the midpoint manually
    */

    LinkedListHead<T>* fast = nullptr;
	LinkedListHead<T>* slow = nullptr;

    /* base case - single value in a list */
    if( src == nullptr || src->next == nullptr)
    {
        *front = src;
        *back = nullptr;
    }
    else
    {
        slow = src;
        fast = slow->next;

        while(fast != nullptr)
        {
            /* advance fast by two and slow by one */
            fast = fast->next;
            if(fast != nullptr)
            {
                slow = slow->next;
                fast = fast->next;
            }
        }

        /* just before mid point, split into two - this modifies the src list */
        *front = src;
        *back = slow->next;
        slow->next = nullptr;
    }

    std::cout << "front:" << *src << std::endl;
    std::cout << "back:" << **back << std::endl;
}

template<typename T, class Comparator>
LinkedListHead<T>* mergelist(LinkedListHead<T>* lstA, LinkedListHead<T>*lstB, Comparator comprar)
{
    /* head of the left list */
    LinkedListHead<T>* lstA_ptr = lstA;
    /* head of the right list */
    LinkedListHead<T>* lstB_ptr = lstB;
    /* head of the merged list and the current pointer in the merged list */
    LinkedListHead<T>* lstMerge_ptr_head = nullptr, *lstMerge_ptr = nullptr;
    /* the ptr ot the current place in the merged list */
    LinkedListHead<T>* tmp = nullptr;

    while( lstA_ptr != nullptr && lstB_ptr != nullptr )
    {
        /* the node in list a comes before the node in list b */
        if(comprar(lstA_ptr->data, lstB_ptr->data) <= 0)
        {
            tmp = lstA_ptr;
            lstA_ptr = lstA_ptr->next;
        }
        /* the node in list b comes before the node in list a */
        else
        { 
            tmp = lstB_ptr;
            lstB_ptr = lstB_ptr->next;
        }

        /* set the head or set the next ptr */
        if(lstMerge_ptr_head == nullptr)
        {
            lstMerge_ptr_head = tmp;
			lstMerge_ptr = lstMerge_ptr_head;
        }
        else
        {
            lstMerge_ptr->next = tmp;
			/* advance to the element just added */
			lstMerge_ptr = lstMerge_ptr->next;
        }
    }

    /* TODO - merge remaining elements in one of the lists - probably list A */
    while((tmp = lstA_ptr) != nullptr)
    {
        /* add to the list */
        lstMerge_ptr->next = tmp;
        /* advance the list a ptr */
        lstA_ptr = lstA_ptr->next;
        /* advance the merge list ptr */
        lstMerge_ptr = lstMerge_ptr->next;
    }

    return lstMerge_ptr_head;
}

template<typename T, class Comparator>
void mergesort(LinkedListHead<T>** start, Comparator comprar)
{
    LinkedListHead<T>* head = *start;
    LinkedListHead<T>* a = nullptr, *b = nullptr;
    if((head == nullptr) || (head->next == nullptr))
    {
        return;
    }
    frontbacksplit(head, &a, &b);
    mergesort(&a, comprar);
    mergesort(&b, comprar);
    *start = mergelist(a, b, comprar);
}

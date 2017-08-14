#pragma once
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
struct linked_list_head {

    linked_list_head(const T& ele) : data(ele) {
        next = nullptr;
    }

    ~linked_list_head()
    {
        linked_list_head* cur = this;
        while(cur->next != nullptr)
        {
            delete_it<T>::do_delete(data); // call destructor
            cur = cur->next;
            free(cur);
        }
    }

    /* struct memebers are public by default */
    linked_list_head<T>* next;
    const T& data;
};
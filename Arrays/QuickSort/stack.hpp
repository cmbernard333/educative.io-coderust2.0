#pragma once
#include <deque>

template< typename T, typename Container = std::deque<T> > 
class stack
{
    /* container supports following types 
     * empty
     * size
     * back
     * push_back
     * pop_back
     */

    /*
     * empty
     * Test whether container is empty (public member function )
     *
     * size
     * Return size (public member function )
     *
     * top
     * Access next element (public member function )
     *
     * push
     * Insert element (public member function )
     *
     * emplace 
     * Construct and insert element (public member function )
     *
     * pop
     * Remove top element (public member function )
     *
     * swap 
     * Swap contents (public member function )
     */
    public:
    
    /* ctor/ccopy constructor for creating a default backend store or copying values from the argument */
    explicit stack( const Container& cntr = Container() )
    {
        this->c = new Container();
        for(auto i : cntr)
        {
            this->c->push_back(i);
        }
    }

    bool empty() const
    {
        this->c->size() = 0;
    }

    int size() const
    {
        return this->c->size();
    }

    T& top()
    {
        return this->c->back();
    }

    const T& top() const
    {
        return const_cast<T&>(this->c->back());
    }

    void push(const T& ele) 
    {
        this->c->push_back(ele);
    }

    /* TODO: emplace is not implemented */

    /* destructs the object */
    void pop() 
    {
        this->c->pop_back();
    }

    /* TODO: swap is not implemented */

    ~stack() 
    {
        delete(c);
    }

    private:
    Container* c;
};

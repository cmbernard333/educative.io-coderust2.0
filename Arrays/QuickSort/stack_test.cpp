#include <iostream>
#include "stack.hpp"
#include <cassert>

#define assert_message(err, assert_expr) \
{ \
    if(!(assert_expr)) \
    { \
        std::cerr<<err<<std::endl; \
        assert(assert_expr); \
    } \
} \

int main(int argc, char** argv)
{
    stack<int> s;
    s.push(1);
    assert(s.top()==1);
    assert(s.size()==1);
    // calling s.top() on an empty container is undefined behavior
    s.pop();
    assert_message("Size was expected to be 0!",s.size()==0);
    return 0;
}

#include <vector>
#include "binary_search.h"

int binary_search_test()
{
    std::vector<int> v {1,3,7,9,12};
    std::vector<int> find {10,9,11,2,12};
    for(auto i : v) 
    {
        std::cout << i << " ";
    }
    std::cout<<std::endl;
    for (auto it = find.begin(); it != find.end(); it++) 
    {
        int index = binary_search(v, *it, 0, v.size()-1);
        std::cout<<"Found "<<*it<<" at index "<<index<<std::endl;
    }
    return 0;
}

int main()
{
    return binary_search_test();
}
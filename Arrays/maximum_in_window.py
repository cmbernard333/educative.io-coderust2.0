''' 
simple heap class in python
takes a compare function much like javas compareTo function
if x.compareTo(y) returns <=0 then x comes before y
if x.compareTo(y) returns >=0 then y comes before x
if x.compareTo(y) returns ==0 then x and y are the same
'''

def min_comp(x,y):
    if x == y:
        return 0
    m = min(x,y)
    if m == x:
        return -1
    else:
        return 1 

def max_comp(x,y):
    if x == y:
        return 0
    m = max(x,y)
    if m == x:
        return -1
    else:
        return 1

class heap:
    def __init__(self,comp):
        self._h = []
        self._comp = comp

    def __repr__(self):
        return self._h

    def __str__(self):
        return ', '.join(str(x) for x in self._h)

    def __swap(self, arr, x, y):
            temp = arr[x]
            arr[x] = arr[y]
            arr[y] = temp

    def __heapify_up(self, arr, index):
        par_index = int(index/2)
        while self._comp(arr[index],arr[par_index]) < 0 and index > 0:
            self.__swap(arr,index,par_index)
            index = par_index
            par_index = int(index/2)

    def __heapify_down(self, arr, index):
        if index < len(arr)-1: # index is resolvable
            left_child = index*2+1 # root at 0
            right_child = index*2+2 # root at 0
            print('__heapify_down: arr={0}, index={1}, left_child={2}, right_child={3}'.format(arr,index,left_child,right_child))
            if left_child < len(arr) and self._comp(arr[index], arr[left_child]) > 0: # left_child is inside the array - including the final index
                self.__swap(arr,index,left_child) 
                index = left_child
            elif right_child < len(arr) and self._comp(arr[index], arr[right_child]) > 0: # right_child is inside the array - including the final index
                self.__swap(arr,index,right_child)
                index = right_child
            else:
                return
            self.__heapify_down(arr, index)

    def push(self,ele):
        if len(self._h) == 0:
            self._h.insert(0,ele)
        else:
            self._h.append(ele)
            self.__heapify_up(self._h, len(self._h)-1)

    def pop(self):
        r = self._h[0]
        if len(self._h) == 0:
            return None
        else:
            r = self._h.pop()
            self._h[0] = r
            self.__heapify_down(self._h, 0)
        return r


def maximum_in_window(arr,w_size):
    cur_max = arr[0] # assume its the first value
    for index in range(0,len(arr)):
        print('arr[{0}]={1}'.format(index,arr[index]))

if __name__ == '__main__':
    arr=[-4,2,-5,3,6]
    nums=[4,1,2,10,3]
    max_heap = heap(max_comp)
    min_heap = heap(min_comp)
    for num in nums:
        max_heap.push(num)
        min_heap.push(num)
    print(max_heap)
    print(min_heap)
    max_heap.pop()
    min_heap.pop()
    print(max_heap)
    print(min_heap)
    # maximum_in_window(arr,3)
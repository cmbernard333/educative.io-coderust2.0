''' 
simple heap class in python
takes a compare function much like javas compareTo function
if x.compareTo(y) returns <=0 then x comes before y
if x.compareTo(y) returns >=0 then y comes before x
if x.compareTo(y) returns ==0 then x and y are the same
'''

import time
import random
from collections import deque

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
            # print('__heapify_down: arr={0}, index={1}, left_child={2}, right_child={3}'.format(arr,index,left_child,right_child))
            if left_child < len(arr) and self._comp(arr[index], arr[left_child]) > 0: # left_child is inside the array - including the final index
                self.__swap(arr,index,left_child) 
                index = left_child
            elif right_child < len(arr) and self._comp(arr[index], arr[right_child]) > 0: # right_child is inside the array - including the final index
                self.__swap(arr,index,right_child)
                index = right_child
            else:
                return
            self.__heapify_down(arr, index)

    '''
    Push a new element onto the heap
    '''
    def push(self,ele):
        if len(self._h) == 0:
            self._h.insert(0,ele)
        else:
            self._h.append(ele)
            self.__heapify_up(self._h, len(self._h)-1)

    '''
    Pop and return the top of the heap
    '''
    def pop(self):
        if len(self._h) == 0:
            return None
        else:
            r = self._h[0] # grab top
            self._h[0] = self._h.pop(-1) # replace top with bottom
            self.__heapify_down(self._h, 0)
        return r

    def peek(self):
        return self._h[0]

    '''
    Delete at a specific index by replacing it with the last element in the heap, removing the last element, and calling
    heapify_down at the replaced index
    '''
    def delete_at(self,index):
        # print('heap.delete_at({})'.format(index))
        r = self._h[index]
        x = self._h[-1]
        self._h[index] = x # grab the last element and heapify_down
        self._h.pop(-1)
        self.__heapify_down(self._h,index)
        return r

    '''
    Find, delete, and return an elemenet from the heap
    Return None if not found
    '''
    def delete(self,ele):
        # print('heap.delete({})'.format(ele))
        r = None
        for n in range(0,len(self._h)):
            # print('self._h[{0}] == {1}'.format(n, self._h[n]))
            if self._comp(self._h[n],ele) == 0:
                r = self.delete_at(n)
                break
        return r

    '''
    Extend the heap by an iterable
    '''
    def extend(self,iterable):
        for ele in iterable:
            self.push(ele)


def maximum_in_window(arr,w_size):
    # print('maximum_in_window(arr={0},w_size={1})'.format(arr,w_size))
    max_list = []
    max_heap = heap(max_comp)
    max_heap.extend(arr[0:w_size]) # grab the first window
    for index in range(w_size,len(arr)):
        max_list.append(max_heap.peek())
        max_heap.push(arr[index])
        max_heap.delete(arr[index-(w_size)])
    max_list.append(max_heap.peek())
    return max_list

class Timer:

    def __init__(self):
        self._start = 0
        self._end = 0
        self._elapsed = 0

    def start(self):
        self._start = time.time()
        self._end = 0

    def end(self):
        self._end = time.time()

    def elapsed(self):
        return self._end - self._start

def maximum_in_window_list(arr, w_size):
    # print('maximum_in_window(arr={0},w_size={1})'.format(arr,w_size))
    max_list = []
    for index in range(0,(len(arr)-w_size)+1): # window cannot exceed the bounds of the list
        cur_win_max = arr[index]
        #print('index={}'.format(index))
        #print('window={}'.format(arr[index:index+w_size]))
        for n in arr[index:index+w_size]: # using slices is cheating but it works in python :)
            if cur_win_max < n:
                cur_win_max = n
        #print ('max in window = {}'.format(cur_win_max))
        max_list.append(cur_win_max)
    return max_list

def find_max_sliding_window(arr, window_size):
    if window_size > len(arr):
        return

    window = deque()

    #find out max for first window
    for i in range(0, window_size):
        while window and arr[i] >= arr[window[-1]]:
            window.pop()
        window.append(i)

    print(arr[window[0]])

    for i in range(window_size, len(arr)):
    #remove all numbers that are smaller than current number
    #from the tail of list
        while window and arr[i] >= arr[window[-1]]:
            window.pop()

        #remove first number if it doesn't fall in the window anymore
        if window and (window[0] <= i - window_size) :
            window.popleft()

    window.append(i)
    print(arr[window[0]])


'''
Debug function for showing heap functionality
'''
def show_heap():
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
    max_heap.delete(3)
    print(max_heap)

if __name__ == '__main__':
    arr=[10,2,-5,3,6]
    r = []
    for n in range(0,60):
        r.append(random.randint(0,100))
    # show_heap()

    t = Timer()
    # using heap
    t.start()
    m_list = maximum_in_window(r,3)
    t.end()
    print(t.elapsed())
    print(m_list)
    print('------------------------------------------------------')

    # using list
    t.start()
    m_list = maximum_in_window_list(r,3)
    t.end()
    print(t.elapsed())
    print(m_list)
    print('------------------------------------------------------')

    # using double linked list
    t.start()
    m_list = find_max_sliding_window(r,3)
    t.end()
    print(t.elapsed())
    print(m_list)
    print('------------------------------------------------------')
    
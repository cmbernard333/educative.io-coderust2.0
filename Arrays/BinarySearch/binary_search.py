def binary_search(arr,ele,l,h):
    if l > h:
        return -1
    else:
        mid = int((l+h)/2)
        if arr[mid] == ele: 
            return mid
        if ele < arr[mid]:
            return binary_search(arr,ele,l,mid-1) # mid -1 because you already considered it
        if ele > arr[mid]:
            return binary_search(arr,ele,mid+1,h) # mid + 1 because you already considered it

def binary_search_iter(arr, ele, l ,h):
    while l < h:
        mid = int((l + h) /2)
        if ele == arr [mid]:
            return mid
        elif ele > arr[mid]:
            l = mid+1
        elif ele < arr[mid]:
            h = mid
    return -1

if __name__ == '__main__':
    arr = [2,5,8,9,11,13]
    find = [1,2,3,4,5]
    print(arr)
    print('Recursive')
    for value in find: 
        print('arr[{0}] == {1}'.format(binary_search(arr,value,0,len(arr)-1), value))
    print('Iterative')
    for value in find:
        print('arr[{0}] == {1}'.format(binary_search_iter(arr,value,0,len(arr)-1), value))

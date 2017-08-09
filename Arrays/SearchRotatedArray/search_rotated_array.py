from binary_search import binary_search_iter

'''
Search a rotated array for a number
Array is assumed to be sorted
Assume you know the number of rotations
'''
def search_rotated_array_r(arr,ele,r):
    if ele >= arr[0] and ele <= arr[r-1]:
        print('Search bottom half between {0}...{1}'.format(arr[0],arr[r-1]))
        return binary_search_iter(arr,ele,0,r-1)
    if ele >= arr[r] and ele <= arr[-1]:
        print('Search top half between {0}...{1}'.format(arr[r],arr[-1]))
        return binary_search_iter(arr,ele,r,len(arr)-1)

'''
Search a rotated array for a number
Array is assumed to be sorted
Cannot assume the number of rotations
'''
def search_rotated_array(arr,ele,low,high):
    if low > high:
        return -1

    mid = low + int((high-low)/2)

    if arr[mid] == ele:
        return mid

    # check if we are in a sorted portion in the lower part and if the element fits
    if arr[low] < arr[mid] and ele < arr[mid] and ele >= arr[low]:
        return search_rotated_array(arr,ele,low,mid-1)
    # check if we are in a sorted portion in the higher part and if the element fits
    elif arr[mid] < arr[high] and ele > arr[mid] and ele <= arr[high]:
        return search_rotated_array(arr,ele,mid+1,high)
    # we are in an unsorted portion in the lower part
    elif arr[low] > arr[mid]:
        return search_rotated_array(arr,ele,low,mid-1)
    # we are in an unsorted portion in the higher part
    elif arr[high] < arr[mid]:
        return search_rotated_array(arr,ele,mid+1,high)

    return -1

def binary_search_rotated(arr, key):
  return search_rotated_array(arr, 0, len(arr)-1, key)

if __name__ == "__main__":
    rotate_arr = [176,188,199,200,210,222,1,10,20,47,59,63,75,88,99,107,120,133,155,162]
    #found = search_rotated_array_r(rotate_arr,200,6)
    found = search_rotated_array(rotate_arr,200,0,len(rotate_arr)-1)
    print(found)

    rotate_arr = [7,9,12,1,3]
    #found = search_rotated_array_r(rotate_arr,1,3)
    found = search_rotated_array(rotate_arr,1,0,len(rotate_arr)-1)
    print(found)
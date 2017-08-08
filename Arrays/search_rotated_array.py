from binary_search import binary_search_iter

'''
Search a rotated array for a number
Array is assumed to be sorted
'''
def search_rotated_array(arr,ele,r):
    if ele >= arr[0] and ele <= arr[r-1]:
        print('Search bottom half between {0}...{1}'.format(arr[0],arr[r-1]))
        return binary_search_iter(arr,ele,0,r-1)
    if ele >= arr[r] and ele <= arr[-1]:
        print('Search top half between {0}...{1}'.format(arr[r],arr[-1]))
        return binary_search_iter(arr,ele,r,len(arr)-1)

if __name__ == "__main__":
    rotate_arr = [176,188,199,200,210,222,1,10,20,47,59,63,75,88,99,107,120,133,155,162]
    print(search_rotated_array(rotate_arr,200,6))
    rotate_arr_2 = [7,9,12,1,3]
    print(search_rotated_array(rotate_arr_2,1,3))
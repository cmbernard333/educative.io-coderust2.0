package main // package main means this is an executable and not a library
import
(
    "fmt"
    "math/rand"
)

func BinarySearch(a []int, key, start, end int)(found int) {
    found = -1
    for start < end {
        mid := (end-start)/2
        if key == a[mid] {
           found = mid
           break
        }
        if key < a[mid] {
            end = mid-1
        }
        if key > a[mid] {
            start = mid+1
        }
    }
    return
}

func main() {
    a := [4]int{1,2,3,4}
    var b [10]int
    // searching the slice
    fmt.Printf("%#v\n",a)
    found := BinarySearch(a[0:],2,0,len(a)-1)
    fmt.Printf("Found %d in a[4]int: %d\n",2,found)
    // generate 10 numbers
    for i := 0; i<10; i++ {
        b[i] = rand.Intn(100)
    }
    // search the random numbers
    fmt.Printf("%#v\n",b)
    found = BinarySearch(b[0:],10,0,len(b)-1)
    fmt.Printf("Found %d in b[10]int: %d\n",10,found)
}

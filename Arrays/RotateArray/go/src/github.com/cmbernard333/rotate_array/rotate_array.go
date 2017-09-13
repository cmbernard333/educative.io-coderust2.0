package main

import(
    "fmt"
)

// swap is idiomatically implemented like this
// i,j := 1,2
// i,j = j,i

// int slice with start and end indices
func Reverse(a []int, start, end int) {
    for start < end {
        a[start], a[end] = a[end], a[start]
        start += 1
        end -= 1
    }
}

func Rotate(a []int, rotate int) {
    rotate = rotate % len(a)
    if (rotate < 0) {
        rotate = rotate + len(a)
    }
    Reverse(a, 0, len(a)-1)
    Reverse(a, 0, rotate-1)
    Reverse(a, rotate, len(a)-1)
}

func main() {
    // infer, declare, and assign
    hello := [10]int{1,10,20,0,59,86,32,11,9,40}
    // Reverse the array using a slice
    Rotate(hello[0:], -1)
    // _ means you don't care about the index
    for _, i:= range hello {
        fmt.Printf("%d\n",i)
    }
}

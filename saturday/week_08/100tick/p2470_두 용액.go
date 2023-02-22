package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

var r = bufio.NewReader(os.Stdin)

func main() {
	var N int
	fmt.Scan(&N)

	ints := make([]int, N)
	ans, a, b := math.MaxInt, 0, 0

	for i := 0; i < N; i++ {
		fmt.Fscan(r, &ints[i])
	}
	sort.Ints(ints)

	lo := 0
	hi := N - 1
	for lo < hi {
		left, right := ints[lo], ints[hi]
		sum := left + right
		abs := sum
		// abs
		if sum < 0 {
			abs = -sum
		}

		// update ans
		if abs < ans {
			ans = abs
			a, b = left, right
		}

		if sum < 0 {
			lo++
		} else {
			hi--
		}

	}

	fmt.Println(a, b)

}

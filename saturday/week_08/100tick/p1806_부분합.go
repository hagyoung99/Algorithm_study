package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

var r = bufio.NewReader(os.Stdin)

func main() {
	var N, S int
	fmt.Scan(&N)
	fmt.Scan(&S)

	ints := make([]int, N)
	for i := 0; i < N; i++ {
		fmt.Fscan(r, &ints[i])
	}

	sum, ans := 0, math.MaxInt
	l, r := 0, 0

	for {
		if sum >= S {
			// r-l(길이) 갱신
			if r-l < ans {
				ans = r - l
			}
			sum -= ints[l]
			l++
      // sum < S && r == N일 때는 r++이 일어나지 않음
		} else if r == N {
			break
		} else {
			sum += ints[r]
			r++
		}
	}

	if ans == math.MaxInt {
		fmt.Println(0)
	} else {
		fmt.Println(ans)
	}

}

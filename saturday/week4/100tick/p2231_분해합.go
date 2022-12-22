package main

import (
	"fmt"
)

var (
	n, m int
)

func main() {
	fmt.Scanf("%d\n", &n)

	for i := 1; i < n; i++ {
		m = i
		if i > 9 {
			num := i
			for num > 0 {
				u1 := num % 10
				num /= 10
				m += u1
			}
		} else {
			m += i
		}

		if m == n {
			fmt.Println(i)
			return
		}
	}

	fmt.Println(0)
}

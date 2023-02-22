package main

import (
	"fmt"
	"strings"
)

var (
	n, order int
)

func main() {
	fmt.Scanf("%d", &n)

	i := 666
	for order < n {
		s := fmt.Sprint(i)
		if strings.Contains(s, "666") {
			order++
		}
		i++
	}

	fmt.Println(i - 1)
}

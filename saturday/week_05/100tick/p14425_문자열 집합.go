package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	n, m, cnt int
	strs      []string
)

func main() {
	scanner := bufio.NewScanner(os.Stdin)

	fmt.Scanf("%d %d", &n, &m)

	for i := 0; i < n; i++ {
		scanner.Scan()
		strs = append(strs, scanner.Text())
	}

	for i := 0; i < m; i++ {
		scanner.Scan()
		s := scanner.Text()
		for _, str := range strs {
			if str == s {
				cnt++
			}
		}
	}
	fmt.Println(cnt)
}

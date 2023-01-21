package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	N, M int
	arr  []int
)

var (
	rd = bufio.NewReader(os.Stdin)
	wr = bufio.NewWriter(os.Stdout)
)

func main() {
	defer wr.Flush()
	fmt.Fscanf(rd, "%d %d", &N, &M)

	arr = make([]int, M+1)

	dfs(1)
}

func dfs(idx int) {
	if idx > M {
		for i := 1; i <= M; i++ {
			fmt.Fprint(wr, arr[i], " ")
		}
		fmt.Fprintln(wr)
		return
	}

	for i := 1; i <= N; i++ {

		arr[idx] = i
		dfs(idx + 1)
	}
}

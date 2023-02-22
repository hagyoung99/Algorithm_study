package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

var (
	myNums map[string]int = make(map[string]int)
)

func main() {
	rd := bufio.NewReader(os.Stdin)
	wr := bufio.NewWriter(os.Stdout)
	defer wr.Flush()

	rd.ReadString('\n')
	s, _ := rd.ReadString('\n')
	for _, v := range strings.Fields(s) {

		if _, ok := myNums[v]; !ok {
			myNums[v] = 0
		}
		myNums[v]++
	}
	rd.ReadString('\n')
	s, _ = rd.ReadString('\n')
	for _, v := range strings.Fields(s) {

		c := 0
		if cnt, ok := myNums[v]; ok {
			c = cnt
		}
		wr.WriteString(fmt.Sprint(c) + " ")
	}
}

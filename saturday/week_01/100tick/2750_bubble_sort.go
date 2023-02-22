package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	// N = 입력 받을 숫자의 갯수
	// nums = 입력 받은 숫자 배열

	// ================================
	// START INPUT
	// ================================
	var N int
	sc := bufio.NewScanner(os.Stdin)
	sc.Scan()
	N, _ = strconv.Atoi(sc.Text())

	nums := make([]int, N)
	for i := 0; i < N; i++ {
		sc.Scan()
		n, _ := strconv.Atoi(sc.Text())
		nums[i] = n
	}
	// ================================
	// END INPUT
	// ================================

	// ================================
	// BUBBLE SORT
	// ================================
	for i := 0; i < len(nums); i++ {
		for j := 1; j < len(nums)-i; j++ {
			if nums[j-1] > nums[j] {
				nums[j-1], nums[j] = nums[j], nums[j-1]
			}
		}
	}

	// ================================
	// PRINT nums
	// ================================
	for _, n := range nums {
		fmt.Println(n)
	}
}


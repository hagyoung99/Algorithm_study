// =======================================
//
// p2750 [수 정렬하기]
//
// [문제]
// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 수가 주어진다.
// 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
// [출력]
// 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
// [https://www.acmicpc.net/problem/2750]
//
// =======================================
// IMPORT
// =======================================
package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	// 빠른 io를 위해 Reader, Writer 생성
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	// 모든 데이터를 write 한 뒤 Flsuh
	// defer는 defer가 선언된 함수 내의 모든 로직이 실행되고,
	// 해당 함수가 종료될 때 실행된다.
	// 여기서는 main 함수 내에 있으므로 main 함수의 모든 로직 이후 실행됨
	defer w.Flush()

	// 입력 받을 수의 개수, N
	var N int
	fmt.Fscanln(r, &N)
	// N개의 요소를 갖는 int Slice(동적 배열), nums 생성
	nums := make([]int, N)

	// Fscanf로 입력을 받아 nums[i]에 저장
	for i := 0; i < N; i++ {
		fmt.Fscanln(r, &nums[i])
	}

	// =======================================
	// SORT
	// =======================================
	//
	// Slice SORT를 위해 sort 패키지의 SliceStable 함수 사용
	// 콜백 함수로 comparer 함수 작성
	//
	// Python:
	// 	nums.sort()
	//
	// Java:
	//  Arrays.sort(nums);
	//
	// Cpp:
	//  sort(nums.begin(), nums.end());
	//
	// JavaScript:
	//  JS는 sort 시, number 배열이라도 UTF-8 string으로 변경한 뒤
	//  unicode를 비교하여 sort를 하기 때문에 a > b 비교 연산이 아닌
	//  a - b 연산을 하여 number type으로 변환 -> 비교가 일어나게 하는듯
	//  nums.sort((a, b) => a - b);
	//
	// go에서의 기본 오름차순 정렬
	sort.Ints(nums)
	// =======================================
	// OUTPUT
	// =======================================
	// Go의 range는 Python과 다름
	// go에서의 range는 Slice를 받아 반복문에서 index, value를 함께 제공해주지만
	// Python에서의 range는 숫자를 받아, 해당 범위로 구성된 리스트 생성해줌
	for _, n := range nums {
		fmt.Fprintln(w, n)
	}
}

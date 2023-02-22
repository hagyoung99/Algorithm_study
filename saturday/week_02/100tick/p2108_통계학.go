// =======================================
//
// p2108 [통계학]
//
// [문제]
// 수를 처리하는 것은 통계학에서 상당히 중요한 일이다.
// 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다.
// 단, N은 홀수라고 가정하자.
// 산술평균 : N개의 수들의 합을 N으로 나눈 값
// 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
// 최빈값 : N개의 수들 중 가장 많이 나타나는 값
// 범위 : N개의 수들 중 최댓값과 최솟값의 차이
// N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
// 단, N은 홀수이다.
// 그 다음 N개의 줄에는 정수들이 주어진다.
// 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
//
// [출력]
// 첫째 줄에는 산술평균을 출력한다.
// 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
// 둘째 줄에는 중앙값을 출력한다.
// 셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
// 넷째 줄에는 범위를 출력한다.

// [https://www.acmicpc.net/problem/2108]
//
// =======================================
// IMPORT
// =======================================
package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"sort"
)

func main() {
	// =======================================
	// FOR FAST INPUT/OUTPUT
	// =======================================
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	// =======================================
	// INPUT
	// =======================================
	// N: 입력 받을 수의 개수 1 ≤ N ≤ 500,000, N은 홀수
	var N int
	fmt.Fscanf(r, "%d\n", &N)

	// nums: N개의 정수 (-4,000 ≤ num ≤ 4,000)를 저장할
	// []int -> 동적으로 Size가 변할 수 있는 int 배열
	nums := make([]int, N)
	// N회 반복 입력 받기
	for i := 0; i < N; i++ {
		fmt.Fscanf(r, "%d\n", &nums[i])
	}

	// =======================================
	// Main Logic
	// =======================================
	// 1. 산술 평균
	// 반드시 int로 변환할 것
	// avg가 float64인 경우
	// 소수점 아래 부분 비트가 남기 때문에
	// -0이라는 결과가 나와서 테스트를 통과하지 못함
	avg := int(math.Round(float64(Sum(nums)) / float64(N)))
	//
	// -> 컴퓨터 상에서 부동소수점 연산 자체가 매우 부정확한 연산
	// 웬만하면 정수로 연산할 것
	//
	//
	//
	// 중앙값, 범위를 구하기 위해서는 먼저 오름차순 정렬이 필요함
	sort.Ints(nums)
	//
	//
	//
	// 2. 중앙값
	// nums의 length가 홀수이기 때문에 2로 나누면 항상 중앙 index 얻을 수 있음
	//
	// ex) nums = [1, 2, 3], len = 3
	// len / 2 = 3 / 2 = 1
	// nums[1] = 2 -> 중앙값
	median := nums[len(nums)/2]
	//
	//
	//
	// 3. 범위(출력은 4번째, 편의상 3번째로 구함)
	// 오름차순 정렬이 되어 있으므로
	// 가장 큰 수는 마지막 index
	// 가장 작은 수는 index 0에 위치
	rng := nums[len(nums)-1] - nums[0]
	//
	//
	//
	// 4. 최빈값
	// 아래의 GetMode() 함수 참조
	mode := GetMode(nums)
	//
	//
	//
	// =======================================
	// OUTPUT
	// =======================================
	fmt.Fprintln(w, avg)
	fmt.Fprintln(w, median)
	fmt.Fprintln(w, mode)
	fmt.Fprintln(w, rng)
}

// []int의 모든 원소의 합 구하는 함수
func Sum(nums []int) int {
	var sum int
	for _, n := range nums {
		sum += n
	}
	return sum
}

// 최빈값을 위한 구조체
// 자바, 파이썬 등의 class와 비슷한 개념
type Mode struct {
	Num, Count int
	// Num int
	// Count int
	//
	// go는 타입을 필드, 인자 이름 뒤에 기재하기 때문에,
	// 위와 같이 같은 타입인 경우 한 줄에 필드, 인자를 모으고
	// 맨 뒤에 한번만 타입을 기재할 수도 있다.
	//
	// 인자로 받는 경우 예시, 아래 두 코드도 같다
	// func(a int, b int) { ... }
	// func(a, b int) { ... }
}

// []int에서 가장 출현 빈도가 높은 최빈값(들) 구하는 함수
// Map<int, Mode> 통해 구현
func GetMode(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	// map[int]*Mode는
	// Java의 HashMap<int, Mode>와 비슷
	// *은 Mode가 Reference Type임을 의미
	var numsMap map[int]int
	var modes []*Mode

	numsMap = make(map[int]int)
	for _, n := range nums {
		// 1. numsMap에 n이 있는가
		_, ok := numsMap[n]
		// 2. 없는 경우 map에 새로운 key-value 초기화
		if !ok {
			// key - 수, value - 출현 빈도
			numsMap[n] = 1
		} else {
			// numsMap[n]은 *Mode 타입
			numsMap[n]++
		}
	}

	// numsMap -> []*Mode 변환 필요
	// key, value를 기반으로 *Mode 생성 -> modesSlice에 삽입
	for num, cnt := range numsMap {
		modes = append(modes, &Mode{
			Num:   num,
			Count: cnt,
		})
	}

	// sort modes
	sort.SliceStable(modes, func(i, j int) bool {
		a, b := modes[i], modes[j]

		// 1. Count가 같은 경우
		if a.Count == b.Count {
			// Num에 대한 오름차순 정렬
			//
			// [여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.]
			//
			// 라는 조건이 있기 때문에 두 번째로 작은 값을 구할 수 있게 하기 위함
			return a.Num < b.Num
		}
		// 2. Count에 대한 내림차순 정렬
		return a.Count > b.Count
	})

	m1, m2 := modes[0], modes[1]
	// 동일한 최빈값이 여러 개인 경우, 그 중 2번째로 작은 수 return
	if m1.Count == m2.Count {
		return m2.Num
	}
	// 최빈값인 수 return
	return m1.Num
}

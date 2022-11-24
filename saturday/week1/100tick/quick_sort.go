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
	// QUICK SORT
	// ================================
    QuickSort(nums)
   
	// ================================
	// PRINT nums
	// ================================
    wr := bufio.NewWriter(os.Stdout)
	defer wr.Flush()
	
    for _, n := range nums {
        fmt.Fprintf(wr, "%d\n", n)
	}
}

func QuickSort(nums []int) {
	if len(nums) < 1 {
		return
	}

	// 이전에 pivot이었던 index는 정렬이 완료되므로 다음 Sort에서 배제
	pivotIndex := partition(nums)

	// pivotIndex 이전 까지의 모든 요소 < pivotIndex > pivotIndex 이후의 모든 요소
	// 즉, pivotIndex 이전 까지의 모든 요소와 pivotIndex 이후의 모든 요소만 정렬
	QuickSort(nums[:pivotIndex])
	QuickSort(nums[pivotIndex+1:])

}

func partition(nums []int) int {
	// 첫번째 요소를 pivot으로 설정
	// pivot이 어떤 수가 될지는 모르나,

	// i는 1번 index부터 차례대로 1씩 증가하고
	// j는 마지막 index부터 차례대로 1씩 감소하며 순회할 때,

	// i로 조회한 요소 중 pivot보다 큰 수와,
	// j로 조회한 요소 중 pivot보다 작은 수를 서로 교환
	// 그리고 마지막에 i와 j가 만나는 index에서 순회를 종료하고
	// 해당 index와 pivot index를 교환하게 되면,
	// pivot 좌측의 모든 요소는 pivot보다 작은 수, 우측은 큰 수가 됨
	pivot := nums[0]
	i, j := 1, len(nums)-1

	// CASE 1.
	// [0,1,2,3,4,5,6,7,8,9,10]
	// 모든 수가 index 0의 pivot보다 크므로,
	// i는 1에서 절대로 증가하지 않는다.

	// continue j-- until the end of array
	// j는 index 9부터 0까지 감소하다가
	// for j > 0라는 제약 때문에 멈춘다
	// 즉, 마지막 값은 i = 1, j = 0이 된다.

	// i >= j이므로 pivot인 nums[0]과 nums[i-1]의 값을 바꾼다고 하면,
	// arr[0], arr[i-1] = arr[i-1], arr[0]
	// i = 1이므로, arr[0] = arr[0]
	// 즉, 변화가 없다.
	// 다만 index 0인 요소가 가장 작은 요소인 것은 확실하므로
	// 해당 index를 return하여 다음 Sort에서 배제하도록 한다.

	// CASE 2.
	// [10,1,2,3,4,5,6,7,8,9]
	// 모든 수가 pivot보다 작으므로,
	// i는 10까지 증가한다.
	// 따라서 마지막 값은 i = 10, j = 9가 된다.

	// nums[0], nums[10-1] = nums[10-1], nums[0]으로 스왑이 일어난다.
	// nums[0]은 10, nums[9]는 9이므로 최종 결과는
	// [9,1,2,3,4,5,6,7,8,10]이 된다.
	// 이 결과가 이상하게 보일 수도 있지만
	// 9가 맨 오른쪽에 있을 때와 달리
	// 10보다 큰 수는 좌측에 1개도 없다는 것이 보증된다는 차이가 있다.
	// 고로 해당 배열에서 좌측의 10 정렬이 어떻게 되던 간에
	// 정렬이 완료 된 후에도 10은 항상 저 위치에 놓이는 것이 확실할 것이다.

	// CASE 3.
	// [5,6,7,8,9,0,1,2,3,4]
	//
	// i = 1, j = 9
	// (6, 4) 교환 -> [5,(6),7,8,9,0,1,2,3,(4)]
	//
	// i = 2, j = 8
	// (7, 3) 교환 -> [5,4,(7),8,9,0,1,2,(3),6]
	//
	// i = 3, j = 7
	// (8, 2) 교환 -> [5,4,3,(8),9,0,1,(2),3,7]
	//
	// i = 4, j = 6
	// (9, 1) 교환 -> [5,4,3,2,(9),0,(1),8,3,7]
	//
	// i = 5, j = 5
	// [5,4,3,2,1,0,9,8,3,7]
	// i[5] == 0은 pivot == 5보다 작으므로
	// i++ -> i == 6
	// i[6]은 9이므로 stop
	// j-- -> j == 5
	// i >= j이므로 i[6-1]과 pivot 교환 후 return 6-1
	// nums[0], nums[5] 교환 -> [(5),4,3,2,1,(6),9,8,3,7]
	// sorted [0,4,3,2,1,(5),9,8,3,7]
	// [0:4] - pivot(5)보다 작거나 같음
	// [6:10] - pivot(5)보다 큼
	// return 5(index 5에 pivot 5가 있기 때문이며)
	// 해당 index는 정렬 완료

	// CASE 4.
	// [5,6,7,8,9,5,0,1,2,3,4]
	// [5,4,3,2,1,5,0,9,8,7,6]
	for {
		for i < len(nums) && nums[i] <= pivot {
			i++
		}
		for j > 0 && nums[j] > pivot {
			j--
		}

		if i >= j {
			nums[0], nums[i-1] = nums[i-1], nums[0]
			return i - 1
		}
		nums[i], nums[j] = nums[j], nums[i]
	}
}

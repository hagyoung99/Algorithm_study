// =======================================
//
// p11651 [좌표 정렬하기 2]
//
// [문제]
// 2차원 평면 위의 점 N개가 주어진다.
// 좌표를 y좌표가 증가하는 순으로,
// y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다.
// 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
// (-100,000 ≤ xi, yi ≤ 100,000)
// 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.
//
// [출력]
// 첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
//
// [https://www.acmicpc.net/problem/11651]
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

type Point struct {
	X, Y int
}

// 위와 같음
// go에서는 매개 변수, 구조체 필드 등에 같은 타입이 연속적으로 존재할 때,
// 타입을 맨 뒤에 1번만 명시할 수 있음
//
// ex)
// func Add(a int, b int) { ... }
// func Add(a, b int) { ... }
func main() {
	// 빠른 io를 위해 Reader, Writer 생성
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	// 모든 데이터를 write 한 뒤 Flsuh
	// defer
	defer w.Flush()

	// 점의 개수, N
	var N int
	fmt.Fscanln(r, &N)
	// (X, Y)를 구조체(class) value(instance) 형태로 저장할 Array
	points := make([]Point, N)
	// Point{ X, Y } 형태로 데이터를 저장
	// points는 []Point이므로,
	// Fscanf로 입력을 받아 points[i]의 X와 Y에 저장
	for i := 0; i < N; i++ {
		fmt.Fscanf(r, "%d %d\n", &points[i].X, &points[i].Y)
	}

	// =======================================
	// SORT
	// =======================================
	//
	// Slice SORT를 위해 sort 패키지의 SliceStable 함수 사용
	// 콜백 함수로 comparer 함수 작성
	//
	sort.SliceStable(points, func(i, j int) bool {
		p1, p2 := points[i], points[j]

		// 1. X가 같다면 Y에 대해 오름차순 정렬
		if p1.Y == p2.Y {
			return p1.X < p2.X
		}
		// 2. X가 다르면 X에 대해 오름차순 정렬
		return p1.Y < p2.Y
	})
	// =======================================
	// OUTPUT
	// =======================================
	for _, p := range points {
		fmt.Fprintln(w, p.X, p.Y)
	}
}

// =======================================
//
// p25305 [커트라인]
//
// [문제]
// 2022 연세대학교 미래캠퍼스 슬기로운 코딩생활에 N명의 학생들이 응시했다.
// 이들 중 점수가 가장 높은 k명은 상을 받을 것이다.
// 이 때, 상을 받는 커트라인이 몇 점인지 구하라.
// 커트라인이란 상을 받는 사람들 중 점수가 가장 가장 낮은 사람의 점수를 말한다.
//
// [입력]
// 첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
// 둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
//
// [출력]
// 상을 받는 커트라인을 출력하라.
//
// [제한]
// 1 <= N <= 1000
// 1 <= k <= N
// 0 <= x <= 10000
//
// [https://www.acmicpc.net/problem/25305]
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
	// =======================================
	// FOR FAST INPUT/OUTPUT
	// =======================================
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	// =======================================
	// INPUT
	// =======================================
	// N: 응시자 수
	// k: 수상자 수
	var N, k int
	fmt.Fscanf(r, "%d %d\n", &N, &k)

	// N명의 학생을 나타내는 int Slice(동적 배열), students 생성
	students := make([]int, N)
	// Fscanf로 입력을 받아 students[i]에 저장
	for i := 0; i < N; i++ {
		fmt.Fscanf(r, "%d", &students[i])
	}
	// =======================================
	// Sort
	// =======================================
	sort.Sort(sort.Reverse(sort.IntSlice(students)))
	// 조금 복잡해 보이지만 차근차근 살펴보면
	// sort.IntSlice(students)는 []int Slice 타입인 students를
	// IntSlice struct type으로 변환해주고,
	// Len, Less, Swap, Sort 등의 receiver func(method)를 attach 해준다.
	//
	// sort.Reverse()는 sort.Interface라는 인터페이스를 인자로 받으며,
	// sort.Interface는 Len(), Swap(), Less()를 implement 한 struct이다.
	// Go는 Duck Typing을 지원하는 언어이기 때문에,
	// Java 등의 타 언어에서 쓰이는 implements 구문을 따로 쓸 필요 없이,
	// 완전히 같은 이름, 시그니쳐를 가진 method들을 전부 갖고 있기만 하면
	// 이를 구현했다고 판단한다.
	//
	// 고로 students가 []int -> IntSlice로 변환하는 순간
	// students는 sort.Interface가 되는 것이다
	//
	//
	//
	// ----IntSlice는 []int의 alias type이며,
	// sort에 필요한 기본 method를 몇 개 구현했을 뿐이기에 지극히 단순, 이해하기 쉽다.
	// type IntSlice []int
	// func (x IntSlice) Len() int           { return len(x) }
	// func (x IntSlice) Less(i, j int) bool { return x[i] < x[j] }
	// func (x IntSlice) Swap(i, j int)      { x[i], x[j] = x[j], x[i] }
	// func (x IntSlice) Sort() { Sort(x) }
	// ...
	//
	//
	//
	//
	//
	// =======================================
	// OUTPUT
	// =======================================
	// 위에서 students는 내림차순으로 정렬된 상태
	// 상을 받는 인원은 k명이므로,
	// k-1 index에 위치한 사람이 커트라인이 될 것이다.
	// 해당 index에 접근하여 커트라인 점수를 출력하면 된다.
	fmt.Fprintln(w, students[k-1])
}

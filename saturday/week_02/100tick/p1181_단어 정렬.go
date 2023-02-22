// =======================================
//
// p1181 [단어 정렬]
//
// [문제]
// 알파벳 소문자로 이루어진 N개의 단어가 들어오면
// 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
// 1. 길이가 짧은 것부터
// 2.길이가 같으면 사전 순으로
//
// [입력]
// 첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000)
// 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
// 주어지는 문자열의 길이는 50을 넘지 않는다.
//
// [출력]
// 조건에 따라 정렬하여 단어들을 출력한다.
// 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
//
// [https://www.acmicpc.net/problem/1181]
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
	// N: 입력 받을 단어의 개수 (1 <= N <= 20000)
	var N int
	fmt.Fscanf(r, "%d\n", &N)

	// words: 입력 받을 N개의 단어를 저장할 string slice
	words := make([]string, 0)
	// wordsMap: 중복 숫자의 경우 1번만 출력하기 때문에
	// Map에 입력 받은 수를 저장하여 중복인 경우 words에 추가하지 않음
	wordsMap := make(map[string]bool)
	// Fscanf로 입력을 받아 words[i]에 저장
	for i := 0; i < N; i++ {
		var word string
		fmt.Fscanf(r, "%s\n", &word)

		// wordsMap에 해당 string이 들어 있는 경우
		// ok: true -> words slice에 추가 없이 다음 입력으로 넘어감
		// ok: false -> wordsMap에 해당 string 등록,
		// 그리고 words에 해당 string을 append
		if _, ok := wordsMap[word]; !ok {
			wordsMap[word] = true
			words = append(words, word)
		}
	}

	// =======================================
	// Sort
	// =======================================
	sort.Slice(words, func(i, j int) bool {
		a, b := words[i], words[j]
		// 1. 길이가 같으면 사전 순으로 정렬
		if len(a) == len(b) {
			return a < b
		}
		// 2. 길이에 대한 오름차순 정렬
		return len(a) < len(b)
	})

	// =======================================
	// OUTPUT
	// =======================================
	// 위에서 students는 내림차순으로 정렬된 상태
	// 상을 받는 인원은 k명이므로,
	// k-1 index에 위치한 사람이 커트라인이 될 것이다.
	// 해당 index에 접근하여 커트라인 점수를 출력하면 된다.
	for _, word := range words {
		fmt.Fprintln(w, word)
	}
}

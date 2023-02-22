// =======================================
//
// p10814 [나이순 정렬]
//
// [문제]
// 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다.
// 이때, 회원들을 나이가 증가하는 순으로,
// 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
//
// [입력]
// 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
// 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다.
// 나이는 1보다 크거나 같으며,
// 200보다 작거나 같은 정수이고,
// 이름은 알파벳 대소문자로 이루어져 있고,
// 길이가 100보다 작거나 같은 문자열이다.
// 입력은 가입한 순서로 주어진다.
//
// [출력]
// 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순,
// 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
//
// [https://www.acmicpc.net/problem/10814]
//
package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

// struct는 타 언어에서의 class와 비슷
type User struct {
	Age  int
	Name string
	// 가입 순서
	ID int
}

func main() {
	// =======================================
	// FOR FAST INPUT & OUTPUT
	// =======================================
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	// =======================================
	// INPUT
	// =======================================
	// N: 온라인 저지 회원 수
	var N int
	fmt.Fscanln(r, &N)

	// users: 길이 N인 []User
	users := make([]*User, N)
	for i := 0; i < N; i++ {
		// 새로운 User을 만들어 입력 받은 데이터를 바인딩 하고,
		// 해당 Value의 pointer를 users Slice에 저장
		var newUser User
		fmt.Fscanf(r, "%d %s\n", &newUser.Age, &newUser.Name)
		// 가입 순서에 따라 ID 발급
		newUser.ID = i
		users[i] = &newUser
	}

	// =======================================
	// SORT
	// =======================================
	sort.SliceStable(users, func(i, j int) bool {
		a, b := users[i], users[j]
		// 나이가 같으면 가입 순서 오름차순(ID)로 정렬
		if a.Age == b.Age {
			return a.ID < b.ID
		}
		// 나이 오름차순 정렬
		return a.Age < b.Age
	})
	// =======================================
	// OUTPUT
	// =======================================
	for _, u := range users {
		fmt.Fprintf(w, "%d %s\n", u.Age, u.Name)
	}
}

//
// 백준 p11650 [좌표 정렬하기]
//
// 2차원 평면 위의 점 N개가 주어진다.
// 좌표를 x좌표가 증가하는 순으로,
// x좌표가 같으면 y좌표가 증가하는 순서로
// 정렬한 다음 출력하는 프로그램을 작성하시오.
//
// https://www.acmicpc.net/problem/11650
//
//
//
#include <iostream>
#include <vector>
using namespace std;

// 커스텀 정렬 함수
// first가 같으면 second 오름차순 정렬
// first가 다르면 first 오름차순 정렬
bool cmp_pairs(pair<int, int> &p1, pair<int, int> &p2)
{
	if (p1.first == p2.first)
	{
		return p1.second < p2.second;
	}
	return p1.first < p2.first;
}

int main()
{
	// ========빠른 입출력 snippet=========
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	// ===============입력===============
	// N = 점의 갯수
	int N;
	cin >> N;

	// 	// ===============VECTOR===============
	// 	// 입력 받을 모든 수
	vector<pair<int, int>> V(N);
	// 	// ===============NUMBERS INPUT===============
	for (int i = 0; i < N; i++)
	{
		// 3 4
		// 1 1
		// ...
		// 한 줄에 공백으로 구분된 숫자 2개를
		// 각 배열 요소 pair<int, int의 first, second에 저장
		cin >> V[i].first >> V[i].second;
	}

	// 입력 받은 VECTOR 정렬
	// 위에 작성된 `cmp_pairs()`의 로직에 따라 정렬
	sort(V.begin(), V.end(), cmp_pairs);

	// ================출력=================
	for (auto p : V)
	{
		cout << p.first << " " << p.second << '\n';
	}

	return 0;
}
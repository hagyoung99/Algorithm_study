#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// compare pairs
// cmp라고 많이 축약해서 쓰는듯
bool cmp_pairs(pair<int, int> &p1, pair<int, int> &p2)
{
	// second에 대해 오름차순
	if (p1.second == p2.second)
	{
		// second가 같으면 first에 대해 오름차순
		return p1.first < p2.first;
	}
	return p1.second < p2.second;
}

int main()
{
	// ===============입력===============
	// N = 점의 갯수
	int N;
	cin >> N;

	// ===============PAIR===============
	// pair<int, int>는 그냥 int 변수 두 개를 저장할 수 있는
	// 배열 arr = [0,0]과 비슷하다고 보면 될듯
	// 다만 배열은 arr[0], arr[1]로 각 값을 가져올 수 있지만
	// pair은 pair.first, pair.second로 각 값을 가져와야함
	//
	// ===============VECTOR===============
	// vector은 동적 배열
	//
	// JAVA
	// var v = new Vector<Integer>();
	// v.add(1);
	//
	// JAVASCRIPT
	// const arr = [];
	// arr.push(1);
	//
	// C++
	// vector<int> v(size);
	// v.push_back(1);
	// ===============VECTOR===============

	// 즉, vector<pair<int, int>>는
	// int 2개를 가지는 pair의 동적 배열
	// 그리고 초기 길이는 N
	vector<pair<int, int>> V(N);

	// ===============POINTS INPUT===============
	for (int i = 0; i < N; i++)
	{
		// 입력 들어올 값
		// 0 4
		// 1 2
		// 1 -1
		// ...
		pair<int, int> p;
		// 0, 4를 받아서 pair에 넣어줌
		cin >> p.first >> p.second;
		V[i] = p;
	}
	// ===============POINTS INPUT===============

	// 정렬 기준
	// 4개의 pair (0, 4), (1, -1), (1, 2), (2, 2)가 있으면
	//
	// CASE 1.
	// 2번째 값이 작은 수부터 오름차순으로 정렬
	// (0, 4), (1 -1) -> (1, -1), (0, 4) 순
	//
	// CASE 2.
	// 2번째 값이 같은 경우, 1번째 값도 비교하여 오름차순으로 정렬
	// (1, 2), (2, 2) -> (1, 2), (2, 2) 순
	//

	// ===============SORT===============
	// sort 함수는 기본적으로 STL, C++ Standard Template Library에서
	// 제공하는 함수로, vector의 경우 v.begin(), v.end()로 sort 범위를 줘야 하며,
	//
	// sort(V.begin(), V.end());
	// 위와 같이 3번째 인자가 없는 경우, 인자로 들어온 vector의 범위만큼 오름차순 정렬되지만
	// 커스텀 비교 함수를 3번째 인자로 주면 그 로직에 의해 정렬됨
	sort(V.begin(), V.end(), cmp_pairs);

	// for (auto p : V) 반복문은
	// JAVASCRIPT에서 for (let elem in arr) {}
	// JAVA에서 for (var elem: arr) {}
	//
	// auto는 let, var과 같이 타입 추론
	// 즉 auto p는
	// pair<int, int> p와 같음
	// ===============PRINT OUT===============
	// cout << "ok\n";
	// System.out.println("ok");
	// console.log("ok");
	//
	// cout << "ok" << "no\n";
	// System.out.println("ok" + "no");
	// console.log("ok" + "no");
	for (auto p : V)
	{
		cout << p.first << " " << p.second << '\n';
	}
	return 0;
}

// ============================================
// PROBLEM INFO
// ============================================
//
// 백준 p1427 [소트인사이드]
//
// 배열을 정렬하는 것은 쉽다.
// 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
//
// https://www.acmicpc.net/problem/1427
//
// ============================================
// IMPORT LIBRARY, HEADERS
// ============================================
#include <iostream>
#include <vector>
using namespace std;

int main()
{
	// ============================================
	// [FAST INPUT, OUTPUT]
	// 편의를 위해 필요 없는 문제에도 일괄적으로 적용
	// ============================================
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	//
	//
	//
	// ============================================
	// [INPUT]
	// N = 1,000,000,000보다 작거나 같은 자연수
	// 4byte 이내므로 int에 저장
	// ============================================
	int N;
	cin >> N;
	//
	//
	//
	// ============================================
	// [VECTOR]
	// 입력 받은 숫자의 각 자리수를 저장
	// ============================================
	vector<int> V;
	//
	//
	//
	// ============================================
	// [MAIN LOGIC]
	// 입력 받은 숫자의 각 자리수를 저장
	// ============================================
	while (N > 0)
	{
		// 1.
		// N의 1의 자리를 unit에 저장
		// N = 123123 -> unit = 3
		int unit = N % 10;
		// 2.
		// N의 1의 자리 버림
		// N = 123123 -> 12312
		N = N / 10;
		// 3.
		// V에 unit 저장
		V.push_back(unit);
		// 4.
		// N = 123123 -> 12312 -> 1231 -> 123 -> 12 -> 1 -> 0
		// 과 같이 변화하여 최종적으로 0이 됨(int 간의 나눗셈이므로 자동으로 소숫점 아래를 버리기 때문)
		// while 문의 조건에 의해 0이 되는 순간 escape loop
	}
	//
	//
	//
	// ============================================
	// [SORT]
	// N의 모든 자리수를 저장하였으니
	// 그대로 문제에서 요구하는대로 내림차순 정렬
	// ============================================
	sort(V.begin(), V.end(), greater<int>());
	//
	//
	//
	// ============================================
	// [PRINT]
	// ============================================
	for (auto unit : V)
	{
		cout << unit;
	}

	return 0;
}
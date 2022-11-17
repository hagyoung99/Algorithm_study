#include <stdio.h>
#include <vector>
using namespace std;

int main()
{
	// 입력 받을 수의 갯수
	int N;
	scanf("%d", &N);

	// Counting Sort 배열
	// 가독성을 위해 index 0~10001 사용
	int nums[10001] = {
		0,
	};

	// 수 입력 받기. N회 만큼 반복
	for (int i = 0; i < N; i++)
	{
		int n;
		scanf("%d", &n);
		// n에 int를 입력 받은 후,
		// Counting Sort 배열에
		// 그 수가 저장된 갯수 + 1
		// eg) 10을 입력 받았다면 index 10에 + 1
		nums[n]++;
	}

	// ======== 출력 ========
	// 8M 메모리 제한 조건 때문에
	// 각 수를 index라 치고,
	// 각 index에 해당하는 받은 횟수 만큼 저장함
	//
	// 따라서 index를 기준으로 이미 정렬 완료
	int n = 1;
	// 최대 10000을 입력 받을 수 있었기 때문
	while (n < 10001)
	{
		// n이 0인 경우 다음 n으로 이동
		if (nums[n] == 0)
		{
			n++;
		}
		else
		{
			// n이 1 이상인 경우 해당 수 출력,
			// 그리고 값을 하나 줄여줌
			printf("%d\n", n);
			nums[n]--;
		}
	}
	return 0;
}
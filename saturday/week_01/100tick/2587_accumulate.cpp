#include <stdio.h>
#include <numeric>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	vector<int> nums(5);

	for (int i = 0; i < 5; i++)
	{
		scanf("%d", &nums[i]);
	}

	int sum = accumulate(nums.begin(), nums.end(), 0);
	sort(nums.begin(), nums.end());

	printf("%d\n%d\n", sum / 5, nums[2]);
}
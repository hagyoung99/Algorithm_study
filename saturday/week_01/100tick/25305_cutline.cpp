#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int N, k;
	cin >> N >> k;
	vector<int> students(N, 0);
	for (int i = 0; i < N; i++)
	{
		cin >> students[i];
	}

	sort(students.begin(), students.end(), greater<int>());
	students.erase(students.begin() + k - 1, students.end());

	cout << *students.end() << '\n';
}
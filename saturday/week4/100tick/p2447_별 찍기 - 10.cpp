#include <iostream>
#include <vector>

using namespace std;

void draw_rect(vector<vector<char>> &arr, int y_start, int x_start, int length)
{
	int third = length / 3;

	for (int y = y_start + third; y < y_start + third * 2; y++)
	{
		for (int x = x_start + third; x < x_start + third * 2; x++)
			arr[y][x] = ' ';
	}

	if (length == 3)
		return;

	for (int y = y_start; y < y_start + length; y += third)
	{
		for (int x = x_start; x < x_start + length; x += third)
		{
			if (arr[y][x] != ' ')
			{
				draw_rect(arr, y, x, third);
			}
		}
	}
}

int main()
{
	int LENGTH;
	cin >> LENGTH;
	vector<char> X(LENGTH + 1, '*');
	vector<vector<char>> ARR(LENGTH + 1, X);

	draw_rect(ARR, 1, 1, LENGTH);

	for (int y = 1; y <= LENGTH; y++)
	{
		for (int x = 1; x <= LENGTH; x++)
		{
			cout << ARR[y][x];
		}
		cout << '\n';
	}
	return 0;
}

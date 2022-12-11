#include <iostream>
#include <vector>
#include <map>

using namespace std;

int N, M;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> N >> M;

	map<string, int> name_map;
	vector<string> name_vec(N + 1);
	for (int i = 1; i <= N; i++)
	{
		string name;
		cin >> name;

		name_map[name] = i;
		name_vec[i] = name;
	}

	for (int i = 0; i < M; i++)
	{
		string q;
		cin >> q;
		if (isalpha(q[0]))
		{
			cout << name_map[q] << '\n';
		}
		else
		{
			int idx = atoi(q.c_str());
			cout << name_vec[idx] << '\n';
		}
	}

	return 0;
}

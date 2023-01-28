//백준 15651번
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int arr[7] = { 0, };

void BackTracking(int n, int m, int d) //변수 d는 수열을 만들 때 배열 속 인자를 담당 
{
    int i = 0;
    int k = 0; //배열 출력할 변수
    i = 1; //수열의 시작은 1부터
    while (i <= n)//수열의 시작 숫자가 1씩 커지는 반복문
    {
        arr[d] = i; // 수열을 생성하는 과정. 배열 안에 저장하고 나중에 출력할 예정.
        // d는 배열의 인자를 의미. 즉 0부터 시작.
        //하나의 수열은 m개의 숫자로 이루어져 있으니 현재 배열의 인자가 m-1인지 아닌지 확인
        if (m - 1 == d) //하나의 수열이 완성됨.
        {
            k = 0;
            while (k < m) //한 수열은 m개의 수로 이루어짐
            {
                printf("%d ", arr[k]);
                k++;
            }
            printf("\n");
        }
        else //하나의 수열이 완성되지 않음.
        {
            BackTracking(n, m, d + 1);
        }
        i++;
    }
}

int main()
{
    int n, m;
    scanf("%d %d", &n, &m);
    BackTracking(n, m, 0);
}

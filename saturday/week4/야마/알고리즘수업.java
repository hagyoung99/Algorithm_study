import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

static int[] A, tmp;
static int count = 0;
static int result = -1;
static int K;

public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N = Integer.parseInt(st.nextToken()); //n길이 배열
	K = Integer.parseInt(st.nextToken()); 	  //K번 병합병렬
	
	st = new StringTokenizer(br.readLine());
	
	A = new int[N]; //N길이의 배열
	for(int i = 0; i < N; i++) {
		A[i] = Integer.parseInt(st.nextToken()); //N길이의 배열에 값을 넣는다.
	}
	tmp = new int[N];			 //N길이의 임시배열
	merge_sort(A, 0, N - 1);	 //병합정렬할 함수호출
	System.out.println(result);  //출력
	
}
// 위 병합 정렬내용 참고 
public static void merge_sort(int[] A, int p, int r) {//A배열 , 0 , 마지막인덱스
	if (count > K) return ; 	// K가 음수면 리턴
	if (p < r) {			 	// p는 정렬할 인덱스 , r은 마지막 인덱스
		int q = (p + r) / 2; 	// 0+마지막 /2 == 중간
		merge_sort(A, p, q); 	// A배열,0,중간 
		merge_sort(A, q + 1, r); //A배열,중간+1,마지막
		merge(A, p, q, r);		//A배열,0,중간,마지막
	}
}

public static void merge(int[] A, int p, int q, int r) {
	int i = p;				//0인덱스
	int j = q + 1;			//중간+1
	int t = 0;
	
	while (i <= q && j <= r) {
		if(A[i] <= A[j]) {  //i번째가  j보다 크거나 작으면
			tmp[t] = A[i];  //임시 배열에 넣어준다.
			i++;			//다음 인덱스 정렬
		}else {				//i가 더 크다면
			tmp[t] = A[j];  //j가 더 작으므로 t번째에 넣어준다.
			j++;			//j 다음 탐색
		}
		t++; 정렬을 마치면 다음 인덱스 탐색
	}
	
	while (i <= q) {  //왼쪽배열부분남 음 
		tmp[t++] = A[i++];
	}	
	while (j <= r) { //오른쪽배열부분이 남은경우
		tmp[t++] = A[j++];
	}
	i = p;
	t = 0;
	while (i <= r) { 
		count++;    //0~마지막 인덱스 
		if (count == K) { // K번째 카운트값 찾기
			result = tmp[t]; 
			break;
		} 
		A[i++] = tmp[t++]; //다시 A배열에 넣어준다.
	}
}
}



// 이분탐색 O(log n) : 정렬되어 있는 배열을 이분화하면서 탐색하는 기법
// 조건 -> 반드시 배열이 정렬되어 있는 상태에서!

// 필요 변수
// 왼쪽 포인터&오른쪽 포인터

const arr = [5,99,80,1,13];
const target = 13;

arr.sort((a,b)=>a-b);
let lt=0;
let rt=arr.length-1;
let answer =0

while(lt<=rt){
    let mid = parseInt((lt+rt)/2);

    if(arr[mid]===target){
        answer = mid+1;
        break;
    } else if(arr[mid]>target) rt = mid-1;
    else {lt = mid + 1;}
}

console.log(answer);


/* 
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

=> 문제 이해가 잘 안 갔는데 여튼 자기보다 작은 숫자가 몇 개인지 판단하면 될 것 같다!

[입력]
5
2 4 -10 4 -9

[출력]
2 3 0 3 1
*/

const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = "5 \n2 4 -10 4 -9".toString().trim().split('\n');

const arr = input[1].split(" ").map(a => Number(a));  // [2, 4, -10, 4, -9]
const resultArr = [];

let setArr = new Set(arr);
setArr = [...setArr].sort((a,b) => a-b);  // [-10, -9, 2, 4]

// 이분 탐색 구현
const binarySearch = function (arr, target) {
    let start = 0;
    let end = arr.length-1
    let mid
    
    while(start<=end){
    mid = parseInt((start+end)/2)
    
    if(target === arr[mid]){
      return mid;
    } else{
      if(target<arr[mid]){
        end = mid-1
      }
      else{
        start = mid+1
      }
    }
    }
    return -1
  };

arr.forEach(element => {
    resultArr.push(binarySearch(setArr, element));
    /* 
    resultArr.push(setArr.indexOf(element));  // 시간초과로 실패..
    indexOf() 메서드의 최적 시간복잡도는 B(n)
    이분 탐색의 시간복잡도는 B(logN)!!
     
    */
});

console.log(resultArr.join(" "));

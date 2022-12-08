/* 
[입력]
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 
나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

[출력]
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력
*/

/*
[input]             [output]
3                   20 Sunyoung
21 Junkyu           21 Junkyu
21 Dohyun           21 Dohyun
20 Sunyoung
*/

const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// const input = [
//     3,
//     "21 Junkyu",   
//     "21 Dohyun",
//     "20 Sunyoung"];

input.shift();
// ["21 Junkyu", "21 Dohyun", "20 Sunyoung"]

input.sort((a, b) => parseFloat(a) - parseFloat(b));
// praseInt parseFloat => 문자를 분석하여 정수 부분만 반환해준다!

console.log(input.join("\n"));





/* 

const inputSplit = [];

나이와 이름을 분리! 이중 배열 생성
for(let i=0; i<input.length; i++){
    inputSplit.push(input[i].split(" "));
    }

버블 정렬의 배신
시간 초과 떴다.. 하지만 삽입 정렬이나 병합 정렬 구현하기 귀찮아서 일단 js 기능을 활용해본다.
let noSwaps;
for (let i = inputSplit.length; i > 0; i--) {
    noSwaps = true;
    for (let j = 0; j < i - 1; j++) {
      if (inputSplit[j][0] > inputSplit[j+1][0]) {
          let temp = inputSplit[j];
          inputSplit[j] = inputSplit[j+1];
          inputSplit[j+1] = temp;
          noSwaps = false;
                   
       }
    }
  if (noSwaps) break;
 }

출력 형식 맞추기 위해 다듬는 중..
const answerArr = [];
for(let i=0; i<inputSplit.length; i++){
answerArr.push(inputSplit[i].flat().join(" "));
}
*/
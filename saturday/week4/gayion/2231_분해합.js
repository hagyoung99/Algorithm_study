const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString();
 
const N = parseInt(input);  // N의 가장 작은 생성자를 구해보자! N = M + M의 각자릿수 값
let M = 0

for(let i = 0; i < N; i++) {  // i < N-(N.length*9);
  //각 자리수와 후보값의 합
  let sum = 0;
 
  // 0부터 시작하는 후보값
  const candidateValue = i;
 
  //각 자리수를 구하기 위해서 숫자를 string으로 변환
  const stringValue = candidateValue.toString()
 
  for(let j = 0; j < stringValue.length; j++) {  123
    sum += parseInt(stringValue[j])
  }
 
  sum += candidateValue;
 
  if(sum == N) {
    M = candidateValue
    break;
  }
}
 
console.log(M);

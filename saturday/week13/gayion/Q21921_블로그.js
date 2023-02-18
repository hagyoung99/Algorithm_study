// const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const input = "7 5\n1 1 1 1 1 5 1".split('\n');
/* 
Input
7 5
1 1 1 1 1 5 1

Output
9
2

□ ■ ■ ■ □
□ □ ■ ■ ■ 
*/
const [N, X] = input[0].split(' ').map(Number);
const nums = input[1].split(' ').map(Number);

let acc = nums.reduce((acc, v, i) => (i < X ? acc + v : acc), 0); // 누산기/현재값/현재인덱스
let count = 0;
let max = 0;

for (let i = 0; i <= N - X; i++) {
  if (i > 0) {
    acc -= nums[i - 1];
    acc += nums[i + X - 1];
  }        

  if (max < acc) {
    // i=0인 경우 혹은 저장되었던 max 값보다 acc 값이 클 경우
    max = acc;
    count = 1;
  } else if (max === acc) {
    count += 1;
  }
}

if (max > 0) {
  console.log(max);
  console.log(count);
} else {
  console.log('SAD');
}
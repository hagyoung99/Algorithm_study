const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let input = [];
let count = 0;
let day = 0;
let n = 0;

rl.on('line', function (line) {
  if (!count) {
    n = +line.split(' ')[0];
    day = +line.split(' ')[1];
  } else {
    input = line.split(' ').map(e => +e);
  }
  count++;
}).on('close', function () {
  solution(input, day, n);
  process.exit();
});

const solution = (input, day, n) => {
  // i 와 sum 정의
  let i = 0;
  let sum = 0;
  // 처음부터 day 전 까지의 수를 한번만 더해줌 = sum 초기값 정의
  for (let k = 0; k < day; k++) {
    sum += input[k];
  }
  let max = sum;
  // for루프로 j= day / n까지 반복
  for (let j = day; j < n; j++) {
    // sum+=input[j] 뒤에걸 더해주고
    sum += input[j];
    // sum-=inpit[i++] 앞에걸 빼줌
    sum -= input[i++];
    // max값 배정
    max = Math.max(max, sum);
  }
  // max리턴
  console.log(max);
};
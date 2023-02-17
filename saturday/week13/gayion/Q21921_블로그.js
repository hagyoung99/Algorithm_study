const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, X] = input[0].split(' ').map(Number);
const nums = input[1].split(' ').map(Number);

let acc = nums.reduce((acc, v, i) => (i < X ? acc + v : acc), 0);
let count = 0;
let max = 0;

for (let i = 0; i <= N - X; i++) {
  if (i > 0) {
    acc -= nums[i - 1];
    acc += nums[i + X - 1];
  }
  if (max < acc) {
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
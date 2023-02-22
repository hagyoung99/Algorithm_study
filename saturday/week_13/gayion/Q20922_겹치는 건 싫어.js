const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [[N, K], arr] = input.map(v => v.split(' ').map(Number));

const intMap = {};
let maxLength = 0;
let i = 0;
let j = 0;

while (i <= j && j < N) {
  while (intMap[arr[j]] === K) {
    intMap[arr[i]]--;
    i++;
  }
  maxLength = Math.max(maxLength, j - i + 1);
  intMap[arr[j]] = (intMap[arr[j]] ?? 0) + 1;
  j++;
}

console.log(maxLength);
const [[N, K], dolls] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n').map(v => v.split(' ').map(Number));

let count = 0;
let minCount = Infinity;
let i = 0;
let j = 0;

while (j < N) {
  if (dolls[j] === 1) {
    count++;
  }

  while (count === K) {
    if (dolls[i] === 1) {
      count--;
    }
    minCount = Math.min(minCount, j - i + 1);
    i++;
  }

  j++;
}

console.log(minCount === Infinity ? -1 : minCount);
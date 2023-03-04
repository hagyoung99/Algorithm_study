const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const N = Number(input[0].split(' ')[0]);
const M = Number(input[0].split(' ')[1]);

const ranks = [];
const scores = [];
for (let i = 1; i < N + 1; i++) {
  ranks.push(input[i].split(' ')[0]);
  scores.push(Number(input[i].split(' ')[1]));
}

const answer = [];
const binarySearch = (x) => {
  let left = 0;
  let right = N;

  while (left < right) {
    let mid = Math.floor((left + right) / 2);
    if (x > scores[mid]) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return ranks[left];
};

for (let i = N + 1; i < N + M + 1; i++) {
  answer.push(binarySearch(Number(input[i])));
}
console.log(answer.join('\n'));

const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

// 분할 정복법 사용
const N = Number(input[0]);
const data = input[1].split(' ').map(Number);

const solution = (N, data) => {
  const answer = Array.from(Array(N), () => new Array());
  const divide = (start, end, depth) => {
    if (depth === N) return;
    const mid = Math.floor((start + end) / 2);
    answer[depth].push(data[mid]);
    divide(start, mid - 1, depth + 1);
    divide(mid + 1, end, depth + 1);
  };
  divide(0, data.length, 0);
  return answer.map((v) => v.join(' ')).join('\n');
};

console.log(solution(N, data));
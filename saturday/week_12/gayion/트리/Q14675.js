const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const N = Number(input[0]);
const data = input.slice(1, N);
const q = input.slice(N + 1);

const solution = (N, data, q) => {
  const nodes = Array.from(Array(N + 1), () => new Array());
  data.forEach((v) => {
    const [n1, n2] = v.split(' ').map(Number);
    nodes[n1].push(n2);
    nodes[n2].push(n1);
  });
  let answer = '';
  q.forEach((qq) => {
    const [t, k] = qq.split(' ').map(Number);
    if (t === 1) {
      answer += nodes[k].length > 1 ? 'yes\n' : 'no\n';
    } else if (t === 2) {
      answer += 'yes\n';
    }
  });
  return answer;
};

console.log(solution(N, data, q));
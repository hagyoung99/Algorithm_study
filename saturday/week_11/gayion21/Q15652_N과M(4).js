const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map(nm => parseInt(nm));

const N = input.shift();
const M = input.shift();
const visited = new Array(N);
const output = [];
let result = '';

function dfs(idx, cnt) {
  if (cnt === M) {
    result += `${output.join(' ')}\n`;
    return;
  }

  for (let i = idx; i < N; i++) {
    output.push(i + 1);
    dfs(i, output.length);
    output.pop();
  }
}

dfs(0, 0);
console.log(result);
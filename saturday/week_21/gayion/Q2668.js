const fs = require('fs');
const PATH =
  process.platform === 'linux' ? '/dev/stdin' : './baekjon/input.txt';

const input = fs.readFileSync(PATH).toString().trim().split('\n');

const n = +input[0];    // 정수 n개
const arr = new Array(n + 1).fill(0);   // 인덱스 0부터라 +1해서 만들기~
const visited = new Array(n + 1).fill(false);
const finished = new Array(n + 1).fill(false);
const result = [];
let count = 0;

for (let i = 1; i <= n; i++) {
  arr[i] = +input[i];   // 차곡차곡 주어진 숫자 변수에 입력받기
}

for (let i = 1; i <= n; i++) {
  if (!visited[i]) {
    dfs(i, arr, visited, finished, result);
  }
}
result.sort((a, b) => a - b);
console.log(result.length);
result.forEach((i) => console.log(i));

function dfs(x, arr, visited, finished, result) {
  visited[x] = true;
  let child = arr[x];
  if (!visited[child]) dfs(child, arr, visited, finished, result);
  else if (!finished[child]) {
    while (child !== x) {
      result.push(child);
      child = arr[child];
    }
    result.push(x);
  }

  finished[x] = true;
}s
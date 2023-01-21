let input = require('fs').readFileSync('/dev/stdin').toString().trim().split(' ').map(e => +e);
let [n,m] = [...input];

const solution = (n, m) => {
  let answer = [];
  let tmp = new Array(m).fill(0);
  function dfs(L, s) { // 반복문에 사용할 s(start)변수
    if (L === m) {
      answer.push(tmp.join(" "));
    } else {
      for (let i = s; i <= n; i++) {
        tmp[L] = i;
        dfs(L + 1, i + 1);
      }
    }
  }
  dfs(0, 1);
  return answer.join("\n");
};

console.log(solution(n,m));
const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const solution = (input) => {
  const [n, m, start] = input.shift().split(" ").map(Number);

  const graph = Array.from(Array(n + 1), () => []);
  const visited = new Array(n + 1).fill(false);
  for (let str of input) {
    const [x, y] = str.split(" ");
    graph[x].push(y);
    graph[y].push(x);
  }

  graph.forEach((e) => e.sort((a, b) => a - b));
  let cnt = 1;
  const answer = new Array(n).fill(0);
  const dfs = (cur) => {
    visited[cur] = true;
    answer[cur - 1] = cnt++;
    for (let next of graph[cur]) {
      if (visited[next]) continue;

      dfs(+next);
    }
  };

  dfs(start);

  return answer.join("\n");
};
console.log(solution(input));
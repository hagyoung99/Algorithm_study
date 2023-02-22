const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input.shift();
const tree = Array.from({ length: N + 1 }, () => new Array());
input.forEach((node) => {
  const [start, end] = node.split(" ").map(Number);
  tree[start].push(end);
  tree[end].push(start);
});

let check = Array.from({ length: N + 1 }, () => 0);
function bfs() {
  const queue = [];
  check[1] = 1;

  for (let next of tree[1]) {
    check[next] = 1;
    queue.push(next);
  }

  while (queue.length) {
    const node = queue.shift();
    for (let next of tree[node]) {
      if (check[next]) continue;
      check[next] = node;
      queue.push(next);
    }
  }
}
bfs();

let result = "";
check = check.slice(2);
check.forEach((c) => (result += `${c}\n`));
console.log(result);

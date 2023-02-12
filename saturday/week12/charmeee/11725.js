let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');const N = +input.shift();
const edges = input.map(v => v.split(' ').map(Number));
const tree = [...Array(N + 1)].map(() => []);
const relations = [];
edges.forEach(([a, b]) => {
  tree[a].push(b);
  tree[b].push(a);
});

const bfs = () => {
  const visited = Array(N + 1).fill(false);
  visited[1] = true;
  let queue = [1];
  let stack;
  while (queue.length) {
    stack = queue;
    queue = [];
    while (stack.length) {
      const node = stack.pop();
      const children = tree[node];
      if (children) {
        children.forEach(child => {
          if (!visited[child]) {
            visited[child] = true;
            relations[child] = node;
            queue.push(child);
          }
        });
      }
    }
  }
};

bfs();
console.log(relations.slice(2).join('\n'));
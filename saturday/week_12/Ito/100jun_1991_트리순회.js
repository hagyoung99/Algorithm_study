const fs = require('fs');

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = input.shift();
const nodes = input.map((n) => n.split(" "));

const tree = {};

nodes.forEach(([node, left, right]) => {
  tree[node] = [left, right];
});

let result = "";

function preorder(node) {
  if (node === ".") return;
  const [lt, rt] = tree[node];
  result += node;
  preorder(lt);
  preorder(rt);
}

function inorder(node) {
  if (node === ".") return;
  const [lt, rt] = tree[node];
  inorder(lt);
  result += node;
  inorder(rt);
}

function postorder(node) {
  if (node === ".") return;
  const [lt, rt] = tree[node];
  postorder(lt);
  postorder(rt);
  result += node;
}

preorder("A");
result += "\n";
inorder("A");
result += "\n";
postorder("A");

console.log(result);

const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, M] = input.shift().split(" ");
const makeArr = (arr) =>
  arr
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
const A = makeArr(input.shift());
const B = makeArr(input.shift());

let i = 0;
let j = 0;
let k = 0;
const result = [];

while (i < N && j < M) {
  if (A[i] > B[j]) result[k++] = B[j++];
  else result[k++] = A[i++];
}

while (i < N) result[k++] = A[i++];
while (j < M) result[k++] = B[j++];

console.log(result.join(" "));

// 1 --------------------------------------------------
// const input = read.toString().trim().split("\n");

// const [N, M] = input.shift().split(" ");
// const A = input.shift().split(" ").map(Number);
// const B = input.shift().split(" ").map(Number);

// console.log([...A, ...B].sort((a, b) => a - b).join(" "));

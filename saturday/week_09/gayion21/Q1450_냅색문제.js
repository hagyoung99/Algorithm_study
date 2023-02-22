let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
/*
2 2
1 1

4
*/


const [N, C] = input[0].split(" ").map(Number);
let weights = input[1].split(" ").map(Number);
const weightA = weights.slice(0, parseInt(weights.length / 2));
const weightB = weights.slice(parseInt(weights.length / 2));
let sumA = [];
let sumB = [];

function DFS(arr, sumArr, idx, sum) {
  if (idx >= arr.length) {
    sumArr.push(sum);
    return;
  }

  DFS(arr, sumArr, idx + 1, sum);
  DFS(arr, sumArr, idx + 1, sum + arr[idx]);
}

function binarySearch(arr, target, start, end) {
  while (start < end) {
    let mid = parseInt((start + end) / 2);
    if (arr[mid] <= target) {
      start = mid + 1;
    } else {
      end = mid;
    }
  }
  return end;
}

DFS(weightA, sumA, 0, 0);
DFS(weightB, sumB, 0, 0);
sumB.sort((a, b) => a - b);

let cnt = 0;

for (let item of sumA) {
  if (C - item < 0) {
    continue;
  }

  cnt += binarySearch(sumB, C - item, 0, sumB.length);
}

console.log(cnt);
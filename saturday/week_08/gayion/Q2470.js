const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let n = Number(input[0]);
let arr = new Array(n);
arr = input[1].split(" ").map(Number);
arr.sort((a, b) => a - b);

let left = 0;
let right = n - 1;
let sum = 0;
let ans = Infinity;
let ans_pair = new Array(2).fill(0);
while (left !== right) {
  sum = arr[left] + arr[right];
  if (Math.abs(sum) < ans) {
    ans = Math.abs(sum);
    ans_pair[0] = arr[left];
    ans_pair[1] = arr[right];
  }
  if (sum === 0) {
    break;
  } else if (sum > 0) {
    right--;
  } else if (sum < 0) {
    left++;
  }
}
console.log(ans_pair.join(" "));
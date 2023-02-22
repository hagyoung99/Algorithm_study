const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");

const N = +input.shift()
const target = +input.pop();
const nums = input[0].split(' ').map((v, i) => +v).sort((a, b) => a - b)
const kill = nums.length;

let start = 0;
let end = kill - 1;
let answer = 0;
while (start != end) {
  if (nums[start] + nums[end] == target) {
    answer++;
    start++;
  } else if (nums[start] + nums[end] > target) {
    end--;
  } else {
    start++;
  }
}
console.log(answer)
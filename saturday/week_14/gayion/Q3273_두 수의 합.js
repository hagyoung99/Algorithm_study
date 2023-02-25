const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split("\n");

const N = +input.shift()
const target = +input.pop();
const nums = input[0].split(' ').map((v) => +v).sort((a, b) => a - b);

let start = 0;
let end = nums.length - 1;
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
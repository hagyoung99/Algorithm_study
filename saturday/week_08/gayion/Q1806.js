const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let n = Number(input[0].split(" ")[0]);
let m = Number(input[0].split(" ")[1]);
let left = (right = sum = 0);
let ans = Infinity;
let arr = input[1].split(" ").map(Number);
while (left <= right) {
  if (sum >= m) {
    ans = Math.min(ans, right - left);
    sum -= arr[left];
    left++;
  } else if (right == n) break;
  else {
    sum += arr[right];
    right++;
  }
}
if (ans !== Infinity) console.log(ans);
else console.log(0);
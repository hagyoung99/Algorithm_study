const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = +input.shift();
const M = +input.shift();
const numbers = input[0]
  .split(" ")
  .map(Number)
  .sort((a, b) => a - b);

let count = 0;

function counting(s, e) {
  let sum = numbers[s] + numbers[e];

  if (sum === M) {
    count++;
    s++;
    e--;
  } else if (sum < M) {
    s++;
  } else {
    e--;
  }

  if (s >= e) return;
  counting(s, e);
}

counting(0, numbers.length - 1);

console.log(count);

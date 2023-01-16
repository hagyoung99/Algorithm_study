let fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let [n, k] = input.shift().split(' ').map((a) => +a);
let lines = input.map((a) => +a).sort();
let max = Math.max(...lines);
let min = 1;

while (min <= max) {
  let mid = parseInt((max + min) / 2);
  let cnt = lines.map((line) => parseInt(line / mid)).reduce((a, b) => a + b, 0);
  if (cnt >= k) {
    min = mid + 1;
  } else {
    max = mid - 1;
  }
}
console.log(max);
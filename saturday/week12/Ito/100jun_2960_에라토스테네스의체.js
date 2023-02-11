const fs = require("fs");

const [n, k] = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);

const arr = [];
for (let i = 2; i <= n; i++) arr.push(i);

let count = 0;
let prime, nth;

while (count < k) {
  prime = arr[0];
  arr.some((v) => {
    if (v % prime === 0) {
      arr.splice(arr.indexOf(v), 1);
      nth = v;
      count++;
    }
    if (count === k) return true;
  });
}
console.log(nth);

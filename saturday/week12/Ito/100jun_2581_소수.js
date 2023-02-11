const fs = require("fs");

const [m, n] = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(Number);

let sum = 0;
let min = 0;

function isPrime(n) {
  if (n < 2) return;

  for (let i = 2; i < n; i++) {
    if (n !== i && n % i === 0) return;
  }

  sum += n;
  if (!min) min = n;
}

for (let i = m; i <= n; i++) {
  isPrime(i);
}

if (sum) {
  console.log(sum);
  console.log(min);
} else {
  console.log(-1);
}

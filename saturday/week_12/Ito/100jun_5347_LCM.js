const fs = require('fs');

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const n = input.shift();

for (const numbers of input) {
  const [n1, n2] = numbers.split(" ").map(Number);
  solution(n1, n2);
}

function solution(n1, n2) {
  const g = gcd(n1, n2);
  console.log((n1 * n2) / g);
}

function gcd(a, b) {
  while (b > 0) {
    let temp = a;
    a = b;
    b = temp % b;
  }
  return a;
}


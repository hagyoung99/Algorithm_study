const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

let n = Number(input[0]);
// 에라토스테네스의 체
let primes = [];
let check = new Array(n + 1).fill(true);
for (let i = 2; i * i <= n; i++) {
  if (!check[i]) continue;
  for (let j = i * i; j <= n; j += i) {
    check[j] = false;
  }
}
for (let i = 2; i <= n; i++) {
  if (check[i]) primes.push(i);
}

// 투포인터 탐색
let left = (sum = cnt = 0);
for (let right = 0; right < primes.length; right++) {
  sum += primes[right];
  while (sum > n) {
    sum -= primes[left];
    left++;
  }
  if (sum === n) cnt++;
}
console.log(cnt);
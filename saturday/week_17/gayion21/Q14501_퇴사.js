let [n, ...arr] = require("fs").readFileSync("input.txt").toString().split("\n")
                  .map((v) => v.split(" ").map((v) => +v)); //.map((v) => Number(v)

n = n[0];
const dp = new Array(n).fill(0);

for (let i = 0; i < n; i++) { // 0일~6일
  const [duration, profit] = arr[i];
  if (i + duration > n) continue; // 현재 날짜 + 기간이 n이 넘으면 상담 불가
  dp[i] += profit;
  // console.log(dp);
  for (let j = i + duration; j < n; j++) {
    // console.log(dp[j], dp[i]);
    dp[j] = Math.max(dp[j], dp[i]); // 현재 금액, i일 뒤에 받게 될 금액 비교
  }
}
console.log(Math.max(...dp));
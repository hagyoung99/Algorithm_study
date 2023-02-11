const fs = require("fs");

const [t, ...n] = fs.readFileSync("/dev/stdin").split("\n");

function gcd(n1, n2) {
  let max = n1 > n2 ? n1 : n2;
  let min = n1 < n2 ? n1 : n2;

  let temp;
  while (min) {
    temp = max % min;
    max = min;
    min = temp;
  }
  return max;
}

for (const tests of n) {
  const [c, ...test] = tests.split(" ").map((v) => +v);

  let result = 0;
  for (let i = 0; i < c; i++) {
    for (let j = i + 1; j < c; j++) {
      temp = gcd(test[i], test[j]);
      result += temp;
    }
  }
  console.log(result);
}

const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, K] = input[0].split(" ").map(Number);
const arr = input[1].split(" ").map(Number);

let s = 0;
let e = 0;
let count = 0;
let max = 0;
const map = {};

for (let i = 0; i < N; i++) {
  const arrEnd = arr[e];

  if (!map[arrEnd]) {
    if (N <= e) {
      // 1. map에 해당 숫자가 없고 end가 요소 개수(N)를 벗어남
      map[arr[s]] -= 1;
      count -= 1;
      s += 1;
    } else {
      // 2. map에 해당 숫자가 없고 end가 요소 개수(N)이내에 있음
      map[arrEnd] = 1;
      count += 1;
      e += 1;
      if (s < N) i -= 1;
    }
  } else {
    const next = map[arrEnd] + 1;

    if (next <= K) {
      if (N <= e) {
        // 3. map에 요소가 존재하고 중복 개수 기준(end + 1 < K)을 넘지 않고
        // end가 요소 개수(N)을 벗어남
        map[arr[s]] -= 1;
        count -= 1;
        s += 1;
        i -= 1;
      } else {
        // 4. map에 요소가 존재하고 중복 개수 기준(end + 1 < K)을 넘지 않고
        // end가 요소 개수(N)을 벗어나지 않음
        map[arrEnd] += 1;
        count += 1;
        e += 1;
      }
    } else {
      // 5. map에 요소가 존재하고 중복 개수 기준(end + 1 > K)을 넘음
      map[arr[s]] -= 1;
      count -= 1;
      s += 1;
      i -= 1;
    }
  }

  max = Math.max(max, count);
}

console.log(max);

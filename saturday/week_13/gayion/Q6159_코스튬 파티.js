const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const solution = () => {
  const [N, S] = input.shift().split(" ").map(Number);
  const arr = [...input].map(Number).sort((a, b) => a - b);

  let cnt = 0;

  for (let start = 0; start < N - 1; start++) {
    let end = start + 1;

    while (true) {
      const sum = arr[start] + arr[end];
      if (end >= N || sum > S) break;
      cnt += 1;
      end += 1;
    }
  }
  console.log(cnt);
};

solution();
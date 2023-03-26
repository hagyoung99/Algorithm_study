const readFileSyncAddress = '/dev/stdin';

let input = require("fs")
  .readFileSync(readFileSyncAddress)
  .toString()
  .split("\n");

const [H, W] = input[0]
  .split(" ")
  .map(Number)
  .sort((a, b) => b - a);
const N = Number(input[1]);
const puzzles = [];
let answer = 0;
let check = false;

function putPuzzles(h1, w1, h2, w2) {
  if (Math.max(h1, h2) <= H && w1 + w2 <= W) return true;
  if (h1 + h2 <= H && Math.max(w1, w2) <= W) return true;
  return false;
}

function isPossible(h1, w1, h2, w2) {
  if (putPuzzles(h1, w1, h2, w2)) return true;
  if (putPuzzles(h1, w1, w2, h2)) return true;
  if (putPuzzles(w1, h1, h2, w2)) return true;
  if (putPuzzles(w1, h1, w2, h2)) return true;
  return false;
}

for (let i = 2; i < 2 + N; i++) {
  puzzles.push(input[i].split(" ").map(Number));
}

for (let i = 0; i < puzzles.length; i++) {
  for (let j = i + 1; j < puzzles.length; j++) {
    check = false;

    const [h1, w1] = puzzles[i];
    const [h2, w2] = puzzles[j];

    if (isPossible(h1, w1, h2, w2)) {
      answer = Math.max(answer, h1 * w1 + h2 * w2);
    }
  }
}

console.log(answer);
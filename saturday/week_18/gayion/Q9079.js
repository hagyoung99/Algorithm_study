const stdin = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trimEnd()
  .split("\n");
const input = (() => {
  let line = 0;
  return () => stdin[line++];
})();

const arr_case = [
  // 모서리
  [
    [0, 0],
    [0, 1],
    [0, 2],
  ],
  [
    [2, 0],
    [2, 1],
    [2, 2],
  ],
  [
    [0, 0],
    [1, 0],
    [2, 0],
  ],
  [
    [0, 2],
    [1, 2],
    [2, 2],
  ],
  // 가운데
  [
    [1, 0],
    [1, 1],
    [1, 2],
  ],
  [
    [0, 1],
    [1, 1],
    [2, 1],
  ],
  // 대각선
  [
    [0, 0],
    [1, 1],
    [2, 2],
  ],
  [
    [0, 2],
    [1, 1],
    [2, 0],
  ],
];

const reverse = (arr, one_case) => {
  for (const [y, x] of one_case) {
    arr[y][x] = arr[y][x] == "H" ? "T" : "H";
  }
};

const check_equals_all = (arr) => {
  const tmp = arr[0][0];
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      if (arr[i][j] != tmp) {
        return false;
      }
    }
  }
  return true;
};

let min = Infinity;
const dfs = (board, idx_case, depth) => {
  if (depth > min) {
    return;
  }
  if (check_equals_all(board)) {
    min = Math.min(min, depth);
    return;
  }
  for (let i = idx_case; i < 8; i++) {
    reverse(board, arr_case[i]);
    dfs(board, i + 1, depth + 1);
    reverse(board, arr_case[i]);
  }
};

let T = input();
while (T--) {
  const board = [];
  board.push(input().split(" "));
  board.push(input().split(" "));
  board.push(input().split(" "));
  dfs(board, 0, 0);
  console.log(min == Infinity ? -1 : min);
  min = Infinity;
}

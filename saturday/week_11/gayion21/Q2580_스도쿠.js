let fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
input = input.map(row => row.split(' ').map(i => Number(i)));

let zeroCoords = getZeroCoords();
let N = zeroCoords.length;
let answer = "";
DFS(0);

function DFS(L) {
  if (L === N) {
    for (let x of input) {
      answer += `${x.join(" ")}\n`;
    }
    console.log(answer);
    process.exit(0);
  } else {
    let [row, col] = zeroCoords[L];

    for (let i = 1; i <= input.length; i++) {
      if (check(row, col, i)) {
        input[row][col] = i;
        DFS(L + 1);
        input[row][col] = 0;
      }
    }
  }
}

function check(row, col, value) {
  let threeRow = Math.floor(row / 3) * 3;
  let threeCol = Math.floor(col / 3) * 3;

  for (let i = 0; i < input.length; i++) {
    if (input[row][i] === value || input[i][col] === value) return false;
  }

  for (let i = threeRow; i < threeRow + 3; i++) {
    for (let j = threeCol; j < threeCol + 3; j++) {
      if (input[i][j] === value) return false;
    }
  }

  return true;
}

function getZeroCoords() {
  const arr = [];
  for (let i = 0; i < input.length; i++) {
    for (let j = 0; j < input.length; j++) {
      if (input[i][j] === 0) arr.push([i, j]);
    }
  }
  return arr;
}
const fs = require('fs');
const [[N], ...board] = fs.readFileSync("./dev/stdin").toString().trim().split("\n").map(v => v.split(' ').map(Number));


let priceBoard = Array.from(Array(N), () => Array(N).fill(0));

for (let i = 1; i < N - 1; i++) {
  for (let j = 1; j < N - 1; j++) {
    priceBoard[i][j] = calcPrice(i, j);
  }
}


let min = Infinity;

for (let a = 1; a < N - 1; a++) {
  for (let b = 1; b < N - 1; b++) {
    for (let c = 1; c < N - 1; c++) {
      for (let d = 1; d < N - 1; d++) {
        if (isImPossible(a, b, c, d)) continue;
        for (let e = 1; e < N - 1; e++) {
          for (let f = 1; f < N - 1; f++) {
            if (isImPossible(a, b, e, f)) continue;
            if (isImPossible(c, d, e, f)) continue;
            let temp = priceBoard[a][b] + priceBoard[c][d] + priceBoard[e][f]
            if (temp < min) min = temp
          }
        }
      }
    }
  }
}
console.log(min)


function isImPossible(x, y, z, w) {
  const column = Math.pow(Math.abs(x - z), 2)
  const row = Math.pow(Math.abs(y - w), 2)
  if (column + row <= 4) {
    return true;
  }
  return false;
}

function calcPrice(x, y) {
  let price = 0;
  const dx = [0, 0, 0, -1, 1];
  const dy = [0, 1, -1, 0, 0];

  for (let i = 0; i < 5; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];
    price += board[nx][ny]
  }
  return price;
}
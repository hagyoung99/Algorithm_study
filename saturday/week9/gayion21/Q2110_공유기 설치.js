const [N, C, ...coord] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split(/\s/)
  .map(Number);
coord.sort((a, b) => a - b);

const isPossible = (distance) => {
  let count = C - 1;
  let prevCoord = coord[0];
  for (let i = 1; i < coord.length; i++) {
    if (coord[i] - prevCoord >= distance) {
      count--;
      prevCoord = coord[i];
    }
  }
  return count <= 0;
};

let low = 1;
let high = coord[coord.length - 1];
while (low <= high) {
  const mid = Math.floor((low + high) / 2);
  if (isPossible(mid)) {
    low = mid + 1;
  } else {
    high = mid - 1;
  }
}

console.log(high);
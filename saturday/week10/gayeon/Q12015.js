const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const binarySearch = (list, left, right, target) => {
  while (left < right) {
    let mid = Math.floor((left + right) / 2);

    if (list[mid] < target) {
      left = mid + 1;
    } else {
      right = mid;
    }
  }
  return right;
};

const sol = (input) => {
  const n = +input.shift();
  const arr = input[0].split(" ").map(Number);
  const lis = [];
  lis.push(arr[0]);
  for (let i = 1; i < n; i++) {
    if (lis[lis.length - 1] < arr[i]) {
      lis.push(arr[i]);
    } else {
      let idx = binarySearch(lis, 0, lis.length - 1, arr[i]);
      lis[idx] = arr[i];
    }
  }

  return lis.length;
};

console.log(sol(input));
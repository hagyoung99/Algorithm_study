const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const N = input.shift();
const sorted = [];
const lengthArr = input.map(str => str.length);
const max = Math.max.apply(null, lengthArr);
const min = Math.min.apply(null, lengthArr);

for (let i = min; i <= max; i++) {
  const group = [];
  for (let j = 0; j < N; j++) {
    if (input[j].length === i) {
      if (group.indexOf(input[j]) === -1) group.push(input[j]);
    }
  }
  if (group.length > 1) {
    sorted.push(...group.sort());
  } else {
    sorted.push(...group);
  }
}

console.log(sorted.join('\n'));
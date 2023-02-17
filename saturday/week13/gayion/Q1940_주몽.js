const fs = require('fs');
const [_, target, input] = fs.readFileSync("./dev/stdin").toString().trim().split('\n');

const num = input.split(' ').map(Number).sort((a, b) => a - b);
let answer = 0;

let front = num.shift();
let back = num.pop();

while (num.length > 0) {
  const result = front + back
  if (result == target) {
    answer++;
    front = num.shift();
    back = num.pop();

  } else if (result < target) {
    front = num.shift();
  } else {
    back = num.pop();
  }
}
if (front && back && front + back == target) {
  answer++;
}

console.log(answer)
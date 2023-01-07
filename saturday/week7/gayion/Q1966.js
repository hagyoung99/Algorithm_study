const fs = require('fs');
const file = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(file).toString().trim().split('\n');

let [n, ...arr] = input;
arr = arr.map((item) => item.split(' ').map(Number));
let answer = '';

for (let i = 0; i < arr.length; i += 2) {
  let count = 0;
  const priorities = arr[i + 1];
  let location = arr[i][1];

  while (true) {
    const max = Math.max(...priorities);
    const number = priorities.shift();
    if (number === max) {
      count++;
      if (location === 0) {
        answer += count + '\n';
        break;
      }
    } else {
      priorities.push(number);
    }

    if (location === 0) {
      location = priorities.length - 1;
    } else {
      location--;
    }
  }
}

console.log(answer.trim());
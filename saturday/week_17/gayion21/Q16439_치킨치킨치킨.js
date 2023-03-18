const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : 'input.txt';
const input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split('\n')
  .map(stringArray => stringArray.split(' ').map(string => Number(string)));

const [N, M] = input[0];
const people = input.slice(1);
const solution = people => {
  const result = [];

  for (let i = 0; i < M - 2; i++) {
    for (let j = i + 1; j < M - 1; j++) {
      for (let k = j + 1; k < M; k++) {
        let current = 0;
        people.forEach(p => {
          current += Math.max(p[i], p[j], p[k]);
        });
        result.push(current);
      }
    }
  }

  return Math.max(...result);
};

const result = solution(people);
console.log(result);
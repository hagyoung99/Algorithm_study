const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let [N, M] = input[0].split(' ').map(Number);
let arrA = new Set(input[1].split(' ').map(Number));
let arrB = new Set(input[2].split(' ').map(Number));
let answer = new Set([...arrA, ...arrB]);

arrA.forEach((a) => {
  if(arrB.has(a)){
    answer.delete(a)
  }
})
console.log(answer.size)
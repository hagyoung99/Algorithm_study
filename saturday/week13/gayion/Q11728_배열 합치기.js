const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

// const input = "2 2\n3 5\n2 9".split('\n');
/* 
2 2
3 5
2 9
*/
const [N, M] = input.shift().split(" ").map(el => +el);
const arrA = input.shift().split(' ').map(el => +el);
const arrB = input.shift().split(' ').map(el => +el);


let i = 0;
let j = 0;
let k = 0;
const result = [];

while (i < N && j < M) {
  if (arrA[i] > arrB[j]) result[k++] = arrB[j++];
  else result[k++] = arrA[i++];
}

while (i < N) {
  result[k++] = arrA[i++];
}

while (j < M) {
  result[k++] = arrB[j++];
}

console.log(result.join(' '));
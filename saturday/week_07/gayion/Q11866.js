const fs = require('fs');
const input= fs.readFileSync('/dev/stdin').toString().trim().split(' ');

const n= +input[0];
const k= +input[1];
let answer=[];

// 참고 코드console.log(Array.from([1, 2, 3], x => x + x)); // expected output: Array [2, 4, 6]

const arr = Array.from({ length: n }, (v, i) => i + 1);
for (let i = 0; i < n; i++) {
    for (let j = 1; j <= k; j++) {
      if (j === k) {
        answer.push(arr.shift());
      } else {
        arr.push(arr.shift());
      }
    }
  }
  
 console.log('<'+answer.join(', ')+'>')
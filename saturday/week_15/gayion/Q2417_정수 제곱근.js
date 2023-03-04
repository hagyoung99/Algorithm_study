const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const test_num = +input[0];

let a = Math.floor(test_num**(1/2));

if((a**2 >= test_num)){
  console.log(a);
} else {
  console.log(a+1);
}
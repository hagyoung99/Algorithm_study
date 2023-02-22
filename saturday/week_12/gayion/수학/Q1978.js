let input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
// let input = ['4', '1 3 5 7']; output : 3
let N = parseInt(input[0]);
let arr = input[1].split(' ').map(n => parseInt(n));
let answer = 0;

function isPrime(num){
  if(num===1) return false;    
  for(let i=2; i<parseInt(num); i++){
      if(num%i===0) return false;
  }    
  return true;
};

for(let i=0; i<N; i++){
    if(isPrime(arr[i])) answer++;
};
console.log(answer);
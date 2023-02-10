const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const N = Number(input.shift());
const nums = input.map(el=>el.split(' ').map(Number));
let answer = '';

for(let [a, b] of nums){
    let min = Math.min(a,b), max=Math.max(a,b);
    answer += a*b / gcd(max,min)+'\n';
}

function gcd(a, b){
    while(b!==0){
        let temp = a%b;
        a=b;
        b=temp;
    }
    return a;
}

console.log(answer.trim());
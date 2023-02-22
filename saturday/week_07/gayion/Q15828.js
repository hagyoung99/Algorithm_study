let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let N = +input[0];
let q = [];

for (let i = 1; i < input.length; i++) {
    let v = +input[i];
    if (v === -1) break;
    
    if (v === 0) q.shift();
    else if (q.length < N) q.push(v);
}
console.log(q.length ? q.join(' ') : 'empty');
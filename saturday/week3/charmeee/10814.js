let fs = require('fs');
let tmp = fs.readFileSync('dev/stdin').toString().trim().split('\n');


let input = [];

for (let i = 0; i < tmp.length; i++) {
    input.push(tmp[i].split(' '));
}

let length = parseInt(input.shift());

let output = '';
input.sort((a,b)=>a[0]-b[0]).forEach((i)=>output+=`${i.join(' ')}\n`);

console.log(output);
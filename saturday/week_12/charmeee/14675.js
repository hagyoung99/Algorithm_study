
let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().trim().split('\n');
let N1 = tmp.shift();
let input = tmp.splice(0,N1-1).map((x)=>x.split(' '));
let N2 = tmp.shift();
let question = tmp.map((x)=>x.split(' '));
console.log(question);


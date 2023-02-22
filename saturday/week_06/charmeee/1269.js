let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let arr1 = input[1].split(' ');
let arr2 = input[2].split(' ');
let totalLength =arr1.length+arr2.length;
let setLength = (new Set([...arr1,...arr2])).size;

console.log(2*setLength-totalLength);
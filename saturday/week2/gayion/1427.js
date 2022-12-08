let input = require('fs').readFileSync('dev/stdin').toString().trim().split('').map(n => parseInt(n));

console.log(input.sort((a, b) => b-a).join(''));
const input = require("fs").readFileSync('/dev/stdin').toString().trim().split('\n').slice(1).map(num => Number(num));

input.sort((a,b) => a - b);  

console.log(input.join("\n"));

/*
const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n").map(item => Number(item));

const iter = input.shift();

input.sort((a,b) => a - b);

console.log(input.join("\n"));
*/

/*
let input = []

require('readline')
    .createInterface(process.stdin, process.stdout)
    .on('line', function(x) {
        input.push(x.trim())
    })
    .on('close', function() {
        const [N, ...order] = input.map(Number)
        const result = order.sort((a, b) => a - b)
        console.log(result.join('\n'));
    })
*/
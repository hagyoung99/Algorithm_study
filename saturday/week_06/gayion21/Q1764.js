const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split("\n");

const [N, M] = input.shift().split(' ');

const Nset = new Set();
const Mset = new Set();
for(let i=0; i<input.length; i++) {
    if(i < N) {
        Nset.add(input[i]);
    } else {
        Mset.add(input[i]);
    }
}

let answer = [];
Mset.forEach((item) => {
    if(Nset.has(item)) answer.push(item);
})
answer.sort();
console.log(answer.length + '\n' + answer.join('\n'));
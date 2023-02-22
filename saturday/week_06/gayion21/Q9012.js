const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const len = input.shift();
const result = [];

for (let i = 0; i < len; i++) {
    let cnt = 0;
    
    for (let s of input[i]) {
        cnt += s === "(" ? 1 : -1;
        
        if (cnt < 0) break;
    }
    
    result.push(cnt === 0 ? 'YES' : "NO");
}

console.log(result.join('\n'));
const input = require("fs").readFileSync('/dev/stdin').toString().trim().split('\n').map(num => Number(num));

// 메모리 초과 지옥에 빠졌다. 살려줘요
// .... node.js로는 안 풀린다고 한다... 화난다.. 내 시간 돌려줘


let N = Number(input.shift());
let arr = input.map(x => +x);
let max = Math.max.apply(null, arr);
let arrange = new Array(max);
arrange.fill(0);

let answer = '';

for(let i = 0; i < N; i++) {
    arrange[arr[i]-1]++;
}

for(let i = 0; i < arrange.length; i++) {
    if(arrange[i] !== 0) {
        for(let j=0; j < arrange[i]; j++) {
            answer += (i+1) + '\n';
        }
    }
}
console.log(answer);
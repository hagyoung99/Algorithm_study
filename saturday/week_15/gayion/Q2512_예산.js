const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, request, total] = [+input[0], input[1].split(' ').map(Number), +input[2]];


request.sort((a,b) => a-b);

let left = 0;
let right = request[request.length-1];
let answer = Number.MIN_SAFE_INTEGER;
while(left <= right) {
    let mid = Math.floor((left + right)/2);

    let possible = 0;
    for(let x of request) {
        if( x > mid ) possible += mid;
        else possible += x;
    }

    if(total >= possible) {
        // 예산 배정이 가능한 경우
        if(mid > answer) answer = mid;
        // answer은 최댓값
        left = mid + 1;
    } else {
        right = mid -1;
    }
}

console.log(answer);
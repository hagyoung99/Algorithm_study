const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input.shift().split(' ');
const trees = input[0].split(' ').map(Number).sort((a,b) => a-b);

function solve(arr, target) {
    let start = 0;
    let end = arr[arr.length-1];
    let answer = Number.MIN_SAFE_INTEGER;
    while(start <= end) {
        let mid = Math.floor((start + end)/2);
        let sum = 0;
        for(let x of arr) {
            if(x > mid) sum += x-mid;
        }

        if(sum >= target) {
            if(mid > answer) answer = mid; 
            // 최댓값 계속 구해주기.
          	// 이 부분을 제외하고는 일반적인 이분탐색 코드와 똑같다.
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return answer;
}

console.log(solve(trees, M))
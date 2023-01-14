let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((x)=>+x);


solution(input[0], input[1]);

function solution(n, k) {
    let start = 1;
    let end = n * n; // k의 최대값은 n * n이기 때문에 rt는 n * n

    while (start <= end) {
        const mid = Math.floor((start + end) / 2);
        if (orderConfirm(mid) >= k) end = mid - 1; // 순서를 확인하여 k보다 크거나 같다면 rt를 mid보다 작게한
        else start = mid + 1; // 정답을 도출하기위한 answer변수를 쓰지 않기 위해 if문 안의 두 변수들을 바꾸었다.
    }

    console.log(start);
}

function orderConfirm(mid) {
    let cnt = 0;

    for (let i = 1; i <= n; i++) {
        cnt += Math.min(n, Math.floor(mid / i)); // n의 인덱스 범위를 넘어가면 n보다 큰 인덱스는 없기 때문에 n으로 변경.
    }

    return cnt;
}
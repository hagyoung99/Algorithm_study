const [N, M, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\s/).map(v => +v);
let count = 0;
for (let i=0; i<N; i++) {
    let sum = arr[i];
    let idx = i;
    while (sum < M && idx < N-1) {
        idx++;
        sum += arr[idx];
    }
    if (sum === M) count++;
}
console.log(count);
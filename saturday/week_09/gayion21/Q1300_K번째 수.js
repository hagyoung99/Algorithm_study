
const readline = require('readline');
const rl = readline.createInterface({
    input : process.stdin,
    output : process.stdout
});
let n = 0, k = 0;
let count = 2;
rl.on('line', function(line) {
    if(count === 2) {
        n = parseInt(line);
    } else if(count === 1) {
        k = parseInt(line);
    }
    count--;
    if(count === 0) rl.close();
}).on('close', function() {
    let left = 1; right = n * n;
    let result = 0;

    while(left <= right) {
        const mid = parseInt((left + right) / 2);
        let cnt = 0;

        for(let i = 1; i <= n; i++) {
            cnt += Math.min(n, parseInt(mid / i));
        }
        
        if(cnt >= k) {
            result = mid;
            right = mid - 1;
        } else {
            left = mid + 1;            
        }
    }
    console.log(result);
    process.exit();
});
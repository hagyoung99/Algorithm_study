const fs = require('fs');
let input = fs.readFileSync("/dev/stdin").toString();
let sum = 0, cnt = 0;

for(let i =1;; i++){
    sum += i
    cnt++;
    if(sum > input){
        cnt--;
        break;
    }
}

console.log(cnt);
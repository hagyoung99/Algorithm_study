

let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let N = parseInt(input[0]);
let arr = input[1].split(' ').map(x => +x);
let ans = 0;

for(let i of arr){
    let flag = true;
    if(i==1){ 
        flag = false
    }else{
        for(let j=2; j<i; j++){
            if(num%j===0) {
                flag= false;
                break;
            }
        } 
    }
    if(flag) ans++;
     
}

console.log(ans);
let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let arr=input[1].split(' ').map((x)=>+x);

arr.sort((a,b)=>a-b);
//console.log(arr);
let n = +input[2]

let s=0,e=arr.length-1;
let cnt = 0;
while(s<e){
    let sum = arr[s]+arr[e];
    //console.log(s,e,sum)
    if(sum===n) cnt++;
    if(sum<n){
        s++;
    }else{
        e--;
    }
    
}

console.log(cnt);
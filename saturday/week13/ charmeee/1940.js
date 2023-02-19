let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let M = +input[1];
let arr =input[2].split(' ').map((x)=>+x);
arr.sort((a,b)=>a-b);
let start = 0;
let end = arr.length-1;
let cnt =0;
console.log(arr);
while(start<end){
    let value = arr[start]+arr[end];
    if(value===M){
        start++;
        end--;
        cnt++;
    }else if(value<M){
        start++;
    }else{//value>M
        end--;
    }
}
// if(start===end&&start===M){
//     cnt++;
// }

console.log(cnt);
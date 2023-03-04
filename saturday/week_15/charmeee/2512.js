let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let n = +input[0];
let arr = input[1].split(' ').map(x=>+x);
let budget = +input[2];
let max = Math.max(...arr);
if(arr.reduce((a,b)=>a+b)<=budget){
    console.log(max);
}
function binarySearch(start,end){
   
    let mid =parseInt((start+end)/2);
    let sum1 = arr.reduce((a,b)=>b<=mid?a+b:a+mid);
    let sum2 = arr.reduce((a,b)=>b<=(mid+1)?a+b:a+mid);

    if(sum1<=budget<sum2) return mid;
    if(sum2<=budget) return binarySearch(mid+1,end);
    if(sum1>budget) return binarySearch(start,mid-1)
}

console.log(binarySearch(parseInt(budget/n),max));
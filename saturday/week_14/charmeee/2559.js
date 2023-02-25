let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let [n,m]=input[0].split(' ').map((x)=>+x);
let arr=input[1].split(' ').map((x)=>+x);
let s=0,e=0;
let sum = arr[0];
let max = -10000000;
while(s<n&&e<n){
    if(e-s===m-1){
        if(max<sum) max = sum;
        sum-=arr[s];
        s++;
    }else{
        e++;
        sum+=arr[e];
    }

}

console.log(max);
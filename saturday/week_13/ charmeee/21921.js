let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let [N,X]=input[0].split(' ').map((x)=>+x);
let arr = input[1].split(' ').map((x)=>+x);
let max = -1;
let sum = 0;
let count = 1;
for(let i=0;i<X;i++){
    sum+=arr[i];
}

let start = 0;
let end = start+X-1;


while(end<N){
    //console.log(sum+'|'+start+'|'+end);
    if(sum>max){
        max=sum;
        count=1;
    }else if(sum===max){
        count++;
    }
    sum=sum-arr[start++]+arr[++end];
    // console.log(sum+'|'+start+'|'+end);
    // console.log('---------');
}

console.log(max===0?'SAD':max+'\n'+count);

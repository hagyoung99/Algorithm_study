
let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
input= input.map((x)=>x.split(' ').map((y)=>+y));

//console.log(input);
let start = 0;
let end = 0;
let count = 0;
let sum=0;
//console.log(input[0][1]);
while(start<input[0][0]&&end<input[0][0]){
    if(sum<input[0][1]){
        sum+=input[1][end];
        end++;
    }else{
        sum-=input[1][start];
        start++
    }
    if(sum===input[0][1]){
        count++;
    }
    // console.log(sum+'|'+start+'|'+end);
    // console.log('--------')       
} 
console.log(count);
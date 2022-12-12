let fs = require('fs');
let input =fs.readFileSync('input.txt').toString().trim();
let init = input-input.length*9;
let sum =0;
let result =0;
while(init<parseInt(input)){
    sum=0;
    var tmp= init;
    while(tmp>0){
        sum+=tmp%10;
        tmp=parseInt(tmp/10);
    }
    sum+=init;
    if(sum===parseInt(input)){
        result=init;
        break;
    }
    init++;
}
console.log(result);

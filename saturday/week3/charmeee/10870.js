let fs = require('fs');
const { parse } = require('path');
let input = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let pre = 0;
let now = 1;
let result=0;
if(input ===0||input===1){
    result=input;
}else{
    let i = 2;
    while(i<=input){
        result=pre+now;
        pre = now;
        now =result;
        i++;
    }

}
console.log(result);
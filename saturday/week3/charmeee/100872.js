let fs = require('fs');
const { parse } = require('path');
let input = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let output =1;

while(input>0){
    output*=input;
    input--;
}
console.log(output);
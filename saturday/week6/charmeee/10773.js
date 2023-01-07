let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map(x=>+x);
input.shift();
let output=[];
input.forEach((x)=>{
    x===0?output.pop():output.push(x);
})

console.log(output.reduce((a,b)=>(a+b),0));
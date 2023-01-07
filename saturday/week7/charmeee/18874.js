let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((x)=>+x);
let length = input.shift();
let stack = [];
let output = "";
for(let i =1 ; i<length+1;i++){
    stack.push(i);
    output+='+\n';
    while(stack[stack.length-1]===input[0]&&input.length>0){
        output+='-\n';
        stack.pop();
        input.shift();
    }
}
console.log(input.length===0?output:"NO")

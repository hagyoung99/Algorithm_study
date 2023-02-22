let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let stack =[];
let output =[];
input.shift();
for(let i =0; i<input.length;i++){
    let tmp = input[i].split(' ');
    switch(tmp[0]){
        case "push":
            stack.push(tmp[1]);
            break;
        case "pop":
            output.push(stack.pop()??-1);
            break;
        case "size":
            output.push(stack.length);
            break;
        case "empty":
            output.push(stack.length===0?1:0);
            break;
        case "top":
            output.push(stack[stack.length-1]??-1)
            break;
    }
}
console.log(output.join('\n'));
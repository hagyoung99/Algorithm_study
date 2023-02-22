let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');


let length = parseInt(input.shift());

let set = new Set(input);
let output = '';
Array.from(set).sort(function(a,b){
    if(a.length===b.length){
        if(a>b){
            return 1
        }
        return -1
    }
    return a.length -b.length;
}).forEach((str)=>output+=`${str}\n`);

console.log(output);
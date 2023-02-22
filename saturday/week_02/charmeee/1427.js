let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().trim();

let input = [];
for (let i = 0; i < tmp.length; i++) {
    input.push(parseInt(tmp[i]));
}

if(tmp.length>1){
    input.sort(function(a,b){
        return b-a; 
    });
}
console.log(input.join(''));
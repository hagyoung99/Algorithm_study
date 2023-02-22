let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.shift();
let output = "";
input.forEach((x)=>{
    while(x.length>0){
        let tmp = x.replaceAll('()','');
        if(x.length===tmp.length) break;
        x=tmp;
    }
    x.length===0?output+="YES\n":output+="NO\n"
})

console.log(output);
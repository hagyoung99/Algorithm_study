let fs = require('fs');
let input =parseInt( fs.readFileSync('input.txt').toString().trim());

let num=0;
let str = "";
move(input,1,2,3);

function move(n,s,m,e){
    num++;
    if(n===1){
        str+=(s+' '+e+'\n');
        return;
    }
    move(n-1,s,e,m);
    str+=(s+' '+e+'\n');
    move(n-1,m,s,e);
}
num+=('\n'+str);
console.log(num)
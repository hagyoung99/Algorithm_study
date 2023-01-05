let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let comp1 = input[1].split(' ').map(x=>+x);
comp1.sort((a,b)=>a-b);
let hash = new Map();
let before =null;
for(let i in comp1){
    if(before!==comp1[i]){
        hash.set(comp1[i],1)
    }else{
        hash.set(before,hash.get(before)+1);
    }
    before=comp1[i];
}
let comp2 = input[3].split(' ').map(x=>+x);
for(let i in comp2){
    let value = hash.get(comp2[i]);
    comp2[i]=value??0;
}
console.log(comp2.join(' '));

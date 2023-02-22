let fs = require('fs');
let [length,interval] = fs.readFileSync('/dev/stdin').toString().trim().split(' ').map((x)=>+x);


let cnt = 1;
let index = 0;
let output ='';

let arr = Array(length).fill().map((x,i)=>i+1);

while(arr.length>0){
    if(cnt%interval===0){
        cnt = 1;
        output+= arr.length===1?arr[index]:(arr[index]+', ')
        arr.splice(index,1);
    }else{
        cnt++;
        index=(index+1)%arr.length;

    } 
}


console.log('<'+output+'>');


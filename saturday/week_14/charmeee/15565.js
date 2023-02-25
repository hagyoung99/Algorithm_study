let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let [n,m]=input[0].split(' ').map((x)=>+x);
let arr=input[1].split(' ').map((x)=>+x);


let s=0,e=0;
let count= arr[0]===1?1:0;
let min = -1;
while(s<n&&e<n){
    console.log(s,e,count,min);
    if(count===m&&(min===-1||min>e-s+1)) min=e-s+1;
    if(count>=m){
        if(arr[s]===1) count--;
        s++;
    }else{//count<m
        //end가 마지막까지 도달햇을때
        e++;
        if(e<n&&arr[e]===1) count++;
    }
}



console.log(min);

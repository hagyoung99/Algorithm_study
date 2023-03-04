let fs = require('fs');
let arr = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let sangunArr = arr[1].trim().split(' ').map(x=>parseInt(x));
let comArr = arr[3].trim().split(' ').map(x=>parseInt(x));
sangunArr.sort((a,b)=>a-b);

let output =[];
let first = 0;

for( let a in comArr ){
    binary_search(0,sangunArr.length-1,comArr[a]);
}

function binary_search(start,end,target){
    // console.log(`${start} ${end} ${target}`);
    if(start>end){
        output.push(0);
        return;
    }
    let mid = parseInt((start+end)/2);
    // console.log(mid)
    if(target===sangunArr[mid]){
        output.push(1);
        return;
    }
    if(target > sangunArr[mid]){
        return binary_search(mid+1,end,target);
    }else{//target < sangunArr[mid]
        return binary_search(start,mid-1,target);
    }
}

console.log(output.join(' '));
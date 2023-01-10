let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n').map((x)=>+x);

let length = input[0];
let arr = [];
let index = 0;

for(let i =1;i<input.length;i++){
    if(input[i] === -1) break;
    if(input[i]>0){//정보를 넣는다.
        if(arr.length-index>=length) continue; //꽉찼으면 pass
        arr.push(input[i]);
    }else{//정보를 처리한다.
        index++;
    }
    // console.log(input[i]);
    // console.log(arr);
    // console.log(index);
}

if(index>=arr.length){
    console.log('empty');
}else{
    let output ="";
    for(let i=index;i<arr.length;i++){
        output+=(arr[i]+' ');
    }
    console.log(output);
}
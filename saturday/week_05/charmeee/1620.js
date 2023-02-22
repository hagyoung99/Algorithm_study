let fs = require('fs');
let arr = fs.readFileSync('input.txt').toString().trim().split('\n');
let [qNum,aNum]=arr.shift().split(' ');

let ask=arr.splice(Number(qNum),Number(aNum));
let ans=[];
let hash = new Map();
for(let i in arr){
    hash.set(arr[i],+i+1);
}
for (let i in ask){
    let tmp1 = Number(ask[i]);
    if(isNaN(tmp1)){
        let tmp2 = hash.get(ask[i])
        if((tmp2)!==undefined){
            ans.push(tmp2);
        }
    }else{
       ans.push(arr[tmp1-1]) ;
    }
}
console.log(ans.join('\n'));
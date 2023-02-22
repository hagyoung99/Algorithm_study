//대치한다는게 잘 머리에 떠오루자얺눈더
let fs = require('fs');
let [,input] = fs.readFileSync('input.txt').toString().trim().split('\n');
let arr = input.split(' ').map(x=>+x);



// let output=[0, 1, 2, 4, 5];
let output=[];
function search(start,end,target){
    console.log(start+'|'+end);
    if(start>=end){
        return end;
    }
    let mid = parseInt((start+end)/2);
    if(output[mid]===target){
        return mid;
    }else if(output[mid]<target){
        return search(mid+1,end,target);
    }else{
        return search(start,mid,target);
    }
}
// console.log(search(0,output.length-1,));
for(let i =0;i<arr.length;i++){
    if(output.length===0||output[output.length-1]<arr[i]){
        output.push(arr[i]);
    }else{
        //이분탐색,
        //arr[i]보다 크면서 가장 가까운것과 대치
        let idx=search(0,output.length-1,arr[i]);
        output[idx]=arr[i];
    }
    console.log(output)
}

console.log(output.length);
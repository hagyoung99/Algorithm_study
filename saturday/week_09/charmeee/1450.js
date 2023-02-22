//그냥 dfs를하면 안됨..
let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let [,limitWeight] = input[0].split(' ');
let arr = input[1].split(' ').map((x)=>+x);
let case1 =[];
let case2 =[];

function getCombination(start,end,sum,list){
    if(sum>limitWeight) return;

    if(start>=end){
        list.push(sum);
        return;
    }
    getCombination(start+1,end,sum+arr[start],list);//넣은 경우
    getCombination(start+1,end,sum,list);//안 넣음
}

function search(start,end,target,arr){
    //console.log(start + '|' +end )
    if(target<0) return 0;
    if(start>end){
        return end+1;
    }
    let mid = parseInt((start+end)/2);
    //console.log("mid" +mid);
    if(arr[mid]===target){
        return mid+1;
    }else if( arr[mid]>target){
        return search(start,mid-1,target,arr);
    }else{
        return search(mid+1,end,target,arr);
    }
}


getCombination(0,parseInt(arr.length/2),0,case1);
getCombination(parseInt(arr.length/2),arr.length,0,case2);

case1.sort();
case2.sort();

// console.log(case1);
// console.log(case2);

let count = 0;
for(let i = 0; i<case1.length;i++){
    //이분탐색
    let tmp = search(0,case2.length-1,limitWeight-case1[i],case2);
    //console.log(tmp);
    count+=tmp;
}

console.log(count);
let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
//let [n,m] = input[0].split(' ').map(x=>+x);
let dots = input[1].split(' ').map(x=>+x);
let lines = [];
for(let i = 2 ; i<input.length ; i++){
    lines.push(input[i].split(' ').map(x=>+x));
}
//console.log(lines);

dots.sort((a,b)=>a-b);
function findValue(value,start,end,isStart){
    //console.log(value,start,end,isStart);
    if(start>end) return isStart?start:end;
    let mid=parseInt((start+end)/2);
    if(dots[mid]===value) return mid
    if(dots[mid]>value) return findValue(value,start,mid-1,isStart);
    if(dots[mid]<value) return findValue(value,mid+1,end,isStart);
    return -1;
}
let output = ""
for(let [x,y] of lines){
    //console.log(x,y);
    let first = findValue(x,0,dots.length-1,true);
    let last = findValue(y,0,dots.length-1,false);
    let result =last-first;
    if(result<0){
        output+='0\n';
    }else{
        output+=(result+1)+'\n';
    }
}


console.log(output);
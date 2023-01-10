let fs = require('fs');
let input = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let arr = Array(input).fill().map((a,i)=>i+1);

let index = 0;
while(arr.length-1>index){//한개는 남겨놔야..
    index++;//제거
    if(arr.length-1<=index) break;
    let tmp = arr[index];
    index++;
    arr.push(tmp);
}
console.log(arr[index]);
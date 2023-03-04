
let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();
let digit = parseInt((input.length-1)/2);//0의 개수
let s_init = BigInt(10**digit);
let e_init = BigInt(10**(digit+1));
input=BigInt(+input);//정수로 변환.
/*
150 100- 10000
10-100
1003
10-100
19 20
*/

function binarySearch(start,end){
    //console.log('dfasdf');
    //if(input===0) return 0;
    let mid =(start+end)/2n;
    let bigT =mid*mid;
    let smallT = (mid-1n)*(mid-1n);
    //console.log(start,end,mid,bigT,smallT);
    if(smallT<input&&input<=bigT) return mid;
    if(smallT === input) return mid-1n;
    if(input < smallT) return binarySearch(start,mid-1n);
    if(input>bigT) return binarySearch(mid+1n,end);
}

console.log(Number(binarySearch(s_init,e_init-1n)));
/* 
15
0 - 1
1-10
140
0 - 2
10-100
10500 5
100 ~1000 34
1000 
10~100사이
122333444455555
123456789012345
15개
0 -14개



*/
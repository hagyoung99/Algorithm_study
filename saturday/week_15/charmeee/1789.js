let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim();
input = +input;

/*
1-18 => 19 * 18 / 2 = 171
1-19 => 20 * 19 / 2 = 190 이상
1-20 => 21 * 20 / 2 = 210 미만
*/
//n*(n+1)
function findValue(start,end){
    let mid = parseInt((start+end)/2);
    let smallT = mid*(mid+1)/2;
    let largeT = (mid+1)*(mid+2)/2;
    //console.log(mid,smallT,largeT);
    if(smallT<=input&&input<largeT) return mid;
    if(largeT===input) return mid+1;
    if(smallT>input) return findValue(start,mid-1);
    if(largeT<input) return findValue(mid+1,end);
    return "error"
}
console.log(findValue(1,input-1));
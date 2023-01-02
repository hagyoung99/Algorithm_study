let fs = require('fs');
const { parse } = require('path');
let tmp = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
tmp.shift();

let result ='';

function recursion(s, l, r,count){
    if(l >= r) return result+=`1 ${count}\n`;
    else if(s.charAt(l) != s.charAt(r)) return result+=`0 ${count}\n`;
    else return recursion(s, l+1, r-1,count+1);
}
function isPalindrome(s){
    return recursion(s, 0, s.length-1,1);
}

tmp.forEach((str)=>isPalindrome(str));
console.log(result);
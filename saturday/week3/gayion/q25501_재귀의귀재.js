/* 
팰린드롬이란, 앞에서부터 읽었을 때와 뒤에서부터 읽었을 때가 같은 문자열을 말한다. 
팰린드롬의 예시로 AAA, ABBA, ABABA 등이 있고, 팰린드롬이 아닌 문자열의 예시로 ABCA, PALINDROME 등이 있다.

어떤 문자열이 팰린드롬인지 판별하는 문제는 재귀 함수를 이용해 쉽게 해결할 수 있다. 
아래 코드의 isPalindrome 함수는 주어진 문자열이 팰린드롬이면 1, 팰린드롬이 아니면 0을 반환하는 함수다.

함수의 반환값과 recursion 함수의 호출 횟수를 구해보자!

[입력]                      [출력]
5                           
AAA                         1 2
ABBA                        1 3
ABABA                       1 3
ABCA                        0 2
PALINDROME                  0 1
*/
const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
// let input = "5\nAAA\nABBA\nABBA\nABABA\nABCA\nPALINDROME".toString().trim().split("\n");

input.shift();

function recursion(str, l, len, count){
    count++;

    if(l >= len) return [1, count];
    else if(str[l] != str[len]) return [0, count];
    else return recursion(str, l+1, len-1, count);
}

function isPalindrome(str){
    return recursion(str, 0, str.length-1, 0);
}

input.forEach(element => {
    console.log(isPalindrome(element).join(" "));
});
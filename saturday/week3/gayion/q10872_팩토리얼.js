/* 
[문제]
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.

[입력]
10

[출력]
3628800
*/

const fs = require("fs");
const input = Number(fs.readFileSync('/dev/stdin').toString().trim());

// const input = Number("10".toString().trim());

function facFunc(x){
    if(x <= 1)
        return 1;

    return x*facFunc(x-1);
}


console.log(facFunc(input));
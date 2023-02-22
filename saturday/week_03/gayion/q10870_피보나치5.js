/* 
피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.

[입력]
10

[출력]
55
*/

const fs = require("fs");
const input = Number(fs.readFileSync('/dev/stdin').toString().trim());

// const input = Number("10".toString().trim());

function fibonacci(x){
    // if(x == 1){
    //     return 1;
    // } else if(x==0) return 0;
    
    if(x==0){return 0;}
    else if(x <2) {return 1;}  // if와 else if의 조건 순서를 반대로 넣었다가 실패의 아픔을 겪었다! 아래 if문이 더 짧음.

    return fibonacci(x-1)+fibonacci(x-2);
}

//0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597
console.log(fibonacci(input));
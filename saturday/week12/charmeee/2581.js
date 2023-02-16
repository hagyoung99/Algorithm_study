let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n').map((x)=>+x);

let prime = [];
let sum = 0;


for(let i = input[0]; i <= input[1]; i++){
    for(let j = 2; j <= i; j++){
        if(j*j > i){
            prime.push(i);
            sum += i;
            break;
        }
        if(i % j === 0){
            break;
        }
    }
}
if(prime.length === 0){
    console.log(-1);
}else{
    console.log(sum);
    console.log(prime[0]);
}
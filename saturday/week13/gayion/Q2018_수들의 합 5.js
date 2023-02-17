const input = require("fs").readFileSync("testInput.txt").toString().trim();

let answer = 0;

let start = 1;
let end = 1;
let sum = 1;

while(start <= end){
    if(sum == input) answer++;
    if(sum < input){
        end++;
        sum+=end;
    }else if(sum >= input){
        sum -= start;
        start++;
    };
};

console.log(answer);
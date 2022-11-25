const fs = require("fs");
let input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const iter = Number(input.shift());

let arr = [];

for(let i = 0; i < iter; i++){
    arr.push(input[i].split(" ").map((item) => Number(item)));
}

arr.sort((a,b) => {
    if(a[1] === b[1]){
        return a[0] - b[0]
    } else {
        return a[1] - b[1]
    }
});

let ans = [];

for(let i = 0; i < iter; i++){
    let answer = arr[i].join(" ");
    ans.push(answer);
}

console.log(ans.join("\n"));
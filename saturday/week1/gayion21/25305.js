const filePath = process.platform === 'linux' ? '/dev/stdin' : './testFile/25305.txt';
let input = require("fs").readFileSync(filePath).toString().trim().split('\n');

let input1 = input[0].trim().split(" ").map(num => +num);
let awardNum = input1[1];

let input2 = input[1].trim().split(" ").map(num => +num);
input2.sort((a, b) => b - a);


console.log(input2[awardNum-1]);

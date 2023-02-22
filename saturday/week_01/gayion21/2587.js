// 평균과 중앙값 구하기
const input = require("fs").readFileSync('/dev/stdin').toString().trim().split('\n').map(num => parseInt(num,10));
// const input = [20,80,70,10,60];


// 중앙값을 찾기 위해 오름차순으로 정렬
input = input.sort((a,b) => a-b);

console.log(input.reduce((num1,num2) => num1 + num2)/5);
console.log(input[Math.floor(input.length/2)]); // 그냥 2 입력해도 되잖아..

/*
const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});
let input = [];
rl.on("line", function (line) {
	input.push(line.toString());
}).on("close", function () {
	input = input.map((el) => Number(el));
    input.sort((a, b) => a - b);
let sum = input.reduce((past, curr) => past + curr, 0);

console.log(sum / 5 + "\n" + input[2]);
	process.exit();




*/
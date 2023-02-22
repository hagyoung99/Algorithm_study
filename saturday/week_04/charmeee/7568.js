let fs = require('fs');
let arr = fs.readFileSync('input.txt').toString().trim().split('\n');

let input = [];
for (let i = 1; i < arr.length; i++) {
    input.push(arr[i].split(' ').map((i)=>parseInt(i)));
}

let result = [];
for (let i = 0; i < input.length; i++) {
	let order = 1;
	for (let j = 0; j < input.length; j++) {
        if (input[i][0] < input[j][0] && input[i][1] < input[j][1]) order++;
	}
	result.push(order);
}

console.log(result.join(" "));
const input = require("fs").readFileSync("dev/stdin").toString().trim().split(/\s/);
const n = +input[0];

const nArr = input.slice(1, n + 1).map(Number);
const mArr = input.slice(n + 2).map(Number);

const map = new Map();
nArr.forEach((ele) => {
    if (map.has(ele)) { map.set(ele, map.get(ele) + 1) } else { map.set(ele, 1) }
})
let result = [];

mArr.forEach((ele) => {
    if (map.has(ele)) { result.push(map.get(ele)) } else { result.push(0) }
})


console.log(result.join(' '));
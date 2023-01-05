// const fs = require("fs");
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const input = ["ohhenrie",
    "charlie",
    "baesangwook",
    "obama",
    "baesangwook",
    "ohhenrie",
    "clinton"];

/* 

const input = ["ohhenrie",
    "charlie",
    "baesangwook",
    "obama",
    "baesangwook",
    "ohhenrie",
    "clinton"];

3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton
*/

// let count = input.shift().split(" ");  // [3,4]
let resultSet = new Set(input);
let result = [...resultSet];


console.log(result.length + "\n" + result.join("\n"));
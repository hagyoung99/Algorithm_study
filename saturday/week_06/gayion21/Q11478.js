const input = require("fs").readFileSync("dev/stdin").toString().trim().split(/\s/);

const s = input[0];
let str = new Set();  // set을 이용하여 중복되는 데이터는 넣지않도록 함
// abcab


// 신나는 완전탐색 시간
for (let i = 0; i < s.length; i++) {
    for (let j = i; j < s.length; j++) {
        str.add(s.substring(i, j + 1))
        // a ab abc abca abcab
        // b bc bca bcab
        // c ca cab
        // a ab
        // b
    }
}


console.log(str.size);  // output : 12
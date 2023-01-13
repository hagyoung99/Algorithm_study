const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const N = Number(input.shift());
let answer = "";

/*
DD
1
[42]

RRD
6
[1,1,2,3,5,8]

D
0
[]
*/
for (let i = 0; i < N; i++) { // 4
  let testcase = input.splice(0, 3);
  let isReverse = false;
  testcase[2] = testcase[2].slice(1, -1).split(",");

  for (let p of testcase[0]) { // RDD
    var flag = true;

    if (p == "R") isReverse = !isReverse;
    else if (p == "D") {
      if (testcase[1] == "0") {
        answer += "error\n";
        flag = !flag;
        break;
      }
      if (testcase[2].length == 0) {
        answer += "error\n";
        flag = !flag;
        break;
      }
      if (isReverse) testcase[2].pop();
      else testcase[2].shift();
    }
  }
  if (isReverse) testcase[2].reverse();
  if (flag) answer += "[" + testcase[2].join(",") + "]\n";
}

console.log(answer.trim());
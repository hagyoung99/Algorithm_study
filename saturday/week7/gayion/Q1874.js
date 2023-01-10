const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
/* 
  8
  4 3 6 8 7 5 2 1
*/
function getResult() {
  let m = 1;
  let stack = [];
  let result = [];

  for (let i = 1; i <= parseInt(input[0]); i++) {
    if (
      parseInt(input[i]) > (stack[stack.length - 1] === undefined ? 0 : stack[stack.length - 1])
      // stack에 마지막 배열에 숫자가 없거나, 있어도 input[i]가 더 크면
    ) {
      for (let j = m; j <= parseInt(input[i]); j++) {
        // input[i]와 같아질 때까지 stack에 숫자 추가 push
        stack.push(m++);
        result.push("+");
      }
    } else if (parseInt(input[i]) < stack[stack.length - 1]) {
      return "NO";
    }

    if (parseInt(input[i]) === stack[stack.length - 1]) {
      // input[i]와 stack의 마지막 수가 같아지면 pop
      result.push("-");
      stack.pop();
    }
  }
  return result.join("\n");
}

console.log(getResult());
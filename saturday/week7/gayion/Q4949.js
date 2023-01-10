const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.pop();

const solution = (sentences) => {
  const targets = '()[]';
  const answer = sentences.map((sentence) => {
    const stack = [];
    for (const ch of sentence) {
      if (!targets.includes(ch)) continue;
      if (ch === '(' || ch === '[') stack.push(ch);
      else if (ch === ')') {
        if (stack.length === 0 || stack[stack.length - 1] !== '(') return 'no';
        stack.pop();
      } else if (ch === ']') {
        if (stack.length === 0 || stack[stack.length - 1] !== '[') return 'no';
        stack.pop();
      }
    }
    if (stack.length !== 0) return 'no';
    return 'yes';
  });
  return answer.join('\n');
};

console.log(solution(input));
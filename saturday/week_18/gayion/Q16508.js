const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

const solution = (_input) => {
  let WORD = _input[0].split('');
  const N = parseInt(_input[1]);
  WORD = WORD.slice(0, WORD.length);

  const data = _input.slice(2);

  const count = new Array(26).fill(0);

  const select = new Array(26).fill(0);

  const books = [];

  WORD.forEach((alphabet) => {
    count[alphabet.charCodeAt(0) - 65]++;
  });

  data.forEach((info) => {
    const [price, book] = info.split(' ');
    const bbb = book.split('');
    books.push([bbb, parseInt(price)]);
  });

  let answer = Number.MAX_SAFE_INTEGER;

  const check = () => {
    for (let i = 0; i < 26; i++) {
      if (count[i] > select[i]) return false;
    }

    return true;
  };

  const dfs = (idx, total) => {
    if (idx >= N) {
      if (check()) answer = Math.min(answer, total);
      return;
    }

    for (let i = 0; i < books[idx][0].length; i++) {
      const alpha = books[idx][0][i];
      select[alpha.charCodeAt(0) - 65]++;
    }

    dfs(idx + 1, total + books[idx][1]);

    for (let i = 0; i < books[idx][0].length; i++) {
      const alpha = books[idx][0][i];
      select[alpha.charCodeAt(0) - 65]--;
    }

    dfs(idx + 1, total);
  };

  dfs(0, 0);

  if (answer === Number.MAX_SAFE_INTEGER) return -1;

  return answer;
};

console.log(solution(input));
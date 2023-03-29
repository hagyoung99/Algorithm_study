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

  WORD.forEach((alphabet) => { // 내가 만들고 싶은 문자열
    count[alphabet.charCodeAt(0) - 65]++; // 대문자 A의 아스키코드는 65!
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
    if (idx >= N) { // 책 갯수만큼
      if (check()) answer = Math.min(answer, total);
      return;
    }

    for (let i = 0; i < books[idx][0].length; i++) {  // 책 제목을 이루는 알파벳 갯수만큼 for문
      const alpha = books[idx][0][i];
      select[alpha.charCodeAt(0) - 65]++;
    }

    dfs(idx + 1, total + books[idx][1]);

    // idx번째 책을 선택하지 않을 경우 초기화?
    // 힣....제가 더 공부해볼게여...
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
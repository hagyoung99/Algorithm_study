const a = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const n = +a.shift();
const input = [...a].map(e => e.split(" ").map(Number));

const combinations = function* (elements, selectNumber) {
  for (let i = 0; i < elements.length; i++) {
    if (selectNumber === 1) {
      yield [elements[i]];
    } else {
      const fixed = elements[i];
      const rest = elements.slice(i + 1);
      for (const a of combinations(rest, selectNumber - 1)) {
        yield [fixed, ...a];
      }
    }
  }
};

const getValue = (team, input) => {
  let sum = 0;
  for (let i = 0; i < team.length; i++) {
    const from = team[i];
    for (let j = 0; j < team.length; j++) {
      const to = team[j];
      sum += input[from][to];
    }
  }
  return sum;
};

const solution = (n, input) => {
  let answer = Number.MAX_SAFE_INTEGER;
  let people = new Array(n).fill(0).map((e, i) => (e = i));
  for (let x of combinations(people, n / 2)) {
    const start = x;
    const link = [...people].filter((e) => !start.includes(e));

    let lt = getValue(start, input);
    let rt = getValue(link, input);
    answer = Math.min(Math.abs(lt - rt), answer);
  }

  return answer;
};
console.log(solution(n, input));
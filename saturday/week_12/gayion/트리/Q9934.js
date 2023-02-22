const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
// 첫째 줄에 트리의 레벨(깊이!)
// 둘째 줄에 트리 내 노드를 중위 순회한 배열

const N = Number(input[0]);
const data = input[1].split(' ').map(Number);

const solution = (N, data) => {
  const answer = Array.from(Array(N), () => new Array());
  
  const divide = (start, end, depth) => {
    if (depth === N) return;
    const mid = Math.floor((start + end) / 2);
    answer[depth].push(data[mid]);
    divide(start, mid - 1, depth + 1); // 왼쪽에 있는 친구들 (0,0,1)
    divide(mid + 1, end, depth + 1); // 오른쪽에 있는 친구들 (2,3,1)
  };
  
  /*
  answer[0] = [1]
  answer[1] = [23]
  
  */
  divide(0, data.length, 0);
  return answer.map((v) => v.join(' ')).join('\n');
};

console.log(solution(N, data));
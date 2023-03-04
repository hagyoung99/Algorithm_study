const fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath).toString().split("\n");
// 표준 입력으로 받아도 되고 mac 환경에선 input.txt로 받을 수 도 있게 해주는 코드
solution(input);

function solution(input) {
  let n = input[0].split(" ")[0] * 1; // * 1을 하면 숫자로된 문자열을 숫자로 바꿔줄 수 있다. "1" -> 1
  let m = input[0].split(" ")[1] * 1;
  const dotLocation = input[1]
    .split(" ")
    .map((e) => e * 1) // 요소 각각을 문자열에서 숫자로 바꿔줌
    .sort((a, b) => a - b); // 오름차순으로 정렬
  const lineLocation = [];
  const answer = []; // 정답 담을 배열
  for (let i = 0; i < m; i++) {
    lineLocation.push(input[i + 2].split(" ").map((e) => e * 1));
  }

  for (let i = 0; i < m; i++) {
    // 선분 하나하나씩 보면서 선분의 왼쪽 끝 바로 오른쪽에 있는 점, 오른쪽 끝 바로 왼쪽에 있는 점 을 찾으면 두 사이 곗수를 통해 쉽게 구하면 된다. 
    // 그러면 그 두 점을 이분탐색을 통해 찾는다.  레츠 고
    // 왼쪽 찾기
    let left_start = 0;
    let left_end = n - 1;
    let left = lineLocation[i][0];
    while (left_start <= left_end) {
      // 이분탐색할 때의 기준을 잘 세우는 것이 중요하다.
      let mid = parseInt((left_start + left_end) / 2);
      // parseInt를 통해 소수점을 버릴 수 있는데 이를 통해 몫을 구할 수 있다.
      dotLocation[mid] < left ? (left_start = mid + 1) : (left_end = mid - 1);
      // 삼항연산자는 if else를 축소해서 쓸 수 있는 좋은 도구다. ? 기준으로 앞에 문이 true면 : 기준 왼쪽이 실행되고 false면 : 기준 오른쪽이 실행된다.
    }
    // 이분탐색을 통해서 시작 점을 찾아준다.

    let right_start = 0;
    let right_end = n - 1;
    let right = lineLocation[i][1];
    while (right_start <= right_end) {
      let mid = parseInt((right_start + right_end) / 2);

      dotLocation[mid] > right
        ? (right_end = mid - 1)
        : (right_start = mid + 1);
    }
    // 이분탐색을 통해서 끝 점을 찾아준다.

    answer.push(right_end - left_end);
    // 원래 각 선분 별 for문에서 매번 console.log를 해줬는데 시간초과가 나서 배열에 받은 후 한번에 출력해줬다. console.log는 디버깅용 도구라 시간을 많이 소모한다하여 출력을 해야할 경우 한번에 출력하는 습관을 들이자!
  }
  console.log(answer.join("\n"))

}
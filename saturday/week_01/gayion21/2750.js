const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n'); // 다증 행 입력 받기
// 한 줄로 입력받을 경우          예제 파일 경로.text | /dev/stdin
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
// readFile : 비동기식    readFileSync : 동기식

input.shift();
// 전달받은 수의 개수부분 날려버리기~~!

input.sort((a, b) => a - b);  
// 첫 번째 요소가 두 번째 요소보다 우선순위가 높으면 음수를 반환, 낮으면 양수를 반환하고 같으면 0을 반환
// TimeSort 사용 : 시간복잡도 O(n log n), stable, in-place
// insertion sort와 merge sort를 결합하여 만든 정렬

for (let i = 0; i < input.length; i++) {
  console.log(input[i]);
  // 개행 문자 없이 한 줄로 출력
  // process.stdout.write();
}
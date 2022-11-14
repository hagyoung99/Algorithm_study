const fs = require("fs");
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n'); // 다증 행 입력 받기
// 한 줄로 입력받을 경우          예제 파일 경로.text | /dev/stdin
// const input = fs.readFileSync('/dev/stdin').toString().trim().split(' ');
// readFile : 비동기식    readFileSync : 동기식

input.shift();
// 전달받은 수의 개수부분 날려버리기~~!

input.sort((a, b) => a - b);  // 화살표 함수로 오름차순 표현

for (let i = 0; i < input.length; i++) {
  console.log(input[i]);
  // 개행 문자 없이 한 줄로 출력
  // process.stdout.write();
}
const input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');
const N = +input[0];
let files = input.slice(1).toString().split(' ').map(Number);
// 이 문제는 정렬 후 이진탐색을 하면 됨!


function binarySearch(key){ // 검사해야하는 파일의 수를 구하자.
  let ans = 0;
  let left = 0;
  let right = key;

  /// key는 큰 파일.
  while(left <= right){
    let mid = parseInt((left+right)/2);
    if(files[mid] >= files[key]*0.9 && mid !== key) { // 검사해야하는것들.
      right = mid - 1;
      ans = key - mid;
    } else { 
      left = mid + 1;
    }
  }

  return ans;
}
function sol(){
  let answer = 0;

  files.sort((a,b) => {
    if(a<b) return -1;
    else if(a>b) return 1;
    return 0;
  })
  for(let i=0; i<files.length; i++) {
    answer += binarySearch(i);
  }
  return console.log(answer);
} 
sol();
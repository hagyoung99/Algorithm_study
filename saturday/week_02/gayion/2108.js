let input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');

let arr = input.map(Number);
let length = arr.shift();

// 산술평균
let a = arr.reduce((a, b) => a + b, 0);
let avg = Math.round(a / length);

// 중앙값
arr.sort((a, b) => a - b);
let answer = (length % 2 === 0 ? arr[length / 2] + arr[(length / 2) - 1] : arr[Math.floor(length / 2)])

// 최빈값 데이터 집합에서 가장 많이 등장하는 값, 여러개 있을때 두번째로 작은값 출력
function getMostValue() {
    const map = new Map();
    for (let i in arr) {
        if (!map.has(arr[i])) {
            map.set(arr[i], 1) // key, value 저장
        } else {
            map.set(arr[i], map.get(arr[i]) + 1) // value + 1   중복되면 빈도수 추가, get은 value불러옴 아하
        }
    }
    let maxValue = 0;
    let arr2 = [];
    map.forEach((ele, key) => {
        if (maxValue < ele) {
            maxValue = ele;
            arr2 = []; // 배열 리셋
            arr2.push(key); // 반도수가 큰 것만 배열에 추가
        } else if (maxValue === map.get(key)) {
            arr2.push(key); // 빈도수가 똑같다면 전부 배열에 추가하기
        }
    })
    return arr2.length !== 1 ? arr2[1] : arr2[0]; // 배열의 길이가 1이 아니라면 두번째로 작은 최빈값 출력
}


// 범위
let max = Math.max(...arr);
let min = Math.min(...arr);
let range = max - min;


console.log(avg === -0? 0 : avg);
console.log(answer);
console.log(getMostValue());
console.log(range);
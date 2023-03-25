const fs = require('fs');
let input = fs.readFileSync('백준/Q2961/input.txt').toString().split('\n');
const n = parseInt(input[0]) // 재료의 갯수
let arr = [] // 재료 인덱스
let sour_list = [] // 재료별 신 맛
let bitter_list = [] // 재료별 쓴 맛
let food_combination=[]

for (let i = 0; i < n; i++){
    arr.push(i)
}

for (let i = 1; i < n+1; i++){
    sour_list.push(input[i].split('')[0])
    bitter_list.push(input[i].split('')[2])
}

sour_list = sour_list.map((num)=> parseInt(num));
bitter_list = bitter_list.map((num)=> parseInt(num));

result = 1,000,000,000 // 제일 작은 신맛과 쓴맛의 차이

const getCombinations = function (arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((el) => [el]); 
    // n개중에서 1개 선택할 때(nC1), 바로 모든 배열의 원소 return

    arr.forEach((fixed, index, origin) => {
        const rest = origin.slice(index + 1); 
        // 해당하는 fixed를 제외한 나머지 뒤
        const combinations = getCombinations(rest, selectNumber - 1); 
        // 나머지에 대해서 조합을 구한다.
        const attached = combinations.map((el) => [fixed, ...el]); 
        //  돌아온 조합에 떼 놓은(fixed) 값 붙이기
        results.push(...attached); 
        // 배열 spread syntax 로 모두다 push
    });

    return results; // 결과 담긴 results return
}

// 출처 : https://velog.io/@devjade/JavaScript%EB%A1%9C-%EC%88%9C%EC%97%B4%EA%B3%BC-%EC%A1%B0%ED%95%A9-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0

// n개의 재료로 만들수 있는 모든 조합
for (let i = 1; i < n+1; i++){
    food_combination.push(getCombinations(arr, i))
}

// console.log(food_combination)

for (let i of food_combination) {
    // console.log(i)
    for (let j of i){
        // console.log(j)
        let s = 1
        let b = 0
        for(let k of j){
            s = s * sour_list[k]; // j번째 신맛 재료 선택
            b = b + bitter_list[k] // j번째 신맛 재료 선택
        }
        if( Math.abs(s-b) < result) result = abs(s-b)
    }
}

console.log(result)
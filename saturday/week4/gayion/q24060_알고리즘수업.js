let fs = require("fs");
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

let input = fs
  .readFileSync(filePath)
  .toString()
  .trim()
  .split("\n")
  .map((v) => v.split(" ").map((v) => +v));

const [[N, K], arr] = input;

// N = arr.length
// K -> 배열 merge과정에서 K번째 저장되는 수를 구해야 함.

const merge = (arr1, arr2) => {
  let result = [];
  let [i, j] = [0, 0];

  while (i < arr1.length && j < arr2.length) {
    if (arr1[i] < arr2[j]) {
      result.push(arr1[i]);
      i++;
    } else {
      result.push(arr2[j]);
      j++;
    }
    count++;
    if (count === K) target = result[result.length - 1];
  }

  while (i < arr1.length) {
    result.push(arr1[i]);
    i++;
    count++;
    if (count === K) target = result[result.length - 1];
  }

  while (j < arr2.length) {
    result.push(arr2[j]);
    j++;
    count++;
    if (count === K) target = result[result.length - 1];
  }
  return result;
};

let count = 0;
let target;
const mergeSort = (arr) => {
  if (arr.length <= 1) return arr;
  let mid = Math.ceil(arr.length / 2);
  let left = mergeSort(arr.slice(0, mid));
  let right = mergeSort(arr.slice(mid));
  return merge(left, right);
};

mergeSort(arr);
if (!target) target = -1;
console.log(target);


// const fs = require("fs");
// // const input = Number(fs.readFileSync('/dev/stdin').toString().trim().split('\n'));
// const input = "5 7\n4 5 1 3 2".toString().trim().split('\n');
// const input0 = input.shift().trim().split(" ");

// const arr = input.toString().trim().split(" ").map(n=>Number(n));
// const end = input0[0];  // 원소 갯수 : 5
// const k = input0[1];   // k번째 : 7

// // 저장횟수와 k번째 수를 저장할 변수
// let count = 0;
// let result = [];

// function mergeSort(arr) {

//     if (arr.length === 1) return arr;
    
//     const mid = Math.ceil(arr.length/2);
//     const left = arr.slice(0,mid);
//     const right = arr.slice(mid);
    
//     return merge(mergeSort(left), mergeSort(right));
//   }

//   function merge(left, right) {
//     const sortedArr = [];

//     while (left.length && right.length) {
//       if (left[0] <= right[0]) {
//         count++;
//         sortedArr.push(left.shift());
//         result.push(left.shift());
//       } else {
//         count++;
//         sortedArr.push(right.shift());
//         result.push(right.shift());
//       }
//     }

//     return [...sortedArr, ...left, ...right];
//   }

// mergeSort(arr);

// // count<k?console.log(-1):console.log("시방 뭐야");
// console.log(count, result);
const read = `6 8  5 3  5 2  6 4
5 6  0 0

8 1  7 3  6 2  8 9  7 5
7 4  7 8  7 6  0 0

3 8  6 8  6 4
5 3  5 6  5 2  0 0
-1 -1`;

const input = read.toString().trim();

console.log(input);

// 시도
// // 1.
// const arr = Array.from({ length: n + 1 }, (_, i) => i);

// arr[0] = Infinity;
// arr[1] = Infinity;

// const filtered = [];

// function solution(arr) {
//   for (let i = 2; i < arr.length; i++) {
//     if (filtered.length - 1 === k) break;

//     // 2.
//     const min = Math.min(...arr);

//     // 3. 4.
//     if (min !== Infinity) {
//       filtered.push(min);
//       arr[min] = Infinity;
//     }

//     for (let j = 2 * i; j < arr.length; j += i) {
//       if (filtered.length - 1 === k) break;

//       if (arr[j] !== Infinity) {
//         filtered.push(arr[j]);
//         arr[j] = Infinity;
//       }
//     }
//   }
// }

// solution(arr);

// console.log(n === 1 ? 1 : filtered[k - 1]);

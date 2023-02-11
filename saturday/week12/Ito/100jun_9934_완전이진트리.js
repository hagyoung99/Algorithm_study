const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const K = +input.shift();
const paper = input[0].split(" ").map(Number);

const mid = getMid(paper);
const split = makeArr(paper, mid);

let result = `${mid}\n`;

search(split);

function search(arr) {
  const queue = [...arr];
  const next = [];

  while (queue.length) {
    const el = queue.shift();
    const mid = getMid(el);

    result += `${mid} `;

    const splitedArr = makeArr(el, mid);
    if (!splitedArr) continue;
    next.push(...splitedArr);
  }

  if (!next.length) {
    console.log(result);
    return;
  }
  result += "\n";
  search(next);
}

function getMid(arr) {
  return arr[Math.floor(arr.length - 1) / 2];
}

function makeArr(arr, m) {
  if (arr.length < 2) return;

  const left = arr.slice(0, arr.indexOf(m));
  const right = arr.slice(arr.indexOf(m) + 1);
  return [left, right];
}

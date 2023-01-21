const fs = require('fs');
const [_, ...input] = fs.readFileSync("./dev/stdin").toString().trim().split("\n");

const num = input.map(v => +v);

class MaxHeap {
  constructor() {
    this.heap = [];
  }

  empty() {
    if (this.heap.length == 0) {
      return true;
    }
    return false;
  }

  insert(value) {
    this.heap.push(value);
    this.bubbleUp();
  }

  bubbleUp() {
    let currentIndex = this.heap.length - 1;

    while (currentIndex > 0) {
      const parentIndex = Math.floor((currentIndex - 1) / 2);

      if (this.heap[parentIndex] >= this.heap[currentIndex]) break;

      [this.heap[currentIndex], this.heap[parentIndex]] = [
        this.heap[parentIndex],
        this.heap[currentIndex],
      ];
      currentIndex = parentIndex;
    }
  }

  extractMax() {
    if (this.heap.length == 1) {
      return this.heap.pop();
    }
    const max = this.heap[0];
    this.heap[0] = this.heap.pop();
    this.sinkDown(0);

    return max;
  }

  sinkDown(index) {
    const leftIndex = 2 * index + 1;
    const rightIndex = 2 * index + 2;
    const length = this.heap.length;
    let largestIndex = index;

    if (leftIndex < length && this.heap[leftIndex] > this.heap[largestIndex]) {
      largestIndex = leftIndex;
    }

    if (rightIndex < length && this.heap[rightIndex] > this.heap[largestIndex]) {
      largestIndex = rightIndex;
    }

    if (largestIndex !== index) {
      [this.heap[index], this.heap[largestIndex]] = [this.heap[largestIndex], this.heap[index]]
      [this.heap[index], this.heap[largestIndex]] = [this.heap[largestIndex], this.heap[index]]
      this.sinkDown(largestIndex);
    }
  }
}

const answer = [];
const maxHeap = new MaxHeap();
num.forEach(v => {
  if (v == 0) {
    if (maxHeap.empty()) {
      answer.push(0);
    } else {
      answer.push(maxHeap.extractMax());
    }
  } else {
    maxHeap.insert(v);
  }
})

console.log(answer.join('\n'));
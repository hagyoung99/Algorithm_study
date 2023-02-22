let fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let n = +input[0]
let operations = []
for (let i = 1; i < input.length; i++) {
    operations.push(+input[i])
}

class AbsHeap {
    constructor() {
        this.nodes = []
    }

    insert(data) {
        this.nodes.push(data)
        this.bubbleUp()
    }

    setAbs(data) {
        return Math.abs(data)
    }

    bubbleUp(index = this.nodes.length - 1) {
        if (index < 1) return
        let currentNode = this.nodes[index]
        let parentIndex = Math.floor((index - 1) / 2)
        let parentNode = this.nodes[parentIndex]

        const absParent = this.setAbs(parentNode)
        const absCurrent = this.setAbs(currentNode)
        if (absParent < absCurrent) return
        if (absParent === absCurrent) {
            if (parentNode < currentNode) return
            this.nodes[index] = parentNode
            this.nodes[parentIndex] = currentNode
            index = parentIndex
        }
        this.nodes[index] = parentNode
        this.nodes[parentIndex] = currentNode
        index = parentIndex
        this.bubbleUp(index)
    }

    extract() {
        const absMin = this.nodes[0]
        if (this.nodes.length === 1) {
            this.nodes.pop()
            return absMin
        }
        this.nodes[0] = this.nodes.pop()
        this.trickleDown()
        return absMin
    }

    trickleDown(index = 0) {
        let leftChildIndex = index * 2 + 1
        let rightChildIndex = index * 2 + 2

        let current = index

        if (!this.nodes[leftChildIndex] && !this.nodes[rightChildIndex]) return

        const absLeftChild = this.setAbs(this.nodes[leftChildIndex])
        let absCurrent = this.setAbs(this.nodes[current])

        if (!this.nodes[rightChildIndex]) {
            // no right child
            if (absLeftChild < absCurrent) {
                current = leftChildIndex
            }
            if (absLeftChild === absCurrent) {
                if (this.nodes[leftChildIndex] < this.nodes[current]) {
                    current = leftChildIndex
                }
            }
        } else {
            // left, right child 
            const absRightChild = this.setAbs(this.nodes[rightChildIndex])
            if (absLeftChild > absRightChild) {
                // absleft > absright 
                if (absRightChild < absCurrent) {
                    current = rightChildIndex
                }
                if (absRightChild === absCurrent) {
                    if (this.nodes[rightChildIndex] < this.nodes[current]) {
                        current = rightChildIndex
                    }
                }
            } else if (absLeftChild === absRightChild) {
                //  absleft == absright 
                let t = this.nodes[leftChildIndex] - this.nodes[rightChildIndex]
                if (t > 0) {
                    // left > right 
                    if (absRightChild < absCurrent) {
                        current = rightChildIndex
                    }
                    if (absRightChild === absCurrent) {
                        if (this.nodes[rightChildIndex] < this.nodes[current]) {
                            current = rightChildIndex
                        }
                    } 
                } else {
                    // left <= right 
                    if (absLeftChild < absCurrent) {
                        current = leftChildIndex
                    }
                    if (absLeftChild === absCurrent) {
                        if (this.nodes[leftChildIndex] < this.nodes[current]) {
                            current = leftChildIndex
                        }
                    }
                }
            } else {
                // absleft < absright
                if (absLeftChild < absCurrent) {
                    current = leftChildIndex
                }
                if (absLeftChild === absCurrent) {
                    if (this.nodes[leftChildIndex] < this.nodes[current]) {
                        current = leftChildIndex
                    }
                }
            }
        }

        if (index !== current) {
            let t = this.nodes[current]
            this.nodes[current] = this.nodes[index]
            this.nodes[index] = t
            this.trickleDown(current)
        }
    }
}

const heap = new AbsHeap()
let answer = ''

operations.forEach((e, index) => {
    if (e !== 0) {
        heap.insert(e)
    } else {
        if (heap.nodes.length === 0) {
            answer += '0' + '\n'
        } else {
            let t = heap.extract()
            answer += t + '\n';
        }
    }
})

console.log(answer.trim())
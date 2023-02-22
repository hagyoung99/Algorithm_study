let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const n = parseInt(input.shift())

class Node{
    constructor(value){
        this.value=value;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList{
    constructor(){
        this.head = null;
        this.tail = null;
        this._size = 0;
    }

    add(value){
        const newNode = new Node(value);

        if(!this.head)
            this.head = newNode;
        else{
            this.tail.next = newNode
            newNode.prev = this.tail
        }

        this.tail = newNode
        this._size++;

        return newNode;
    }

    getHead(){
        return this.head.value;
    }

    removeHead(){
        this.head = this.head.next;
        this.head.prev = null;
        this._size--;
    }
    getSize(){
        return this._size;
    }
}

const node = new LinkedList();

for(let i=1; i<=n;i++){
    node.add(i);
}
while(node.getSize() !==1){
    node.removeHead();
    node.add(node.getHead());
    node.removeHead();
}

console.log(node.getHead());
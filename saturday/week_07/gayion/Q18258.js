const fs = require('fs');
const [n,...arr] = fs.readFileSync("./dev/stdin").toString().trim().split("\n");


class Node{
    constructor(item){
      this.item = item;
      this.next = null;
    }
  }
  
  class Queue{
    constructor(){
      this.head = null;
      this.tail = null;
      this.length = 0;
    }
  
    push(item){
      const node = new Node(item)
      if(this.head===null){
        this.head= node;
        this.head.next = null;
      }else{
        this.tail.next = node;
      }
  
      this.tail = node;
      this.length +=1;
    }
  
    pop(){
        if(this.empty()==1) return -1
      const popItem = this.head;
      this.head = this.head.next;
      this.length -=1;
      return popItem.item;
    }
  
    size(){
      return this.length;
    }
  
    empty(){
      if(this.length==0){
        return 1;
      }else{
        return 0;
      }
    }
  
    front(){
      if(this.empty()==1) return -1;
      return this.head.item; 
    }
  
    back(){
      if(this.empty()==1) return -1;
      return this.tail.item; 
    }
  }
  




let answer = [];
let queue = new Queue(); 
const command = arr.map(v=>v.split(' '));
command.forEach(v=>{
    switch(v[0]){
        case 'push':
            queue.push(v[1])
            break;
        case 'pop':
            answer.push(queue.pop());
            break;
        case 'size':
            answer.push(queue.size())
            break;
        case 'empty':
            answer.push(queue.empty())
            break;
        case 'front':
            answer.push(queue.front())
            break;
        case 'back':
            answer.push(queue.back())
            break;
    }
})

console.log(answer.join('\n'))
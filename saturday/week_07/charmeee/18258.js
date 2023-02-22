let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let queue = [];
let output = '';
let queueIndex = 0;
for (let i of input){
    let size =queue.length-queueIndex;
    if(Number(i)) continue;
    let arr = i.split(' ');
    
    //console.log(queue);
    //console.log(queueIndex);
    //console.log("size :"+ size);
    //console.log(i)
    switch(arr[0]){
        case "push":
            queue.push(arr[1]);
            break;
        case "pop":
            output+=((queue[queueIndex]??-1)+'\n');
            if(queueIndex<queue.length)queueIndex++;
            break;
        case "size":
            output+=(size+'\n');
            break;
        case "empty":
            output+=((size===0?1:0)+'\n');
            break;
        case "front":
            output+=((size!==0?queue[queueIndex]:-1)+'\n')
            break;
        case "back":
            output+=((size!==0?queue[queue.length-1]:-1)+'\n')
            break;
    }
}

console.log(output);
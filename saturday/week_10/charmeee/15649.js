let fs = require('fs');
let [num,depth] = fs.readFileSync('input.txt').toString().trim().split(' ').map(x=>+x);

let visited = new Array(num).fill(0); //방문 안했다면 0, 방문시 1
let arr = new Array(depth);
let output ='';
function sequence(d){
    
    if(d>=depth){
        for(let x of arr){
            output+=(+x)+' '
        }
        return output+='\n';
    }
    for(let i in visited){
        if(visited[i]===0){
           // console.log(i + ' | '+d);
            visited[i]=1;
            arr[d]=+i+1;
            sequence(d+1);
            visited[i]=0;
        }
    }
}

sequence(0);

console.log(output);

/*
0 0 0
1 1 0
1 0 1
*/
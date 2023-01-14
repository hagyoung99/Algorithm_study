const fs = require('fs');
const [input1,...input2] = fs.readFileSync("input.txt").toString().trim().split("\n");

const [,router] = input1.split(' ').map(v=>+v); 

let node=input2.map(v=>+v).sort();
let first = node[0];
node = node.map(v=>v-first)
let min = node[0];
let mid = 0; 
let max = node[node.length-1]
let output = 0;

while(min<=max){
  mid = Math.floor((min+max)/2);
  let cnt =1;
  let pre=node[0];
  for(let i = 1; i<node.length; i++){
    if(node[i]-pre>=mid){
      cnt++;
      pre = node[i];
    }
  }
  if(cnt<router){//거리좁힌다 개수만큼못햇을때
    max = mid-1;
  }else{
    min = mid+1;
    if(mid>output) output = mid;
  }
}
console.log(output)
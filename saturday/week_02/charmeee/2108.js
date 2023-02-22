let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().split('\n');

let input = [];

for (let i = 0; i < tmp.length; i++) {
  if (tmp[i] !== '') {
    input.push(tmp[i].split(' '));
  }
}

input=input.map((i)=>parseInt(i));




let length = input[0];
input.shift();

if(length>1){
    input.sort(function(a,b){
        return a-b;
    });
}



let average = 0;//평균값
let middle;//중앙값
let mode = [];//최빈값
let mode_fre=1;//최빈값 횟수
let diff = input[length-1]-input[0];

for(let i = 0; i<length;i++){
    console.log(input[i]);
    average+=input[i];//총합구하기
    if(i===parseInt(length/2)){
        middle = input[i];//중앙값구하기
    }
}
average=parseInt(Math.round(average/length));

//최빈값 구하는 함수
for(let i = 0; i<length;i++){
    let j = i;
    let num = 1;
   while(i+1<length&&input[j]===input[i+1]){
    num++;
    i++;
   };
   console.log("mode_fre: %d,i: %d , num: %d, input[t]: %d",mode_fre,i,num,input[j]);
   if(num===mode_fre){
    mode.push(input[j]);
   }
   if(num>mode_fre){
    mode=[input[j]];
    mode_fre=num;
   }
}

console.log("-------------");

console.log(average);
console.log(middle);
console.log((mode.length>1)?mode[1]:mode[0]);
console.log(diff);
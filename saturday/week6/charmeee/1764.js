let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
let [num1,num2]=input[0].split(' ').map((i)=>parseInt(i));
let set1 = new Set(input.slice(1,1+num1));
let set2 = new Set(input.slice(1+num1));
//걸리는 시간 set.has() <array.includes() 
//set 은 그냥 반복문은안된다

let output =[];
let count = 0;
if(num1<num2){
    set1.forEach((i)=>{
        if(set2.has(i)){
            output.push(i);
            count++;
        }
    })
}else{
    set2.forEach((i)=>{
        if(set1.has(i)){
            output.push(i);
            count++;
        }
    })
}

console.log(count+'\n'+output.sort().join('\n'))

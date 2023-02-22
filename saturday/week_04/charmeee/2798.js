let fs = require('fs');
let arr = fs.readFileSync('input.txt').toString().trim().split('\n');

let input = [];
for (let i = 0; i < arr.length; i++) {
    input.push(arr[i].split(' ').map((i)=>parseInt(i)));
}
let limit = input[0][1];
let max = 0;

function find_max(A,now,sum,dep){
    if(sum>limit) return;
    if(dep===3){
        //console.log("sum "+sum)
        if(sum>max){
            max=sum;
        }
        return;
    }
    for(let i = now; i < input[0][0]; i++){
        //console.log(`now ${now} | sum ${sum} | dep ${dep} | i ${i}`)
        //console.log(A[i])
        find_max(A,i+1,sum+A[i],dep+1);
    } 
}

find_max(input[1],0,0,0);
console.log(max);
  
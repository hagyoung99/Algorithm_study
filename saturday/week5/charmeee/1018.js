let fs = require('fs');
let arr = fs.readFileSync('input.txt').toString().trim().split('\n');

let index =arr.shift().split(' ').map((data)=>Number(data));
const word=['W','B'];
let min = 999999;
for(let i =0; i<index[0]-7;i++){//세로
    for(let j =0; j<index[1]-7;j++){//가로
        let count1 = 0;
        let count2 = 0;
        for(let y =i; y<i+8;y++){//세로
            for(let x =j; x<j+8;x++){//가로
                if((y+x)%2==0){
                    if(arr[y][x]==word[0]) count1++;
                    if(arr[y][x]==word[1]) count2++;
                }else{
                    if(arr[y][x]==word[1]) count1++;
                    if(arr[y][x]==word[0]) count2++;
                }
            }
        }
        if(min>count1) min=count1;
        if(min>count2) min=count2;
    }
}
console.log(min);
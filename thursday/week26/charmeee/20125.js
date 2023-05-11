/*
그렇다고한다..
자기자신 2
111
111
111
머리 
000
010
111

*/

let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let arr = []
for(let i = 1;i<input.length;i++){
    arr.push(input[i].split('').map(function(x){
        if(x==='*'){
            return 1;
        }
        return 0;
    }))
}

// console.log(arr);
let head = [];

function checkHead(y,x){
    if(x-1<0) return false;
    if(x+1>arr.length-1) return false;
    if(arr[y+1][x]&&arr[y+1][x-1]&&arr[y+1][x+1]){
        return true;
    }
    return false;
}

for(let i = 0;i<input.length;i++){
    for(let j = 0;j<input.length;j++){
        if(arr[i][j]==1){
            if(checkHead(i,j)){
                head = [i,j];
                break;
            }
        }
    }
    if(head.length!=0) break;
}

let heart = [head[0]+1,head[1]];
//start to end
let leftArm = 0;
let rightArm = 0;
let waist = 0;
let numA = 1;
//좌팔 우팔 허리 왼다 오다
while(leftArm==0||rightArm==0||waist==0){
    if(leftArm==0&&arr[heart[0]][heart[1]-numA]==0){
        leftArm=numA-1;
    }
    if(leftArm==0&&heart[1]-numA<=0){
        leftArm=numA;
    }
    if(rightArm==0&&heart[1]+numA<arr.length&&arr[heart[0]][heart[1]+numA]==0){
        rightArm=numA-1;
    }
    if(rightArm==0&&heart[1]+numA>=arr.length-1){
        rightArm=numA;
    }
    if(waist==0&&arr[heart[0]+numA][heart[1]]==0){
        waist=numA-1;
    }
    if(waist==0&&heart[0]+numA>=arr.length-1){
        waist=numA;
    }
    numA++;
}
// console.log(leftArm,rightArm,waist);
let leftLeg = 0;
let rightLeg = 0;
let numB = 1;
while(leftLeg==0||rightLeg==0){
    let y = heart[0]+waist+numB;
    // console.log('y',y);
    // console.log(arr.length)
    // console.log('arm',leftLeg,rightLeg)
    if(leftLeg==0&&arr[y][heart[1]-1]==0){
        leftLeg=numB-1;
    }
    if(rightLeg==0&&arr[y][heart[1]+1]==0){
        rightLeg=numB-1;
    }
    if(y>=arr.length-1){
        if(leftLeg==0) leftLeg=numB;
        if(rightLeg==0) rightLeg=numB;
    }
    numB++;
}
console.log(heart[0]+1,heart[1]+1)
console.log(leftArm,rightArm,waist,leftLeg,rightLeg);
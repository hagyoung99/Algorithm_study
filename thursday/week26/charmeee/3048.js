//js쓴지 오래되서 다까먹엇을듯ㅋ
/*
ABC DEF
CBADEF
CBDAEF
CDBEAF
DCEBFA
D
{
    letter:'A',
    move:1,
}
자기 주변에 나와다른 movement를 지닌사람이있으면 움직여야함.

*/

function group(letter,move){
    this.letter=letter;
    this.move=move;
}

let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');
let arr = input[1].split('').reverse().map(x=>new group(x,1));
arr.push(...input[2].split('').map(x=>new group(x,-1)));
let limit = +input[3];
let num = 0;


while(num<limit){
    for(let i =0 ;i<arr.length-1;i++){
        let right = i+1;
        if(arr[i].move==1&&arr[right].move==-1){
            let tmp = arr[i]
            arr[i]=arr[right]
            arr[right]=tmp
            //swipe
            i++;
        }
    }
    num++;
    // console.log(arr)
    // console.log(num)
}

console.log(arr.reduce((acc,cur)=>acc+cur.letter,''));

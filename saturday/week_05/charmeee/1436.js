/*
1 - 666
9개 1666
9개 6661 9+9-1 17
(1~5)666 666(1~5) 6666 666(7~9) (7~9)666
5   5   1   3   3
1~5   6~10  11  12~14  15~17
0~4    5~9    10    11~13   14~16
*/
let fs = require('fs');
let num,a,i=666,c_n=0;
num = Number(fs.readFileSync('input.txt').toString().trim()); //type String

while(num!==c_n){
    a=i;
    let check=0;
    while(a!=0){
      if(a%10==6){
        check++;
      }else{check=0;}
      a=parseInt(a/10);
      if(check==3){c_n++;}
    }
    i++;
}
console.log(i-1);

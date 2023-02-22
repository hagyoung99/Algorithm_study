let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().trim().split('\n');

let input = [];
let length = parseInt(tmp[0]);
let result = '';

for (let i = 1; i < length+1; i++) {
  if (tmp[i] !== '') {
    input.push(tmp[i].split(' ').map((i)=>parseInt(i)));
  }
}
input.sort(function(a,b){

    if(a[0]===b[0]){
        return a[1]-b[1];
    }

    return a[0]-b[0];

}).forEach( (i)=>
    {result +=  `${i[0]} ${i[1]}\n`;
}
);

console.log(result);
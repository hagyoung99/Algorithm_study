let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let A = input[1].split(' ').map((x)=>+x);
let B = input[2].split(' ').map((x)=>+x);

let a_ind=0;
let b_ind=0;



let output='';

console.log(A);
console.log(B);
while(a_ind<A.length||b_ind<B.length){
    if(b_ind>=B.length){
        output+=A[a_ind]+' ';
        a_ind++;
        continue;
    }
    if(a_ind>=A.length){
        output+=B[b_ind]+' ';
        b_ind++;
        continue;
    }
    if(A[a_ind]<B[b_ind]){
        output+=A[a_ind]+' ';
        a_ind++;
    }else{
        output+=B[b_ind]+' ';
        b_ind++;
    }
}

console.log(output);
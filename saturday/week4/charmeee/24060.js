let fs = require('fs');
let arr = fs.readFileSync('input.txt').toString().trim().split('\n');

let input = [];
let tmp =[0];
let count =0;
for (let i = 0; i < arr.length; i++) {
  if (arr[i] !== '') {
    input.push(arr[i].split(' ').map((i)=>parseInt(i)));
  }
}


merge_sort(input[1],0,input[0][0]-1);
if(count<input[0][1]){
    console.log(-1);
}

function merge_sort(A,p,r){
    if(p<r){
        var q=Math.floor((p+r)/2);
        merge_sort(A,p,q);
        merge_sort(A,q+1,r);
        merge(A,p,q,r);
    
    }
}

function merge(A,p,q,r){
    //console.log(`merge! p=${p} q=${q} r=${r}`)
    var i = p;var j=q+1;var t=1;
    while(i<=q&&j<=r){
        if(A[i]<=A[j]){
            tmp[t++]=A[i++];
        }else{
            tmp[t++]=A[j++];
        }
    }
    while(i<=q){//왼쪽 배열.
        tmp[t++]=A[i++];
    }
    while(j<=r){//오른쪽 배열
        tmp[t++]=A[j++];
    }
    i=p;t=1;
    
    while(i<=r&&count<input[0][1]){//결과 저장
        var num = tmp[t];
        //console.log(num,"|",count);
        A[i++]=tmp[t++];
        //console.log(A)
        count++;
        if(count==input[0][1]){
            console.log(num);
        }
    }
}
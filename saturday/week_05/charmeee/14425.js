let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let [s_num,c_num]=input[0].split(' ').map((i)=>parseInt(i));
let s_arr = input.slice(1,1+s_num);
let c_arr = input.slice(1+s_num,c_num+s_num+1);

let cnt=s_index=c_index=0;

s_arr.sort();
c_arr.sort();


while(s_index<s_num&&c_index<c_num){
    if(s_arr[s_index]<c_arr[c_index]){
        s_index++; continue;
    }
    if(s_arr[s_index]===c_arr[c_index]){
        cnt++;
    }
    c_index++;
}
console.log(cnt);

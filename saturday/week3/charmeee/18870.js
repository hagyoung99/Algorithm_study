let fs = require('fs');
let tmp = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let input = tmp[1].split(' ').map((i)=>parseInt(i));

let length = parseInt(tmp.shift());
let set =new Set(input);
let sortedArr = Array.from(set).sort((a,b)=> a-b);


let output ='';
//그냥하면 문자열이여서 문자열앞자리숫자와 비교하게 되어 제대로된 결과가 안나온다.
function binarySearch(arr,target){
    let min = 0;
    let max = arr.length - 1;
  
    while (min <= max) {
      let mid =parseInt((min + max) / 2);
      let current = arr[mid]; //배열의 중간원소
      //console.log('current',current,'|','target',target,'|','min',min,'|','max',max,'|','mid',mid);
      if(current ===target){
        return mid;
      }
      if (current < target) { 
        min = mid + 1;
      } else if (current > target) { 
        max = mid - 1; 
      } 
    }
    return -5;
  };

for(let j=0;j<input.length;j++){
    output+=(binarySearch(sortedArr,input[j])+' ');
}
console.log(output);
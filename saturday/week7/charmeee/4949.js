let fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
input.pop();
let output =""
for( let i of input){
    if(i==='.') break;
    let arr = i.split('');
    if(arr[arr.length-1]!=='.') {
        output+='no\n';
        continue;
    }
    let str = arr.filter((x)=>(x==='('||x===')'||x==='['||x===']')).join('');
    // console.log("-----------------------");
    // console.log(str);
    while(str.length>0){
        let tmp = str.length;
        str = str.replaceAll('()','');
        str = str.replaceAll('[]','');
        // console.log(str);
        if(str.length===tmp) break;
    }
    str.length===0?output+="yes\n":output+="no\n"
}
console.log(output)

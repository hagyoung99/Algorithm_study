
let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().trim().split('\n');

let k = parseInt(tmp[0]);
let input=tmp[1].split(' ').map((x)=>+x);
let tree = [];
for(let i = 0 ; i< k ; i++){
    tree.push([]);
}
function getTree(depth,start,end){
    if(depth>=k) return;
    if(start===end) tree[d].push(input[start]);return;
    let mid = parseInt((start+end)/2);
    if(mid<0||mid>=input.length) return;
    tree[d].push(input[start]);
    getTree(depth+1,start,mid-1);
    getTree(depth+1,mid+1,end);
}

getTree(0,0,input.length-1);
let output = '';
for(let i = 0 ; i< k ; i++){
    for(let j of tree[i]){
        output+=(j+' ');
    }
    output+='\n';
}
console.log(output);

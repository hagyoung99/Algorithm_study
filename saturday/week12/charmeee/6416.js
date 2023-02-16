let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().trim().replaceAll("\n", "");
tmp=tmp.replaceAll(' ','');
let input = []; //정제된 인풋값
let source = [];
let nodeList = [];
let node = new Set();
for(let i = 0;i<tmp.length;i+=2){
    if(tmp[i]==='-1') continue;
    if(tmp[i]==='0'){
        input.push(source);
        source=[];
        nodeList.push(node)
        node=new Set();
        continue;
    }
    node.add(tmp[i]);
    node.add(tmp[i+1]);
    source.push(    tmp.slice(i,i+2));
}


function checkOneParent(list){
    let tmpChildren =[];
    for(let i of list){
        if(i[0]===i[1]){
            return false;
        }
        tmpChildren.push(i[1]);
    }
    let set = new Set(tmpChildren);
    return set.size===tmpChildren.length;
}

for(let i = 0;i<input.length;i++){
    if(input[i].length===0){
        console.log(`Case ${i+1} is a tree.`);
    }else if(nodeList[i].size !== input[i].length+1){
        
        console.log(`Case ${i+1} is not a tree.`);    
    }else{
        //root 가 한갠지 확인해야한다.
        if(checkOneParent(input[i])){
            console.log(`Case ${i+1} is a tree.`);
        }else{
            console.log(`Case ${i+1} is not a tree.`);    
        }

    }


}
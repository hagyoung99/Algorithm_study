let fs = require('fs');
let tmp = fs.readFileSync('input.txt').toString().trim().replaceAll("\n", "");
tmp=tmp.replaceAll(' ','');
let input = []; //정제된 인풋값
let source = [];
for(let i = 0;i<tmp.length;i+=2){
    if(tmp[i]==='-1') continue;
    if(tmp[i]==='0'){
        input.push(source);
        source=[];
        continue;
    }
    source.push(tmp.slice(i,i+2));
}

console.log(input);
function Tree(value){
    this.node=value;
    this.children = [];
}
// tmp = tmp.map((x)=>x.split(' '));
let root=[];

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


function insertTree(parent,child){
    console.log('insertTree');
    console.log(parent);
    console.log(child);
    if(parent.node===child.node){
        console.log('자식으로 넣쟝')
        parent.children.push(...child.children);
        return true;
    }else{
        for(let t = 0;t< parent.children.length;t++){
            if(insertTree(parent.children[t],child)) return true;
        }
        return false;
        
    }
}

for(let i = 0;i<input.length;i++){
    if(input[i].length===0){
        console.log(`Case ${i+1} is a tree.`);
        continue;

    }
    let root = [];
    if(checkOneParent(input[i])){
        for(let k of input[i] ){
            let flag = false;
            let tmpTree = new Tree(k[0]);
            tmpTree.children.push(new Tree(k[1]));
            for(let j = 0;j<root.length;j++){
                if(insertTree(root[j],tmpTree)){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                root.push(tmpTree);
            }
        }
        console.log('출력!');
        for(let r of root){
            console.log(r);
        }
        
        
        //root들을 합쳐!
        let f=0;
        let g=1;
        while(root.length>1){
            console.log('합치기 시작');
            if(insertTree(root[f],root[g])){
                console.log('f->g');                    
                root.splice(g,1);
            }else if(insertTree(root[g],root[f])){
                console.log('g->f');
                root.splice(f,1);
            }else{
                g++;
                
            }
            if(g>=root.length){
                f++;
                g=f+1;
                if(g>=root.length){
                    break;
                }
            }
        }
    }
    if(root.length===1){
        console.log(`Case ${i+1} is a tree.`);
    }else{
        console.log(`Case ${i+1} is not a tree.`);    
    }
    console.log('===============');
    console.log('===============');
    
    

}




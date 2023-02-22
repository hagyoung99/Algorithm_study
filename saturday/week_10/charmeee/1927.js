//최대힙

let fs = require('fs');
let [,...input] = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map(x => +x);//number 로 type변환

let heap = [];

let output = '';

function remove(){//제거 funtion
    console.log(heap);
    [heap[0],heap[heap.length-1]]=[heap[heap.length-1],heap[0]];//값 스위칭.
    let top = heap.pop();  
    let parentIndex = 0; 
    let sonIndex = [1,2];
    while(sonIndex[0]<heap.length){//개수 2부터.
        let smallerSon = heap[sonIndex[0]]<(heap[sonIndex[1]]??100000001)?{index:sonIndex[0],value:heap[sonIndex[0]]}:{index:sonIndex[1],value:heap[sonIndex[1]]};
        if(heap[parentIndex]<=smallerSon.value) break; //부모가 더크면 탈출~
        [heap[parentIndex],heap[smallerSon.index]]=[heap[smallerSon.index],heap[parentIndex]];//스위칭
        parentIndex=smallerSon.index;
        sonIndex = [parentIndex*2+1,parentIndex*2+2];
    }
    return top;
}


function add(x){
    heap.push(+x);
    let nowIndex=heap.length-1;
    while(nowIndex>0){
        let parentIndex = parseInt((nowIndex-1)/2);
        if(heap[parentIndex]<=heap[nowIndex]) break;
        [heap[parentIndex],heap[nowIndex]]=[heap[nowIndex],heap[parentIndex]];
        nowIndex=parentIndex;
    }
}

for(let i of input){
    // console.log("input : " +i);
    // console.log(typeof i);
    if(+i===0){//삭제
        heap.length===0?output+='0\n':output+=remove()+'\n';
    }else{//추가
        add(i);
    }
    // console.log(heap)
    // console.log('-----------------');
}
console.log(output);
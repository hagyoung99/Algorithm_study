let fs = require('fs');
let [,...input] = fs.readFileSync('input.txt').toString().trim().split('\n');
input = input.map(x=>+x);//number 로 type변환

let heap = [];

let output = '';

function remove(){//제거 funtion
    [heap[0],heap[heap.length-1]]=[heap[heap.length-1],heap[0]];//값 스위칭.
    let top = heap.pop();
    let parentIndex = 0; 
    let sonIndex = [1,2];

    while(sonIndex[0]<heap.length){//개수 2부터
        let parentAbsValue = Math.abs(heap[parentIndex]);
        let sonAbsValue = [Math.abs(heap[sonIndex[0]]),Math.abs(heap[sonIndex[1]]??100001)]
        let smallerAbsSon;//자식들 중에 더 작은 값의 인덱스와 value값을 담는다.

        if(sonAbsValue[0]===sonAbsValue[1]){
            smallerAbsSon = heap[sonIndex[0]]<heap[sonIndex[1]]
                ?{index:sonIndex[0],value:sonAbsValue[0]}
                :{index:sonIndex[1],value:sonAbsValue[1]};
        }else{
            smallerAbsSon=sonAbsValue[0]<sonAbsValue[1]
                ?{index:sonIndex[0],value:sonAbsValue[0]}
                :{index:sonIndex[1],value:sonAbsValue[1]};
        }
        
        if(parentAbsValue<smallerAbsSon.value) break; //부모가 더 작으면 탈출~
        if(parentAbsValue===smallerAbsSon.value){
            if(heap[parentIndex]<=heap[smallerAbsSon.index]) break;//절대값이 같을 부모가 더 작거나 같을 시 탈출 탈출
        }
        
        [heap[parentIndex],heap[smallerAbsSon.index]]=[heap[smallerAbsSon.index],heap[parentIndex]];//스위칭
        parentIndex=smallerAbsSon.index;
        sonIndex = [parentIndex*2+1,parentIndex*2+2];
    }
    return top;
}


function add(x){
    heap.push(x);//끝에 넣어줌
    let nowIndex=heap.length-1;
    while(nowIndex>0){
        let parentIndex = parseInt((nowIndex-1)/2);
        
        if(Math.abs(heap[parentIndex])<Math.abs(heap[nowIndex])) break;
        if(Math.abs(heap[parentIndex])===Math.abs(heap[nowIndex])){
            if(heap[parentIndex]<=heap[nowIndex]) break;
        }
        [heap[parentIndex],heap[nowIndex]]=[heap[nowIndex],heap[parentIndex]];
        nowIndex=parentIndex;
    }
}

for(let i of input){
    console.log("input : " + i);
    if(i===0){//삭제
        heap.length===0?output+='0\n':output+=remove()+'\n';
    }else{//추가
        add(i);
    }
    console.log(heap)
    console.log('-----------------');
}
console.log(output);
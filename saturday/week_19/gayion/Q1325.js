// 효율적인 해킹
// N = 정점의 갯수  M = 간선의 갯수
/*
첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다. 
둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 
컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

# 주의사항
A B  => A가 B를 신뢰한다.
배열로 구현할 때 graph[A][B]가 아닌 graph[B][A]로 구현
&&
배열로 구현했기때문에 문제에서 준 정점+1의 인덱스인 걸 잊지 말아라 바보야...
*/
const fs = require('fs');
// let input =fs.readFileSync("./dev/stdin").toString().trim().split("\n");
let input ="5 4\n3 1\n3 2\n4 3\n5 3".toString().trim().split("\n");
const [N,M] = input.splice(0,1).toString().trim().split(" ").map(n => Number(n));


const graph = Array.from(Array(N+1), () => Array(N+1).fill(0));

// 간선 정보 넣어주기
for(let i=0; i<M; i++){
    const [A,B] = input[i].toString().trim().split(" ").map(n => Number(n));
    graph[B][A] = 1;
}

function solution(n){
    for(let i=1; i<M; i++){
        if(graph[n][i]==1){

        }
    }
}

// 걍 확인해보려고
console.log(graph);
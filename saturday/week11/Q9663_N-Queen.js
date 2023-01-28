const fs = require('fs');
let input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

input = Number(input[0]);

function solution(input){
    const visited = new Array(input).fill(0);
    let answer = 0;

    dfs(0);

    function dfs(x){
        if(x === input){
            answer += 1;
        } else {
            for(let i=0; i<input; i++){
                if(visited[x]) continue;
                visited[x] = i;
                
                if(check(x)) dfs(x+1);
                visited[x] = 0;
            }
        }
    }
    function check(x){
        for(let i=0; i<x; i++){
            if(visited[x]===visited[i]) return false;
            if(Math.abs(visited[x]-visited[i])===x-i) return false;
        }
    
        return true
    }

    return answer
}

console.log(solution(input));



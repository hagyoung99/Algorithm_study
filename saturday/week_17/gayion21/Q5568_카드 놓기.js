const fs = require('fs');
const filepath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filepath).toString().split("\n")



function solution() {
    const n = input[0]*1
    const k = input[1]*1
    const nums = input.slice(2,2+n).map(i => {return i*1})    
    const visited = new Array(n).fill(false)
    const temp = []
    let result = []
    function dfs(k){
        if(k == 0){
            result.push(temp.join(''))
            return
        }
        for(let i=0; i < n; i++){
            if(visited[i] === false){
                visited[i] = true
                temp.push(nums[i])
                dfs(k-1)
                temp.pop()
                visited[i] = false
            }
        }
    }

    dfs(k);
    result = [...new Set(result)]
    console.log(result.length)
}
solution()
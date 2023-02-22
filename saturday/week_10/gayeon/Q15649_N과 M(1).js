const input = require('fs').readFileSync('/dev/stdin').toString().split('\n').slice(0,-1);
const NM = input[0].split(" ");
const [n,m] = NM.map(el => Number(el));

function solution(n,m) {
    const seq = [...Array(m)].fill(0);
    const visited = [...Array(n)].fill(false);
    let result = "";
    
    function dfs(k) {
        if (k === m) {
            const arr = [];
            for (let i=0; i<m; i++) {
                arr.push(seq[i]);
            }
            return result += `${arr.join(' ')}\n`;
        }
        for (let i=1; i<=n; i++) {
            if (!visited[i]) {
                seq[k] = i;
                visited[i] = true;
                dfs(k+1);
                visited[i] = false;
            }
        }
    }
    
    dfs(0);
    return result;
}

console.log(solution(n,m));
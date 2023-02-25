const input = require('fs').readFileSync('/dev/stdin').toString().split('\n').map(s => s.split(" ")).slice(0,-1);
const NK = input.shift();
const [n,k] = NK.map(el => Number(el));
const board = input.map(s => s.map(el => Number(el)));

function solution(n,k,board) {
    const maxCoord = board.reduce((prev, curr) => {
        const coord = curr[1];
        return Math.max(prev, coord);
    }, 0);
    
    const arr = [...Array(maxCoord+1)].fill(0);
    for (let row of board) {
        const [ice, coord] = row;
        arr[coord] = ice;
    }
        
    let window = 0;
    
    for (let i=0; i<k+1 && i<arr.length; i++) {
        window += arr[i];
    }
    
    let maxIce = 0;
    for (let i=0; i<arr.length; i++) {
        let lo = i-k-1;
        let hi = i+k+1;
        window = window - (arr[lo] ?? 0) + (arr[hi] ?? 0);
        maxIce = Math.max(maxIce, window);
    }
    
    
    return maxIce;
}

console.log(solution(n,k, board));
let [inp1,...arr] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
let [N,L] = inp1.split(" ").map(Number);

let str = '';
let res = 0;

for(let i=0; i<L; ++i) {
    let obj = {'T': 2, 'A': 1, 'G': 0, 'C': 0};
    let c = 'Z';
    let cnt = 0;

    // 각 자리를 비교하여 최다빈도 문자 구하기
    for (let j = 0; j < N; ++j) {
        let ic = arr[j][i];
        obj[ic]++;
        if(cnt <= obj[ic]){
            if(cnt < obj[ic] || c.localeCompare(ic)>0){
                c = ic;
            }
            cnt = obj[ic];
        }
    }

    str += c;  // T
    res += N-cnt;
}
console.log(str);
console.log(res);


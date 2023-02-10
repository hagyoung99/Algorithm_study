const [T, ...input] = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const output = [];

input.forEach(v => {
    output.push(getSum(...v.split(' ').map(v => +v)));
  });
  
  const getGCD = (a, b) => {
    if (a % b === 0) return b;
    return getGCD(b, a % b);
  };
  
  const getSum = (n, ...arr) => {
    let sum = 0;
    arr.sort((a, b) => b - a);
    arr.forEach((v, i) => {
      while (i < n-1) {
        sum += getGCD(v, arr[++i]);
      }
    });
    return sum;
  };
  
  
  console.log(output.join('\n'));
const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');


const N = input.shift();
const coordsArr = input.map(coords =>
  coords.split(' ').map(nums => parseInt(nums))
);

let results = '';
coordsArr
  .sort((a, b) => {
    if (a[0] !== b[0]) {
      return a[0] - b[0];
    }
    return a[1] - b[1];
  })
  .forEach(coords => {
    results += `${coords[0]} ${coords[1]}\n`;
  });

console.log(results);
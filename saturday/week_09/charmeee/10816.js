const [,input1,,input2] = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const arr1 = input1.shift().split(" ");
const arr2 = input2.shift().split(" ");
var output = [];
var card = new Map();
for (number of HaveCard) {
  if (card.has(number))
    card.set(number, card.get(number) + 1);
  else card.set(number, 1);
}

for (number of arr2) {
  if (card.has(number)) output.push(card.get(number));
  else output.push(0);
}

console.log(output.join(" "));
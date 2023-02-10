const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
//입력값의 첫번째 값 = N
const N = +input[0];
//입력값의 두번째 ~ 마지막 값
const alphabet = input.slice(1);

let result = '';

for (let i = 0; i < N; i++) {
  const treeNode = {};
  //alphabet[i] = 두번째 줄부터 마지막 줄까지의 입력
  const [node, left, right] = alphabet[i].split(' ');
  //treeNode = {node: left, right, ...};
  treeNode[node] = [left, right];
}

// 전위 순회
function preOrder (node) {
	if (node === '.') {
      return;
    }
    
    const [left, right] = treeNode[node];
    result += node; 
    preOrder(left); 
    preOrder(right);
}

// 중위 순회
function inOrder (node) {
	if (node === '.') {
    	return;
    }
    
    const [left, right] = treeNode[node];
    result += node;
    inOrder(left);
    inOrder(right);
}

// 후위 순회
function postOrder (node) {
	if (node === '.') {
    	return;
    }
    
    const [left, right] = treeNode(node);
    postOrder(left);
    postOrder(right);
    result += node;
}

//root node는 A로 주어짐
preOrder('A');
result += '\n';
inOrder('A');
result += '\n'
postOrder('A');
result += '\n';

console.log(result);
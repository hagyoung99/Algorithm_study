const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
input.shift();

const deque = [];
let output = '';

input.forEach(input => {
  if (input.includes('push_front')) {
    //splice로 제일 앞에 추가한다.
    deque.splice(0, 0, input.split(' ')[1]);
  }
  if (input.includes('push_back')) {
    //push로 제일 뒤에 추가한다.
    deque.push(input.split(' ')[1]);
  }
  if (input === 'pop_front') {
    //shift로 앞에 있는 수를 제거 후 출력한다.
    output += deque.length ? deque.shift() + '\n' : '-1' + '\n';
  }
  if (input === 'pop_back') {
    //pop으로 뒤에 있는 수를 제거 후 출력한다.
    output += deque.length ? deque.pop() + '\n' : '-1' + '\n';
  }
  if (input === 'size') {
    //개수를 출력한다.
    output += deque.length + '\n';
  }
  if (input === 'empty') {
    output += deque.length ? 0 + '\n' : 1 + '\n'
  }
  if (input === 'front') {
    //0번째 수를 출력한다.
    output += deque.length ? deque[0] + '\n' : '-1' + '\n'
  }
  if (input === 'back') {
    //마지막 수를 출력한다.
    output += deque.length ? deque[deque.length - 1] + '\n' : '-1' + '\n'
  }
})

console.log(output);
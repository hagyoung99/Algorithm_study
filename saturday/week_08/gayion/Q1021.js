let fs = require('fs');
let input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

let list1 = input[0];
list1 = list1.split(' ');
let list2 = input[1];
list2 = list2.split(' ');


    let que = [];

    for (let i = 0; i < Number(list1[0]); i++) {
        que.push(i + 1);
    }

    const v1 = () => {
        que.shift();
    }

    const v2 = () => {
        let num = que.shift();
        que.push(num);
    }

    const v3 = () => {
        let num = que.pop();
        que.unshift(num);
    }

    let num = 0;

    for (let i = 0; i < list2.length; i++) {
        let target = Number(list2[i]);
        if (target === que[0]) {
            v1();
        } else {
            let index = que.indexOf(target);
            let stable = que.length / 2;

            if (index <= stable) {
                for (let j = 0; j < index; j++) {
                    v2();
                    num++;
                }
            } else {
                for (let j = 0; j < que.length - index; j++) {
                    v3();
                    num++;
                }
            }
            v1();
        }
    }

    console.log(num);
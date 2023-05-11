/*
매칭 가능한 방 처음 입장한사람 기준으로 +-10
if(매칭가능한 방 is null) make room
if(매칭가능한 방 is many) enter earlier
if(romm is full) start
*/

let fs = require('fs');
let input = fs.readFileSync('input.txt').toString().trim().split('\n');

let [pNum, limit] = input.shift().split(' ').map((x)=>+x);
let output='';

function Room(level,people){
    this.level=level;
    this.people=people;
}
function printRoom(room){
    output+=room.people.length===limit?'Started!\n':'Waiting!\n';
    room.people = room.people.sort(function(a,b){
        if(a[1]>b[1]){
            return 1;
        }
        return -1;
    });
    for(let i of room.people){
        output+=i.join(' ')+'\n';
    }
}
let rooms = [];

for(let i of input){
    let [level,nick]=i.split(' ');
    level = +level;
    let index =rooms.findIndex((x)=>(x.level-10<=level)&&(level<=x.level+10)&&x.people.length<limit)
    if(index===-1){
        rooms.push(new Room(level,[[level,nick]]));
        continue;
    }
    rooms[index].people.push([level,nick]);
    // console.log('rooms',rooms);
}

for(let i of rooms){
    printRoom(i);
}
console.log(output);
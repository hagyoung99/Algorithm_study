let fs = require('fs');
let input =parseInt( fs.readFileSync('input.txt').toString().trim());
let n =[];
let tmp1 = input;
let output=[]
while(tmp1>1){
    n.push(tmp1);
    tmp1 /= 3;
}
n.reverse();
for(var i = 0;i< input;i++){
    var tmp2=[];
    for(var j = 0;j< input;j++){
        var flag=false;
        for(var k = 0;k<n.length;k++){
            var jud= 3**k;
            if((jud<=i%n[k]&&i%n[k]<jud*2)&&jud<=j%n[k]&&j%n[k]<jud*2){
                flag=true;
            }
            if(flag){
                break;
            }
        }
        if(flag){
            tmp2.push(' ')
        }else{
            tmp2.push('*')
        }
        
    }
    output.push(tmp2);
}
let outputStr=""
for(var i = 0;i< output.length;i++){
    outputStr+=output[i].join('');
    outputStr+='\n';
}
console.log(outputStr);
function isBall(answer, hint) {
    let cnt = 0;
    for (let i = 0; i < 3; i++) {
      for (let j = 0; j < 3; j++) {
        if (i !== j) {
          if (answer[i] === hint[j]) cnt++;
        }
      }
    }
    return cnt;
  }
   
  function isStrike(answer, hint) {
    let cnt = 0;
    for (let i = 0; i < 3; i++) {
      if (answer[i] === hint[i]) cnt++;
    }
    return cnt;
  }
   
  function dfs(res, visit) {
    if (res.length === 3) {
      let flag = true;
      const answer = res.join("");
      
      
      for (const [hint, s, b] of hints) {
        
        const strHint = hint.toString();
        
        const strike = isStrike(answer, strHint);
        if (s !== strike) {
          flag = false;
          break;
        }
        
        const ball = isBall(answer, strHint);
        if (b !== ball) {
          flag = false;
          break;
        }
        
      }
      
      if (flag) ans.push(answer);
      return;
    }
   
    for (let i = 1; i <= 9; i++) {
    
      if (!visit[i]) {
        res.push(i);
        visit[i] = 1;
        dfs(res, visit);
        visit[i] = 0;
        res.pop();
      }
      
    }
    
  }
   
  let hints = [
    [123, 1, 1],
    [356, 1, 0],
    [327, 2, 0],
    [489, 0, 1],
  ];
   
  const visit = Array(10).fill(0);
  const ans = [];
  dfs([], visit);
  console.log(ans);
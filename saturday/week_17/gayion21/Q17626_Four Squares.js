const solve = n => {
    const dp = new Array(n+1).fill(0);
    dp[1] = 1;
    for (let i=2; i<=n; i++) {
      let min = 4;
      for (let j=1; j*j<=i; j++) {
        min = Math.min(min, dp[i-j*j]);
      }
      dp[i] = min + 1;
    }
    console.log(dp[n]);
  };
  
  const n = +require('fs').readFileSync('/dev/stdin').toString().trim();
  solve(n);
function solution(n, graph) {
    //방문노드 초기화
    visited = new Array(n + 1).fill(false);
    let result = 0;
    //노드 1로 dfs시작
    result = dfs(n, 1);
    console.log(result);
  }
  
  function dfs(n, start) {
    //현재 노드 방문처리
    visited[start] = true;
    let stack = [];
    let cnt = 0;
    //시작노드 삽입
    stack.push(start);
    while (stack.length !== 0) {
      let tmp = stack.pop(); //연결된 인접노드 가져옴
      for (let i = 1; i <= n; i++) {
        //현재 노드와 연결된것이 있고 그 연결노드가 아직 미방문이면
        if (graph[tmp][i] === 1 && visited[i] === false) {
          stack.push(i); //인접노드 삽입
          cnt += 1; // 감염수
          visited[i] = true; //인접노드 방문처리
        }
      }
    }
    return cnt;
  }
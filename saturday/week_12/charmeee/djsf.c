#include <bits/stdc++.h>
using namespace std;
using pii = pair<int,int>;
int testCase = 1;

int bfs(map<int,vector<int>> &treeMap){
    map <int,int> ckMap;

    for(auto t : treeMap)
        for(auto el : t.second)
            ckMap[el] = 1;

    int root = 0;
    for(auto t : treeMap)
        if(!ckMap[t.first]) 
            root = t.first;
    ckMap.clear();
    ckMap[root] = 1;
    queue <int> q;
    q.push(root);

    while(!q.empty()){
        int x = q.front();
        q.pop();
        for(int i = 0; i < treeMap[x].size(); i++){
            int nx = treeMap[x][i];
            if(ckMap[nx] == 1) return 0;
            ckMap[nx] = 1;
            q.push(nx);
        }
    }

    for(auto t : treeMap){
        for(auto el : t.second){
            if(!ckMap[el] || !ckMap[t.first]) return 0;
        }
    }
    return 1;
}

int main(){
    while(1){
        int edgeCnt = 0;
        map<int,vector<int>> treeMap;
        set <int> vertex;
        int u, v;
        while(1){
            cin >> u >> v;
            edgeCnt++;
            vertex.insert(u);
            vertex.insert(v);
            if(u == -1 && v == -1) return 0;
            if(u == 0 && v == 0) break;
            treeMap[u].push_back(v);
        }
        if(u && v && vertex.size() != edgeCnt + 1) printf("Case %d is not a tree.\n", testCase++);
        else{
            if(bfs(treeMap)) printf("Case %d is a tree.\n", testCase++);
            else printf("Case %d is not a tree.\n", testCase++);
        }
    }
}
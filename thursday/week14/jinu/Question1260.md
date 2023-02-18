## 테스트 케이스 1
![테스트 케이스 1 출력](https://user-images.githubusercontent.com/73889507/219383648-dd551848-5cb3-4dd4-85dd-efd313ce5cd5.PNG)
![그래프 구현](https://user-images.githubusercontent.com/73889507/219383703-07f69a6b-7de6-448b-a102-7892fb5a0c2e.png)

- DFS로 탐색하는 경우

(1) 1에서 시작 (1 방문)

(2) 1과 연결된 가장 작은 노드는 2 이므로, 2 방문

(3) 2와 연결된 것 중 방문하지 않은 가장 작은 노드는 4이므로, 4 방문

(4) 4와 연결된 것 중 방문하지 않은 가장 작은 노드는 3이므로 3 방문

(5) 1-2-4-3 의 순서로 방문하게 됨

- BFS로 탐색하는 경우

(1) 1에서 시작 (1방문)

(2) 1과 연결된 가장 작은 노드인 2 방문

(3) 1과 연결된 다음 작은 노드 3 방문

(4) 1과 연결된 마지막 노드 4 방문

(6) 1-2-3-4 의 순서로 방문하게 됨

## 테스트 케이스 2

![테스트 케이스 2 출력](https://user-images.githubusercontent.com/73889507/219383812-dbac5a71-dd4a-42ad-b50f-75d4be8db96d.PNG)
![그래프 구현](https://user-images.githubusercontent.com/73889507/219383843-b7418541-6222-44cb-8fa2-78e8e517b579.png)

- DFS로 탐색하는 경우

(1) 3에서 시작 (3 방문)

(2) 1과 연결된 가장 작은 노드는 1 이므로, 1 방문

(3) 1와 연결된 것 중 방문하지 않은 노드는 2이므로, 2 방문

(4) 2와 연결된 것 중 방문하지 않은 노드는 5이므로, 5 방문

(5) 5와 연결된 것 중 방문하지 않은 노드는 4이므로, 4 방문

(6) 3-1-2-5-4 의 순서로 방문하게 됨

- BFS로 탐색하는 경우

(1) 3에서 시작 (3방문)

(2) 3과 연결된 가장 작은 노드인 1 방문

(3) 3과 연결된 다음 작은 노드 4 방문

(4) 1과 연결된 노드 2 방문

(5) 4와 연결된 노드 5 방문

(6) 3-1-4-2-5 의 순서로 방문하게 됨
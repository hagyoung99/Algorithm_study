import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        //[시작 지점, 목표 지점, 비용]
        int[][] shortcuts=new int[n][3];
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            shortcuts[i][0]=Integer.parseInt(st.nextToken());
            shortcuts[i][1]=Integer.parseInt(st.nextToken());
            shortcuts[i][2]=Integer.parseInt(st.nextToken());
        }

        //시작 지점을 기준으로 지름길 정렬
        Arrays.sort(shortcuts, Comparator.comparingInt(o->o[0]));
        //[현재 위치, 비용]의 형태로 우선순위큐 삽입, 정렬 기준:비용
        PriorityQueue<int[]> pq=new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pq.add(new int[]{0, 0});
        while(!pq.isEmpty()){
            int[] ptr=pq.poll();
            int location=ptr[0];
            int cost=ptr[1];

            if(location==d){
                System.out.println(cost);
                return;
            }

            //현재 위치와 지름길의 시작 지점이 같고, 지름길의 목표 지점이 D와 같거나 더 짧고, 지름길을 타는 것이 더 이득일 때 우선순위큐에 삽입
            int next=d;
            for(int[] i:shortcuts){
                if(i[0]>location) {     //지름길의 시작 지점이 현재 위치보다 크면 다음 목표 위치로 세팅하고 break
                    next = i[0];
                    break;
                }
                else if(i[0]==location){
                    if(i[1]<=d && i[1]-location>i[2])
                        pq.add(new int[]{i[1], cost+i[2]});
                }
            }
            //다음 목표지점, D 중 가까운 위치를 우선순위큐에 삽입
            pq.add(new int[]{Math.min(next, d), Math.min(next, d)-location+cost});
        }
    }
}
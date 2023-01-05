package jeensung;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BOJ10828{
    public static void main (String[] args) throws NumberFormatException, IOException{
        
        Stack<Integer> stack = new Stack<Integer>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            String[] arr = br.readLine().split(" ");
            
            switch(arr[0]){
                case "push":
                    stack.push(Integer.parseInt(arr[1]));
                    break;
                
                case "pop":
                    if(stack.empty()){
                        bw.write("-1" + "\n");
                    }
                    else{
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size" :
                    bw.write(stack.size() + "\n");
                    break;
                
                case "empty" :
                    if(stack.empty()){
                        bw.write("1"+"\n");
                    }else
                        bw.write("0" + "\n");
                    break;
                case "top" :
                    if(stack.empty()){
                        bw.write("-1"+"\n");
                    }else
                        bw.write(stack.peek() + "\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
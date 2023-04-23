package week23;
import java.util.*;
public class BOJ3967 {
	static StringBuilder sb;
	static boolean find = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = "";
		boolean[] visit = new boolean[12];
		for(int i = 0; i < 5; i++) {
			String temp = scan.next();
			for(int j = 0; j < 9; j++) {
				if(temp.charAt(j) != '.') {
					str += temp.charAt(j);
					if(temp.charAt(j) != 'x')
						visit[temp.charAt(j) - 'A'] = true;
				}
			}
		}
		dfs(visit, 0, str);
	}
	static void dfs(boolean[] visit, int count, String str) {
		if(find)
			return;
		if(count == 12) {
			if(check(str)) {
				find = true;
				print(str);
			}
			return;
		}
		if(str.charAt(count) != 'x')
			dfs(visit, count + 1, str);
		else {
			sb = new StringBuilder(str);
			for(int i = 0; i < 12; i++) {
				if(!visit[i]) {
					visit[i] = true;
					String s= "" + (char)(i + 'A');
					sb.replace(count, count + 1, s);
					dfs(visit, count + 1, sb.toString());
					sb.replace(count, count + 1, "x");
					visit[i] = false;
				}
			}
		}
	}
	static void print(String str) {
		int idx = 0;
        for(int i=0; i<5; i++) {
            for(int j=0; j<9; j++) {
                if(i==0 && j==4) {
                    System.out.print(str.charAt(idx));
                    idx++;
                }

                else if(i==1 && (j==1 || j==3 || j==5 || j==7)) {
                    System.out.print(str.charAt(idx));
                    idx++;
                }

                else if(i==2 && (j==2 || j==6)) {
                    System.out.print(str.charAt(idx));
                    idx++;
                }

                else if(i==3 && (j==1 || j==3 || j==5 || j==7)) {
                    System.out.print(str.charAt(idx));
                    idx++;
                }

                else if(i==4 && j==4) {
                    System.out.print(str.charAt(idx));
                    idx++;
                }
                else
                    System.out.print(".");
            }
            System.out.println();
        }
	}
    public static boolean check(String str) {
        if(cal(str.charAt(0))+cal(str.charAt(2))+cal(str.charAt(5))+cal(str.charAt(7))!=26) return false;

        else if(cal(str.charAt(1))+cal(str.charAt(2))+cal(str.charAt(3))+cal(str.charAt(4))!=26) return false;

        else if(cal(str.charAt(0))+cal(str.charAt(3))+cal(str.charAt(6))+cal(str.charAt(10))!=26) return false;

        else if(cal(str.charAt(7))+cal(str.charAt(8))+cal(str.charAt(9))+cal(str.charAt(10))!=26) return false;

        else if(cal(str.charAt(1))+cal(str.charAt(5))+cal(str.charAt(8))+cal(str.charAt(11))!=26) return false;

        else if(cal(str.charAt(4))+cal(str.charAt(6))+cal(str.charAt(9))+cal(str.charAt(11))!=26) return false;

        else
            return true;
    }

    public static int cal(char c) {
        return c-'@';
    }
}

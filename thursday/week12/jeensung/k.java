class Solution {
    public long solution(int n, int k) {
        int answer = 0;
        String str = "";
        int pow = 30;
        while(n > 0){
            //11을 3진수로 나타내면 102
            //9를 2진수로 나타내면 1001
            if (!(Math.pow(k, pow) > n) || !str.equals("")) {
                int temp = 0;
                for (int x = k - 1; x >= 0; x--) {
                    if (x * Math.pow(k, pow) <= n) {
                        temp = x;
                        break;
                    }
                }
                n -= temp * (int) Math.pow(k, pow);
                str = str + temp;
            }
            pow--;
        }
        String temp = "";
        for(int i = 0; i < str.length(); i++){
            char now = str.charAt(i);
            if(now != '0'){
                temp += now;
            }else{
                int t = Integer.parseInt(temp);
                temp = "0";
                if(t == 1 ||t == 0) {
                    continue;
                }
                if(check(t))
                    answer++;
            }
        }
        long t = Long.parseLong(temp);
        if(t == 1 || t == 0)
            return answer;
        else{
            if(check(t))
                answer++;
            return answer;
        }
    }
    static boolean check(long x){
        for(int i = 2; i <= Math.sqrt(x); i++){
            if(x % i == 0)
                return false;
        }
        return true;
    }
}
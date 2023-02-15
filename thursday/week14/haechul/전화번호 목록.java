import java.util.Arrays;

class Solution {
    public static boolean solution(String[] phone_book) {

        if (phone_book.length == 1) {
            return true;
        }

        Arrays.sort(phone_book);

        for (int i = 1; i < phone_book.length; i++) {
            if (phone_book[i].startsWith(phone_book[i - 1])) {
                return false;
            }
        }

        return true;
    }
}

class Test{
    public static void main(String[] args) {
        String[] x = {"119", "97674223", "1195524421"};
        System.out.println(Solution.solution(x));
    }
}

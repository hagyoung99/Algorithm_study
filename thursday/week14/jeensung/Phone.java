import java.util.Arrays;
import java.util.HashMap;

class Solution {
    static HashMap<String, Integer> hash = new HashMap<>();
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length - 1; i++){
            if(phone_book[i + 1].startsWith(phone_book[i]))
                return false;
        }
        return true;
    }
}
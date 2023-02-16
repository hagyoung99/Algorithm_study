<<<<<<< HEAD
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    static HashSet<String> hash = new HashSet<>();
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length; i++){
            if(!hash.contains(phone_book[i])){
                hash.add(phone_book[i]);
            }
        }
        for(String now : hash) {
        	for(int i = 0; i < now.length(); i++) {
        		if(hash.contains(now.substring(0, i)))
        			return false;
        	}
        }
        return true;
    }
}
=======
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    static HashSet<String> hash = new HashSet<>();
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length; i++){
            if(!hash.contains(phone_book[i])){
                hash.add(phone_book[i]);
            }
        }
        for(String now : hash) {
        	for(int i = 0; i < now.length(); i++) {
        		if(hash.contains(now.substring(0, i)))
        			return false;
        	}
        }
        return true;
    }
}
>>>>>>> 6d77b77b9ac776c10f060828fa803a090e52770f

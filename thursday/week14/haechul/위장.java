import java.util.HashMap;

class Solution {

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }

        return map.values().stream().reduce(1, (a, b) -> a * (b + 1)) - 1;
    }
}

class Test {
    public static void main(String[] args) {
        String[][] x = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(Solution.solution(x));
    }
}

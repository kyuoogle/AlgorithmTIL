import java.util.*;

class Solution {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < name.length; i++) m.put(name[i], yearning[i]);

        int[] ans = new int[photo.length];

        for (int i = 0; i < photo.length; i++) {
            for (String s : photo[i]) {
                ans[i] += m.getOrDefault(s, 0);
            }
        }

        return ans;
    }
}
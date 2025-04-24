import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> smap = new HashMap<>();
        List<Integer> l1 = new ArrayList<>();
        
        if (s.length() < p.length()) {
            return l1;
        }
        
        // Build frequency map for string p
        for (char num : p.toCharArray()) {
            pmap.put(num, pmap.getOrDefault(num, 0) + 1);
        }

        int left = 0, right = 0;
        
        while (right < s.length()) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            
            // Slide the window and maintain the size of the window to p.length
            if (right - left + 1 > p.length()) {
                char leftchar = s.charAt(left);
                smap.put(leftchar, smap.get(leftchar) - 1);
                if (smap.get(leftchar) == 0) {
                    smap.remove(leftchar);
                }
                left++;
            }

            // Check if the window matches the frequency map of string p
            if (right - left + 1 == p.length() && smap.equals(pmap)) {
                l1.add(left);
            }

            right++;
        }
        return l1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = sol.findAnagrams(s, p);
        System.out.println("Anagram indices: " + result);
    }
}

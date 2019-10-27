/*
    Method: Sliding Window Optimized;
    TimeComplexity: O(n);
    SpaceComplexity: O(min(m, n)), m is the length of the string, s is the max length of the hashSet;
    Time: 2019/10/26;
    Attention:
        1. i = Math.max(map.get(s.charAt(j)), i), please note that there is a comparision here. If not,
        eg., like string s = 'abba', when j =3, it will set i = 1 instead of 2, leading to wrong answer.
        2. This code is so simple and elegant.
        3. map.put(s.charAt(j), j + 1); Why there is j + 1 ?
*/
public class SolutionThree {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}

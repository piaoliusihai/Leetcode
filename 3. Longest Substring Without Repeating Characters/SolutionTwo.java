/*
    Method: Sliding Window;
    TimeComplexity: O(2n) = o(n);
    SpaceComplexity: O(min(m, n)), m is the length of the string, s is the max length of the hashSet;
    Time: 2019/10/26;
    Attention:
        1.Set<Character> set = new HashSet<>();
*/
public class SolutionTwo {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}

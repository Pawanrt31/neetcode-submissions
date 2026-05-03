class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int lengthOfLongestSubstring = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            while(set.contains(s.charAt(windowEnd))) {
                set.remove(s.charAt(windowStart));
                windowStart++;
            }
            set.add(s.charAt(windowEnd));
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
        }
        return lengthOfLongestSubstring;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int lengthOfLongestSubstring = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if(map.containsKey(s.charAt(windowEnd))) {
                windowStart = Math.max(map.get(s.charAt(windowEnd))+1, windowStart);
            }
            map.put(s.charAt(windowEnd), windowEnd);
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, windowEnd - windowStart + 1);
        }
        return lengthOfLongestSubstring;
    }
}

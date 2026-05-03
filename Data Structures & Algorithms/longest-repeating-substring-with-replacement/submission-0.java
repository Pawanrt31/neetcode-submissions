class Solution {
    public int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int lengthLongestCharacterReplacement = Integer.MIN_VALUE;
        int windowStart = 0, maxFrequency = 0;
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            map.put(s.charAt(windowEnd), map.getOrDefault(s.charAt(windowEnd),0)+1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(windowEnd)));
            while((windowEnd - windowStart + 1) - maxFrequency > k) {
                map.put(s.charAt(windowStart), map.get(s.charAt(windowStart)) - 1);
                windowStart++;
            }
            lengthLongestCharacterReplacement = Math.max(lengthLongestCharacterReplacement, windowEnd - windowStart + 1);
        }
        return lengthLongestCharacterReplacement;

    }
}

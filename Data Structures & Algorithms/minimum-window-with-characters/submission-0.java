class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 && t.length() == 0) {
            return "";
        }
        if(t.length() == 0) {
            return "";
        }
        Map<Character, Integer> mapT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(Character ch: t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        int need = mapT.size(), have = 0;
        int minimumLength = Integer.MAX_VALUE;
        int windowStart = 0;
        int[] res = {-1,-1};
        for(int windowEnd=0;windowEnd<s.length();windowEnd++) {
            char ch = s.charAt(windowEnd);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(mapT.containsKey(ch) && window.get(ch).equals(mapT.get(ch))) {
                have++;
            }
            while(have == need) {
                if((windowEnd - windowStart + 1) < minimumLength) {
                    minimumLength = windowEnd - windowStart + 1;
                    res[0] = windowStart;
                    res[1] = windowEnd;
                }
                char leftChar = s.charAt(windowStart);
                window.put(leftChar, window.getOrDefault(leftChar, 0) - 1);
                if(mapT.containsKey(leftChar) && window.get(leftChar) < mapT.get(leftChar)) {
                    have--;
                }
                windowStart++;
            }
        }
        return minimumLength == Integer.MAX_VALUE ? "": s.substring(res[0], res[1] + 1); 
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return false;
        }
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for(int i=0;i<s1.length();i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i=0;i<26;i++) {
            if(s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int windowStart = 0;
        for(int windowEnd = s1.length(); windowEnd < s2.length(); windowEnd++) {
            if(matches == 26) {
                return true;
            }
            int index = s2.charAt(windowEnd) - 'a';
            s2Count[index]++;

            if(s1Count[index] == s2Count[index]) {
                matches++;
            } else if(s1Count[index] + 1 == s2Count[index]) {
                matches--;
            }

            index = s2.charAt(windowStart) - 'a';
            s2Count[index]--;

            if(s1Count[index] == s2Count[index]) {
                matches++;
            } else if(s1Count[index] - 1 == s2Count[index]) {
                matches--;
            }
            windowStart++;
        }
        return matches == 26;
    }
}

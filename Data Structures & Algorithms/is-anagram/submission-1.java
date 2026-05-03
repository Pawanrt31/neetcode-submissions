class Solution {
    public boolean isAnagram(String s, String t) {
        int[] tracker = new int[26];
        for(Character ch: s.toCharArray()) {
            tracker[ch - 'a']++;
        }
        for(Character ch: t.toCharArray()) {
            tracker[ch - 'a']--;
        }
        for(int count: tracker) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
}

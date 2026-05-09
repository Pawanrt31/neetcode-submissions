class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return result;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i),i);
        }

        int partition = 0, end = 0;
        for(int i=0;i<s.length();i++) {
            partition++;
            end = Math.max(end,map.get(s.charAt(i)));

            if(i == end) {
                result.add(partition);
                partition =0;
            }
        }
        return result;
    }
}

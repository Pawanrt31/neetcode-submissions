class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{0};
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int element: nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        List<Integer>[] freq = new List[nums.length + 1];
        for(int i=0;i<freq.length;i++) {
            freq[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> m: map.entrySet()) {
            freq[m.getValue()].add(m.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for(int i=freq.length - 1;i>=0 && index < k;i--) {
            for(int n : freq[i]){
                result[index++] = n;
                if(index == k ){
                    return result;
                } 
            }
        }
        return result;
    }
}

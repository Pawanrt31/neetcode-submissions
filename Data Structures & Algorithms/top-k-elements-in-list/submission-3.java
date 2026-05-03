class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[]{0};
        }
        return Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(element -> element,Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
            .limit(k)
            .map(Map.Entry::getKey)
            .mapToInt(Integer::intValue)
            .toArray();
    }
}

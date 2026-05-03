class Pair {

    String value;
    int timestamp;

    public Pair(int timestamp, String value) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getKey() {
        return this.timestamp;
    }

    public String getValue() {
        return this.value;
    }
}

class TimeMap {

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Pair>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        return binarySearch(key, timestamp);
    }

    private String binarySearch(String key, int timestamp) {
        List<Pair> values = map.getOrDefault(key, new ArrayList<>());
        int low = 0, high = values.size() - 1;
        String result = "";
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(timestamp >= values.get(mid).getKey()) {
                result = values.get(mid).getValue();
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}

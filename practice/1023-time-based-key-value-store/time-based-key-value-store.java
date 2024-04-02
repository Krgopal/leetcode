class TimeMap {

Map<String, TreeMap<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> activityMap = timeMap.getOrDefault(key, new TreeMap<>());
        activityMap.put(timestamp, value);
        timeMap.put(key, activityMap);
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        if (timeMap.get(key).floorKey(timestamp)== null) {
            return "";
        }
        int timeKey = timeMap.get(key).floorKey(timestamp);
        return timeMap.get(key).get(timeKey);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
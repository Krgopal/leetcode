import java.util.Map;
import java.util.TreeMap;

class SortedList {
    long sum;
    int size;
    TreeMap<Integer, Integer> tm;
    public SortedList() {
        this.tm = new TreeMap<>();
    }
    public long getSum() {
        return sum;
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size== 0;
    }
    public boolean contains(int num) {
        return tm.containsKey(num);
    }
    public void add(int num) {
        tm.put(num, tm.getOrDefault(num, 0) + 1);
        sum += num;
        size++;
    }

    public int getMin() {
        return tm.firstKey();
    }
    public int getMax() {
        return tm.lastKey();
    }

    public int removeMin() {
        Map.Entry<Integer, Integer> firstEntry = tm.firstEntry();
        if (firstEntry.getValue() == 1) {
            tm.remove(firstEntry.getKey());
        } else {
            tm.put(firstEntry.getKey(), firstEntry.getValue() -1);
        }
        sum -= firstEntry.getKey();
        size--;
        return firstEntry.getKey();
    }

    public int removeMax() {
        Map.Entry<Integer, Integer> lastEntry = tm.lastEntry();
        if (lastEntry.getValue() == 1) {
            tm.remove(lastEntry.getKey());
        } else {
            tm.put(lastEntry.getKey(), lastEntry.getValue() -1);
        }
        sum -= lastEntry.getKey();
        size--;
        return lastEntry.getKey();
    }

    public void remove(int num) {
        if (!tm.containsKey(num)) {
            return;
        }
        if (tm.get(num) == 1) {
            tm.remove(num);
        } else {
            tm.put(num, tm.get(num) -1);
        }
        sum -= num;
        size--;
    }

} 
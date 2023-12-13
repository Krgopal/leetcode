import java.util.*;

class MKAverage {
    List<Integer> movingM;
    int m;
    int k;
    SortedList smallK, middle, topK;
    Deque<Integer> queue;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        this.smallK = new SortedList();
        this.middle = new SortedList();
        this.topK = new SortedList();
        this.queue = new ArrayDeque<Integer>();
    }

    public void addElement(int num) {
        queue.addLast(num);
        if (smallK.isEmpty() || num <= smallK.getMin()) {
            smallK.add(num);
        } else if (middle.isEmpty() || num <= middle.getMax()) {
            middle.add(num);
        } else {
            topK.add(num);
        }
        if (queue.size() > m) {
            int toBeRemoved = queue.removeFirst();
            if (smallK.contains(toBeRemoved)) {
                smallK.remove(toBeRemoved);
            } else if (middle.contains(toBeRemoved)) {
                middle.remove(toBeRemoved);
            } else {
                topK.remove(toBeRemoved);
            }
        }
        if (smallK.size() > k) {
            middle.add(smallK.removeMax());
        } else if (smallK.size() < k && !middle.isEmpty()){
            smallK.add(middle.removeMin());
        }
        if (middle.size() > m-k-k) {
            topK.add(middle.removeMax());
        } else if (middle.size() < m-k-k && !topK.isEmpty()){
            middle.add(topK.removeMin());
        }
    }

    public int calculateMKAverage() {
        if (smallK.size() + middle.size() + topK.size() < m) {
            return -1;
        }
        return (int) Math.floor((double)middle.sum / middle.size());
    }

    public static void main(String[] args) {
        MKAverage obj = new MKAverage(3, 1);
        obj.addElement(17612);        // current elements are [3]
        obj.addElement(74607);        // current elements are [3,1]
        System.out.println(obj.calculateMKAverage()); // return -1, because m = 3 and only 2 elements exist.
        obj.addElement(8272);       // current elements are [3,1,10]
        // After removing smallest and largest 1 element the container will be [3].
        // The average of [3] equals 3/1 = 3, return 3
        obj.addElement(33433);        // current elements are [3,1,10,5]
        System.out.println(obj.calculateMKAverage());
        obj.addElement(15456);        // current elements are [3,1,10,5]
        obj.addElement(64938);        // current elements are [3,1,10,5,5]
        System.out.println(obj.calculateMKAverage());
        obj.addElement(99741);        // current elements are [3,1,10,5,5,5]
        System.out.println(obj.calculateMKAverage());
    }
}

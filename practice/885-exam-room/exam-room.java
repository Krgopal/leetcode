class ExamRoom {

    ArrayList<Integer> seating;
    int n;
    public ExamRoom(int n) {
        this.n = n;
        seating = new ArrayList<>();
    }
    
    public int seat() {
        if (seating.size() == 0) {
            seating.add(0);
            return 0;
        }
        int distance = Math.max(seating.get(0) - 0 , n -1- seating.get(seating.size() -1));
        for (int i=0; i<seating.size() -1; i++) {
            distance = Math.max(distance, (seating.get(i + 1) - seating.get(i))/ 2);
        }
        if (distance == seating.get(0)) {
            seating.add(0, 0);
            return 0;
        }
        int currDistance = 0;
        for (int i=0; i<seating.size() -1; i++) {
            currDistance = (seating.get(i + 1) - seating.get(i))/ 2;
            if (currDistance == distance) {
                seating.add(i+1, (seating.get(i + 1) + seating.get(i))/ 2);
                return seating.get(i+1);
            }
        }
        seating.add(n-1);
        return n-1;
    }
    
    public void leave(int p) {
        for (int i=0; i<seating.size(); i++) {
            if (seating.get(i) == p) {
                seating.remove(i);
            }
        }
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
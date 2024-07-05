class Solution {
    public int minimumBuckets(String hamsters) {
        if (hamsters.equals("H")) {
            return -1;
        }
        if (hamsters.equals(".")) {
            return 0;
        }
        int n = hamsters.length();
        char[] hamestersArray = hamsters.toCharArray();
        int minBucket = 0;
        for (int i=0; i<hamsters.length(); i++) {
            if (hamestersArray[i] == 'H') {
                if (i <n-1 && hamestersArray[i +1] == '.') {
                    minBucket++;
                    i+=2;
                } else if (i>0 && hamestersArray[i-1] == '.') {
                    minBucket++;
                } else {
                    return -1;
                }
            }
        }
        return minBucket;
    }
}
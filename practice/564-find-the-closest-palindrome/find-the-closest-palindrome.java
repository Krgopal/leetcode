class Solution {
    public String nearestPalindromic(String n) {
        long current = Long.valueOf(n);
        long previousPalindrome = previousPalindrome(String.valueOf(current -1).toCharArray());
        long nextPalindrome = nextPalindrome(String.valueOf(current  + 1).toCharArray());
        return current - previousPalindrome > nextPalindrome - current ? String.valueOf(nextPalindrome) : String.valueOf(previousPalindrome);
    }

    private long nextPalindrome(char[] number) {
        for (int i=0; i<number.length / 2; i++) {
            while (number[i] != number[number.length - 1 -i]) {
                increment(number, number.length - 1 -i);
            }
        }
        return Long.parseLong(new String(number));
    }

    private long previousPalindrome(char[] number) {
        for (int i=0; i<number.length / 2; i++) {
            while (number[i] != number[number.length - 1 -i]) {
                decrement(number, number.length - 1 -i);
                if (number[0] == '0') {
                    return Long.parseLong(new String(number));
                }
            }
        }
        return Long.parseLong(new String(number));
    }

    private void decrement(char[] number, int index) {
        while (number[index] == '0') {
            number[index--] = '9';
        }
        number[index]--;
    }

    private void increment(char[] number, int index) {
        while (number[index] == '9') {
            number[index--] = '0';
        }
        number[index]++;
    }
}
class Solution {
    public int numSteps1(String s) {
        int N = s.length();
        int operations = 0;
        int carry = 0;
        for (int i=N -1; i>0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;
            if (digit % 2 == 1) {
                operations +=2;
                carry = 1;
            } else {
                operations++;
            }
        }
        return operations + carry;
    }

    public int numSteps(String s) {
        int res = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; --i) {
            res++;
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                res++;
            }
        }
        return res + carry;
    }
}
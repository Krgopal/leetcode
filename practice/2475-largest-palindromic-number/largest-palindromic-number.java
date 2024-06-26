class Solution {
    public String largestPalindromic1(String num) {
        while (num.charAt(0) == '0') {
            num = num.substring(1);
        }
        if (num.length() == 0) {
            return "0";
        }
        HashMap<Integer, Integer> freq = new HashMap<>();
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i=0; i<num.length(); i++) {
            int number = Integer.parseInt(String.valueOf(num.charAt(i)));
            freq.put(number, freq.getOrDefault(number, 0) + 1);
            uniqueNumbers.add(number);
        }
        List<Integer> list = new ArrayList<>(uniqueNumbers);
        Collections.sort(list);
        String result = "";
        Integer[] singleNumber = new Integer[num.length()];
        Arrays.fill(singleNumber, -1);
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                singleNumber[index] = entry.getKey();
                index++;
            }
        }
        Arrays.sort(singleNumber, Collections.reverseOrder());
        System.out.println(list.toString());
        System.out.println(singleNumber.toString());
        if (singleNumber[0] != -1) {
            result = String.valueOf(singleNumber[0]);
        }
        index = 0;
        while(index < singleNumber.length && singleNumber[index] != 0) {
            list.remove(singleNumber[index]);
            index++;
        }
        System.out.println(list.toString());
        for (int digit : list) {
            int frequency = freq.get(digit);
            while (frequency > 0) {
                result = String.valueOf(digit) + result + String.valueOf(digit);
                frequency -=2;
            }
        }
        return result;
    }

    public String largestPalindromic(String num) {
        final int[] digitsCount = new int[10];
        for (char ch : num.toCharArray()) {
            digitsCount[ch - '0']++;
        }
        final char[] result = new char[num.length()];
        int resultIndex = 0;
        for (int i=9; i> 0; i--) {
            for (int c=0; c < digitsCount[i] / 2; c++) {
                result[resultIndex] = (char) (i + '0');
                resultIndex++;
            }
        }
        if (resultIndex >0) {
            for (int i=0; i < digitsCount[0]/ 2; i++) {
                result[resultIndex] = '0';
                resultIndex++;
            }
        }
        boolean centralElementAdded = false;
        for (int i=9; i>=0; i--) {
            if (digitsCount[i] %2 == 1) {
                result[resultIndex] = (char) (i + '0');
                resultIndex++;
                centralElementAdded = true;
                break;
            }
        }
        if (resultIndex == 0) return "0";
        for (int i=resultIndex - (centralElementAdded? 2:1); i>=0; i--) {
            result[resultIndex] = result[i];
            resultIndex++;
        }
        return new String(result, 0, resultIndex);
    }
}
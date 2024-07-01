class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        if (n ==0 || logs == null || logs.size() == 0) {
            return result;
        }
        Stack<Integer> stack = new Stack();
        int prevTime = 0;
        for (String log : logs) {
            String[] logPart = log.split(":");
            int currTime= Integer.parseInt(logPart[2]);
            if ("start".equals(logPart[1])) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += currTime - prevTime;
                }
                stack.push(Integer.parseInt(logPart[0]));
                prevTime = currTime;
            } else {
                result[stack.pop()] += currTime - prevTime + 1;
                prevTime = currTime + 1;
            }
        }
        return result;
    }
}
class Solution {
    public List<String> removeComments(String[] source) {
        boolean blockActive = false;
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String line : source) {
            int i=0;
            char[] chars = line.toCharArray();
            if (!blockActive) {
                builder = new StringBuilder();
            }
            while (i<line.length()) {
                if (!blockActive && i +1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    blockActive = true;
                    i++;
                } else if (blockActive && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    blockActive = false;
                    i++;
                } else if (!blockActive && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!blockActive) {
                    builder.append(chars[i]);
                }
                i++;
            }
            if (!blockActive && builder.length() > 0) {
                result.add(new String(builder));
            }
            
        }
        return result;
    }
}
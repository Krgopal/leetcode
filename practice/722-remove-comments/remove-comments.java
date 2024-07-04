class Solution {
    public List<String> removeComments(String[] source) {
        boolean inBlock = false;
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String line :source) {
            if (!inBlock) {
                builder = new StringBuilder();
            }
            char[] chars = line.toCharArray();
            int i=0;
            while (i <line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    builder.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && builder.length() > 0) {
                result.add(builder.toString());
            }
        }
        return result;
    }
}
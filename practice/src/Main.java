import java.util.*;

public class Main {
    public static void main(String[] args) {
//        buildTree();
//        indexof();
//        int[] height = new int[]{1,2,5};
//        System.out.println(coinChange(height, 11));
//        System.out.println(lengthOfLongestSubstring("dvdf"));
//        char[][] input = new char[][] {{'m','b','c','d','e','f','g','h','i','j','k','l'},{'n','a','a','a','a','a','a','a','a','a','a','a'},{'o','a','a','a','a','a','a','a','a','a','a','a'},{'p','a','a','a','a','a','a','a','a','a','a','a'},{'q','a','a','a','a','a','a','a','a','a','a','a'},{'r','a','a','a','a','a','a','a','a','a','a','a'},{'s','a','a','a','a','a','a','a','a','a','a','a'},{'t','a','a','a','a','a','a','a','a','a','a','a'},{'u','a','a','a','a','a','a','a','a','a','a','a'},{'v','a','a','a','a','a','a','a','a','a','a','a'},{'w','a','a','a','a','a','a','a','a','a','a','a'},{'x','y','z','a','a','a','a','a','a','a','a','a'}};
//        String[] words = new String[] {"aaaaaaaaaa","aaaaaaaaab","aaaaaaaaac","aaaaaaaaad","aaaaaaaaae","aaaaaaaaaf","aaaaaaaaag","aaaaaaaaah","aaaaaaaaai","aaaaaaaaaj","aaaaaaaaak","aaaaaaaaal","aaaaaaaaam","aaaaaaaaan","aaaaaaaaao","aaaaaaaaap","aaaaaaaaaq","aaaaaaaaar","aaaaaaaaas","aaaaaaaaat","aaaaaaaaau","aaaaaaaaav","aaaaaaaaaw","aaaaaaaaax","aaaaaaaaay","aaaaaaaaaz","aaaaaaaaba","aaaaaaaabb","aaaaaaaabc","aaaaaaaabd","aaaaaaaabe","aaaaaaaabf","aaaaaaaabg","aaaaaaaabh","aaaaaaaabi","aaaaaaaabj","aaaaaaaabk","aaaaaaaabl","aaaaaaaabm","aaaaaaaabn","aaaaaaaabo","aaaaaaaabp","aaaaaaaabq","aaaaaaaabr","aaaaaaaabs","aaaaaaaabt","aaaaaaaabu","aaaaaaaabv","aaaaaaaabw","aaaaaaaabx","aaaaaaaaby","aaaaaaaabz","aaaaaaaaca","aaaaaaaacb","aaaaaaaacc","aaaaaaaacd","aaaaaaaace","aaaaaaaacf","aaaaaaaacg","aaaaaaaach","aaaaaaaaci","aaaaaaaacj","aaaaaaaack","aaaaaaaacl","aaaaaaaacm","aaaaaaaacn","aaaaaaaaco","aaaaaaaacp","aaaaaaaacq","aaaaaaaacr","aaaaaaaacs","aaaaaaaact","aaaaaaaacu","aaaaaaaacv","aaaaaaaacw","aaaaaaaacx","aaaaaaaacy","aaaaaaaacz","aaaaaaaada","aaaaaaaadb","aaaaaaaadc","aaaaaaaadd","aaaaaaaade","aaaaaaaadf","aaaaaaaadg","aaaaaaaadh","aaaaaaaadi","aaaaaaaadj","aaaaaaaadk","aaaaaaaadl","aaaaaaaadm","aaaaaaaadn","aaaaaaaado","aaaaaaaadp","aaaaaaaadq","aaaaaaaadr","aaaaaaaads","aaaaaaaadt","aaaaaaaadu","aaaaaaaadv","aaaaaaaadw","aaaaaaaadx","aaaaaaaady","aaaaaaaadz","aaaaaaaaea","aaaaaaaaeb","aaaaaaaaec","aaaaaaaaed","aaaaaaaaee","aaaaaaaaef","aaaaaaaaeg","aaaaaaaaeh","aaaaaaaaei","aaaaaaaaej","aaaaaaaaek","aaaaaaaael","aaaaaaaaem","aaaaaaaaen","aaaaaaaaeo","aaaaaaaaep","aaaaaaaaeq","aaaaaaaaer","aaaaaaaaes","aaaaaaaaet","aaaaaaaaeu","aaaaaaaaev","aaaaaaaaew","aaaaaaaaex","aaaaaaaaey","aaaaaaaaez","aaaaaaaafa","aaaaaaaafb","aaaaaaaafc","aaaaaaaafd","aaaaaaaafe","aaaaaaaaff","aaaaaaaafg","aaaaaaaafh","aaaaaaaafi","aaaaaaaafj","aaaaaaaafk","aaaaaaaafl","aaaaaaaafm","aaaaaaaafn","aaaaaaaafo","aaaaaaaafp","aaaaaaaafq","aaaaaaaafr","aaaaaaaafs","aaaaaaaaft","aaaaaaaafu","aaaaaaaafv","aaaaaaaafw","aaaaaaaafx","aaaaaaaafy","aaaaaaaafz","aaaaaaaaga","aaaaaaaagb","aaaaaaaagc","aaaaaaaagd","aaaaaaaage","aaaaaaaagf","aaaaaaaagg","aaaaaaaagh","aaaaaaaagi","aaaaaaaagj","aaaaaaaagk","aaaaaaaagl","aaaaaaaagm","aaaaaaaagn","aaaaaaaago","aaaaaaaagp","aaaaaaaagq","aaaaaaaagr","aaaaaaaags","aaaaaaaagt","aaaaaaaagu","aaaaaaaagv","aaaaaaaagw","aaaaaaaagx","aaaaaaaagy","aaaaaaaagz","aaaaaaaaha","aaaaaaaahb","aaaaaaaahc","aaaaaaaahd","aaaaaaaahe","aaaaaaaahf","aaaaaaaahg","aaaaaaaahh","aaaaaaaahi","aaaaaaaahj","aaaaaaaahk","aaaaaaaahl","aaaaaaaahm","aaaaaaaahn","aaaaaaaaho","aaaaaaaahp","aaaaaaaahq","aaaaaaaahr","aaaaaaaahs","aaaaaaaaht","aaaaaaaahu","aaaaaaaahv","aaaaaaaahw","aaaaaaaahx","aaaaaaaahy","aaaaaaaahz","aaaaaaaaia","aaaaaaaaib","aaaaaaaaic","aaaaaaaaid","aaaaaaaaie","aaaaaaaaif","aaaaaaaaig","aaaaaaaaih","aaaaaaaaii","aaaaaaaaij","aaaaaaaaik","aaaaaaaail","aaaaaaaaim","aaaaaaaain","aaaaaaaaio","aaaaaaaaip","aaaaaaaaiq","aaaaaaaair","aaaaaaaais","aaaaaaaait","aaaaaaaaiu","aaaaaaaaiv","aaaaaaaaiw","aaaaaaaaix","aaaaaaaaiy","aaaaaaaaiz","aaaaaaaaja","aaaaaaaajb","aaaaaaaajc","aaaaaaaajd","aaaaaaaaje","aaaaaaaajf","aaaaaaaajg","aaaaaaaajh","aaaaaaaaji","aaaaaaaajj","aaaaaaaajk","aaaaaaaajl","aaaaaaaajm","aaaaaaaajn","aaaaaaaajo","aaaaaaaajp","aaaaaaaajq","aaaaaaaajr","aaaaaaaajs","aaaaaaaajt","aaaaaaaaju","aaaaaaaajv","aaaaaaaajw","aaaaaaaajx","aaaaaaaajy","aaaaaaaajz","aaaaaaaaka","aaaaaaaakb","aaaaaaaakc","aaaaaaaakd","aaaaaaaake","aaaaaaaakf","aaaaaaaakg","aaaaaaaakh","aaaaaaaaki","aaaaaaaakj","aaaaaaaakk","aaaaaaaakl","aaaaaaaakm","aaaaaaaakn","aaaaaaaako","aaaaaaaakp","aaaaaaaakq","aaaaaaaakr","aaaaaaaaks","aaaaaaaakt","aaaaaaaaku","aaaaaaaakv","aaaaaaaakw","aaaaaaaakx","aaaaaaaaky","aaaaaaaakz","aaaaaaaala","aaaaaaaalb","aaaaaaaalc","aaaaaaaald","aaaaaaaale","aaaaaaaalf","aaaaaaaalg","aaaaaaaalh","aaaaaaaali","aaaaaaaalj","aaaaaaaalk","aaaaaaaall","aaaaaaaalm","aaaaaaaaln","aaaaaaaalo","aaaaaaaalp","aaaaaaaalq","aaaaaaaalr","aaaaaaaals","aaaaaaaalt","aaaaaaaalu","aaaaaaaalv","aaaaaaaalw","aaaaaaaalx","aaaaaaaaly","aaaaaaaalz","aaaaaaaama","aaaaaaaamb","aaaaaaaamc","aaaaaaaamd","aaaaaaaame","aaaaaaaamf","aaaaaaaamg","aaaaaaaamh","aaaaaaaami","aaaaaaaamj","aaaaaaaamk","aaaaaaaaml","aaaaaaaamm","aaaaaaaamn","aaaaaaaamo","aaaaaaaamp","aaaaaaaamq","aaaaaaaamr","aaaaaaaams","aaaaaaaamt","aaaaaaaamu","aaaaaaaamv","aaaaaaaamw","aaaaaaaamx","aaaaaaaamy","aaaaaaaamz","aaaaaaaana","aaaaaaaanb","aaaaaaaanc","aaaaaaaand","aaaaaaaane","aaaaaaaanf","aaaaaaaang","aaaaaaaanh","aaaaaaaani","aaaaaaaanj","aaaaaaaank","aaaaaaaanl","aaaaaaaanm","aaaaaaaann","aaaaaaaano","aaaaaaaanp","aaaaaaaanq","aaaaaaaanr","aaaaaaaans","aaaaaaaant","aaaaaaaanu","aaaaaaaanv","aaaaaaaanw","aaaaaaaanx","aaaaaaaany","aaaaaaaanz","aaaaaaaaoa","aaaaaaaaob","aaaaaaaaoc","aaaaaaaaod","aaaaaaaaoe","aaaaaaaaof","aaaaaaaaog","aaaaaaaaoh","aaaaaaaaoi","aaaaaaaaoj","aaaaaaaaok","aaaaaaaaol","aaaaaaaaom","aaaaaaaaon","aaaaaaaaoo","aaaaaaaaop","aaaaaaaaoq","aaaaaaaaor","aaaaaaaaos","aaaaaaaaot","aaaaaaaaou","aaaaaaaaov","aaaaaaaaow","aaaaaaaaox","aaaaaaaaoy","aaaaaaaaoz","aaaaaaaapa","aaaaaaaapb","aaaaaaaapc","aaaaaaaapd","aaaaaaaape","aaaaaaaapf","aaaaaaaapg","aaaaaaaaph","aaaaaaaapi","aaaaaaaapj","aaaaaaaapk","aaaaaaaapl","aaaaaaaapm","aaaaaaaapn","aaaaaaaapo","aaaaaaaapp","aaaaaaaapq","aaaaaaaapr","aaaaaaaaps","aaaaaaaapt","aaaaaaaapu","aaaaaaaapv","aaaaaaaapw","aaaaaaaapx","aaaaaaaapy","aaaaaaaapz","aaaaaaaaqa","aaaaaaaaqb","aaaaaaaaqc","aaaaaaaaqd","aaaaaaaaqe","aaaaaaaaqf","aaaaaaaaqg","aaaaaaaaqh","aaaaaaaaqi","aaaaaaaaqj","aaaaaaaaqk","aaaaaaaaql","aaaaaaaaqm","aaaaaaaaqn","aaaaaaaaqo","aaaaaaaaqp","aaaaaaaaqq","aaaaaaaaqr","aaaaaaaaqs","aaaaaaaaqt","aaaaaaaaqu","aaaaaaaaqv","aaaaaaaaqw","aaaaaaaaqx","aaaaaaaaqy","aaaaaaaaqz","aaaaaaaara","aaaaaaaarb","aaaaaaaarc","aaaaaaaard","aaaaaaaare","aaaaaaaarf","aaaaaaaarg","aaaaaaaarh","aaaaaaaari","aaaaaaaarj","aaaaaaaark","aaaaaaaarl","aaaaaaaarm","aaaaaaaarn","aaaaaaaaro","aaaaaaaarp","aaaaaaaarq","aaaaaaaarr","aaaaaaaars","aaaaaaaart","aaaaaaaaru","aaaaaaaarv","aaaaaaaarw","aaaaaaaarx","aaaaaaaary","aaaaaaaarz","aaaaaaaasa","aaaaaaaasb","aaaaaaaasc","aaaaaaaasd","aaaaaaaase","aaaaaaaasf","aaaaaaaasg","aaaaaaaash","aaaaaaaasi","aaaaaaaasj","aaaaaaaask","aaaaaaaasl","aaaaaaaasm","aaaaaaaasn","aaaaaaaaso","aaaaaaaasp","aaaaaaaasq","aaaaaaaasr","aaaaaaaass","aaaaaaaast","aaaaaaaasu","aaaaaaaasv","aaaaaaaasw","aaaaaaaasx","aaaaaaaasy","aaaaaaaasz","aaaaaaaata","aaaaaaaatb","aaaaaaaatc","aaaaaaaatd","aaaaaaaate","aaaaaaaatf","aaaaaaaatg","aaaaaaaath","aaaaaaaati","aaaaaaaatj","aaaaaaaatk","aaaaaaaatl","aaaaaaaatm","aaaaaaaatn","aaaaaaaato","aaaaaaaatp","aaaaaaaatq","aaaaaaaatr","aaaaaaaats","aaaaaaaatt","aaaaaaaatu","aaaaaaaatv","aaaaaaaatw","aaaaaaaatx","aaaaaaaaty","aaaaaaaatz","aaaaaaaaua","aaaaaaaaub","aaaaaaaauc","aaaaaaaaud","aaaaaaaaue","aaaaaaaauf","aaaaaaaaug","aaaaaaaauh","aaaaaaaaui","aaaaaaaauj","aaaaaaaauk","aaaaaaaaul","aaaaaaaaum","aaaaaaaaun","aaaaaaaauo","aaaaaaaaup","aaaaaaaauq","aaaaaaaaur","aaaaaaaaus","aaaaaaaaut","aaaaaaaauu","aaaaaaaauv","aaaaaaaauw","aaaaaaaaux","aaaaaaaauy","aaaaaaaauz","aaaaaaaava","aaaaaaaavb","aaaaaaaavc","aaaaaaaavd","aaaaaaaave","aaaaaaaavf","aaaaaaaavg","aaaaaaaavh","aaaaaaaavi","aaaaaaaavj","aaaaaaaavk","aaaaaaaavl","aaaaaaaavm","aaaaaaaavn","aaaaaaaavo","aaaaaaaavp","aaaaaaaavq","aaaaaaaavr","aaaaaaaavs","aaaaaaaavt","aaaaaaaavu","aaaaaaaavv","aaaaaaaavw","aaaaaaaavx","aaaaaaaavy","aaaaaaaavz","aaaaaaaawa","aaaaaaaawb","aaaaaaaawc","aaaaaaaawd","aaaaaaaawe","aaaaaaaawf","aaaaaaaawg","aaaaaaaawh","aaaaaaaawi","aaaaaaaawj","aaaaaaaawk","aaaaaaaawl","aaaaaaaawm","aaaaaaaawn","aaaaaaaawo","aaaaaaaawp","aaaaaaaawq","aaaaaaaawr","aaaaaaaaws","aaaaaaaawt","aaaaaaaawu","aaaaaaaawv","aaaaaaaaww","aaaaaaaawx","aaaaaaaawy","aaaaaaaawz","aaaaaaaaxa","aaaaaaaaxb","aaaaaaaaxc","aaaaaaaaxd","aaaaaaaaxe","aaaaaaaaxf","aaaaaaaaxg","aaaaaaaaxh","aaaaaaaaxi","aaaaaaaaxj","aaaaaaaaxk","aaaaaaaaxl","aaaaaaaaxm","aaaaaaaaxn","aaaaaaaaxo","aaaaaaaaxp","aaaaaaaaxq","aaaaaaaaxr","aaaaaaaaxs","aaaaaaaaxt","aaaaaaaaxu","aaaaaaaaxv","aaaaaaaaxw","aaaaaaaaxx","aaaaaaaaxy","aaaaaaaaxz","aaaaaaaaya","aaaaaaaayb","aaaaaaaayc","aaaaaaaayd","aaaaaaaaye","aaaaaaaayf","aaaaaaaayg","aaaaaaaayh","aaaaaaaayi","aaaaaaaayj","aaaaaaaayk","aaaaaaaayl","aaaaaaaaym","aaaaaaaayn","aaaaaaaayo","aaaaaaaayp","aaaaaaaayq","aaaaaaaayr","aaaaaaaays","aaaaaaaayt","aaaaaaaayu","aaaaaaaayv","aaaaaaaayw","aaaaaaaayx","aaaaaaaayy","aaaaaaaayz","aaaaaaaaza","aaaaaaaazb","aaaaaaaazc","aaaaaaaazd","aaaaaaaaze","aaaaaaaazf","aaaaaaaazg","aaaaaaaazh","aaaaaaaazi","aaaaaaaazj","aaaaaaaazk","aaaaaaaazl","aaaaaaaazm","aaaaaaaazn","aaaaaaaazo","aaaaaaaazp","aaaaaaaazq","aaaaaaaazr","aaaaaaaazs","aaaaaaaazt","aaaaaaaazu","aaaaaaaazv","aaaaaaaazw","aaaaaaaazx","aaaaaaaazy","aaaaaaaazz"};
        trieTesting();
    }

    public static void trieTesting() {
        List<String> list = new ArrayList<String>(5);
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> uniqueChar = new HashSet<>();
        int maxSubstring = 0;
        int currentMax = 0;
        int start = 0;
        int end = s.length();
        int current =0;
        while (current < end) {
            if (uniqueChar.contains(s.charAt(current))) {
                if (maxSubstring < currentMax) {
                    maxSubstring = currentMax;
                }
                while (start < end) {
                    if (s.charAt(start) != s.charAt(current)){
                        uniqueChar.remove(s.charAt(start));
                        maxSubstring--;
                        start++;
                    } else {
                        start++;
                        current++;
                        break;
                    }
                }
            } else {
                uniqueChar.add(s.charAt(current));
                current++;
                maxSubstring++;
            }
        }
        return Math.max(maxSubstring, currentMax);
    }

    public static void indexof() {
        List list = Arrays.asList(new String[] {"A", "B", "C","D"});
        System.out.println(list.indexOf("B"));
    }

    static int preIndex = 0;
    public static TreeNode buildTree(){
        int[] preorder = new int[] {3,9};
        int[] inorder = new int[] {3,9};
        TreeNode ans =  buildTreeRec(preorder, inorder, 0, inorder.length -1);
        return ans;
    }

    public static TreeNode buildTreeRec(int[] preorder, int[] inorder, int inStart, int endStart) {
        if (preIndex >= preorder.length || inStart < 0 || endStart>= preorder.length || inStart > endStart) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIndex++]);
        System.out.println(root.val +  " " +inStart + "  " + endStart);
        if (inStart == endStart) {
            return root;
        }
        int index = -1;
        for (int i=inStart; i<=endStart; i++) {
            if (root.val == inorder[i]) {
                index = i;
            }
        }
        System.out.println(root.val + " " +  index);
        root.left = buildTreeRec(preorder, inorder, inStart, index -1);
        root.right = buildTreeRec(preorder, inorder, index +1, endStart);
        System.out.println(root.val);
        return root;
    }

    public static int maxArea(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = 0;
        for (int i=1; i<height.length; i++) {
            if (height[left[i-1]] >= height[i]) {
                left[i] = left[i-1];
            } else {
                left[i] = i;
            }
            System.out.println(height[left[i]]);
        }
        right[height.length -1] = 0;
        for (int i=height.length-2; i>=0; i--) {
            if (height[right[i+1]] >= height[i]) {
                right[i] = right[i+1];
            } else {
                right[i] = i;
            }
            System.out.println(height[right[i]]);
        }
        int maxWater = 0;
        for (int i=0; i<height.length; i++) {
            int barHeight = Math.max(height[left[i]], height[right[i]]);
            int distance = right[i]-left[i];
            System.out.println(left[i] + "  " + right[i] + " "+ barHeight + "    " + barHeight * distance);
            maxWater = Math.max(barHeight * distance, maxWater);
        }
        return maxWater;

    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 1;
        }
        int[][] dp = new int[coins.length][amount+1];
        for (int i=0; i<coins.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }

        for (int i=0; i<coins.length; i++) {
            for (int t= 1; t<=amount; t++) {
                if (i>0) {
                    dp[i][t] = dp[i - 1][t];
                }
                    if (coins[i] <= t) {
                        if (dp[i][t - coins[i]] != Integer.MAX_VALUE) {
                            dp[i][t] = Math.min(1 + dp[i][t - coins[i]], dp[i][t]);
                        }
                    }
            }
        }
        return dp[coins.length -1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length -1][amount];
    }

    static boolean[][] visited;
    public static int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs1(grid, i,j);
                    System.out.println(i + "    " + j);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    static int[] rowArray= new int[]{-1,0,0,1};
    static int[] columnArray= new int[]{0, -1, 1, 0};
    static public void dfs1(char[][] grid, int row, int column) {
        Queue<String> queue = new LinkedList<>();
        String key = row + "_" + column;
        queue.add(key);
        visited[row][column] = true;
        while(!queue.isEmpty()) {
            String top = queue.remove();
            String[] topArray = top.split("_");
            int currentRow = Integer.valueOf(topArray[0]);
            int currentColumn = Integer.valueOf(topArray[1]);
            for (int i=0; i<rowArray.length; i++) {
                if (isValid(grid, currentRow + rowArray[i], currentColumn + columnArray[i])) {
                    String nextKey = (currentRow + rowArray[i]) + "_" + (currentColumn + columnArray[i]);
                    queue.add(nextKey);
                    visited[currentRow + rowArray[i]][currentColumn + columnArray[i]] = true;
                    System.out.println("visited:    " + nextKey);
                }
            }
        }
    }

    public static boolean isValid(char[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[row].length && grid[row][column] == '1' && !visited[row][column];
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        visited = new boolean[board.length][board[0].length];
        Map<Character, List<String>> charWordMap = new HashMap<>();
        Set<String> wordSet = Set.of(words);
        System.out.println(wordSet.size());
        for (String word : wordSet) {
            List<String> charWords = charWordMap.getOrDefault(word.charAt(0), new ArrayList<>());
            charWords.add(word);
            charWordMap.put(word.charAt(0), charWords);
        }
        for (int i=0; i<board.length;i++) {
            for (int j=0; j<board[i].length; j++) {
                if (charWordMap.containsKey(board[i][j])) {
                    for (String word : charWordMap.get(board[i][j])) {
                        if (dfs(board, word, 0, i, j)) {
                            result.add(word);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static boolean dfs(char[][] board, String word, int index, int row, int column) {
        if (index == word.length()) {
            return true;
        }
        if (row <0 || row >= board.length || column <0 || column >= board[row].length || visited[row][column] || board[row][column] != word.charAt(index)) {
            return false;
        }
        visited[row][column] = true;
        if (dfs(board, word, index+1, row, column -1) ||
                dfs(board, word, index+1, row, column +1) ||
                dfs(board, word, index+1, row -1, column) ||
                dfs(board, word, index+1, row +1, column)) {
            visited[row][column] = false;
            return true;
        }
        visited[row][column] = false;
        return false;
    }

}
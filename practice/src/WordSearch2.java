import java.util.ArrayList;
import java.util.List;

/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.



Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []


Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 12
board[i][j] is a lowercase English letter.
1 <= words.length <= 3 * 104
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
All the strings of words are unique.
 */

public class WordSearch2 {
    char[][] board;
    List<String> result;
    public List<String> findWord(char[][] board, String[] words) {
        this.board = board;
        this.result = new ArrayList<>();
        Tries root = new Tries();
        for (String word : words) {
            Tries node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                } else {
                    Tries childNode = new Tries();
                    node.children.put(letter, childNode);
                    node = childNode;
                }
            }
            node.word = word;
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }
        return this.result;
    }

    public void backtracking(int row, int column, Tries parent) {
        Character letter = this.board[row][column];
        Tries current = parent.children.get(letter);
        if (current.word != null) {
            this.result.add(current.word);
            current.word = null;
        }
        int[] rowIndex = new int[]{1, -1, 0, 0};
        int[] columnIndex = new int[]{0, 0, -1, 1};
        this.board[row][column] = '#';
        for (int i=0; i<rowIndex.length; i++) {
            int nextRow = row + rowIndex[i];
            int nextCol = column + columnIndex[i];
            if (nextRow <0 || nextRow >= this.board.length || nextCol <0 || nextCol >= this.board[row].length) {
                continue;
            }
            if (current.children.containsKey(this.board[nextRow][nextCol])) {
                backtracking(nextRow, nextCol, current);
            }
        }
        current.children.remove(this.board[row][column]);
        this.board[row][column] = letter;
    }

}

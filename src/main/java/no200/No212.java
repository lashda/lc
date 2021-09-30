package no200;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 *
 *
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No212 {
    public static void main(String[] args) {
        /**
         * ["a","b","c"],
         * ["a","e","d"],
         * ["a","f","g"]
         */
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = {"eaabcdgfa"};
        System.out.println(findWords(board,words));
    }
    public static List<String> findWords(char[][] board, String[] words) {
        //0 未寻或已寻未匹配 1  已寻已匹配

        List<String> matchedWord = new ArrayList();
        int m = board.length;
        int n = board[0].length;
        int[][] matchBoard = new int[m][n];
        int flag = 1;
outer:  for (String word : words) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(go( word, 0 ,m,n, board, i, j, matchBoard,flag++)){
                        matchedWord.add(word);
                        continue outer;
                    }
                }
            }
        }
        return matchedWord;
    }


    private static boolean go(String word,int index,int m,int n ,char[][] board,int i,int j,int[][] matchBoard,int flag){
        if(i>=m || i<0 || j>=n || j<0 ){
            return false;
        }

        char c = word.charAt(index);
        if(matchBoard[i][j] == flag || c != board[i][j]){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }

        matchBoard[i][j] = flag;

        if(go(word,index+1,m,n,board,i+1,j,matchBoard,flag)){
            return true;
        }
        if(go(word,index+1,m,n,board,i,j+1,matchBoard,flag)){
            return true;
        }
        if(go(word,index+1,m,n,board,i-1,j,matchBoard,flag)){
            return true;
        }
        if(go(word,index+1,m,n,board,i,j-1,matchBoard,flag)){
            return true;
        }
        matchBoard[i][j] = flag-1;
        return false;
    }
}

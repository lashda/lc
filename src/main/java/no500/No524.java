package no500;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s 和 dictionary[i] 仅由小写英文字母组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No524 {
    public static void main(String[] args) {
        String x = "abce";
        List<String> list = new ArrayList<>();
        list.add("abe");
        list.add("abc");
        System.out.println(findLongestWord(x,list));
    }
    public static String findLongestWord(String s, List<String> dictionary) {
        //排序
        dictionary.sort((o1, o2) -> {
            int comp = o2.length()-o1.length();
            if(comp==0){
              return  o1.compareTo(o2);
            }
            return comp;
        });
        //比较
        int ls = s.length();
        for (String word : dictionary) {
            int i = 0 ,j = 0;
            int lw = word.length();
            while(i<ls&&j<lw){
                if(s.charAt(i)==word.charAt(j)){
                    j++;
                }
                i++;
            }
            if(j==lw){
                return word;
            }
        }
        return "";
    }
}

package no300;

import java.util.*;

/**
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()())()"
 * 输出：["(())()","()()()"]
 * 示例 2：
 *
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 * 示例 3：
 *
 * 输入：s = ")("
 * 输出：[""]
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 25
 * s 由小写英文字母以及括号 '(' 和 ')' 组成
 * s 中至多含 20 个括号
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No301 {
    public static void main(String[] args) {
        No301 n = new No301();
        String s = ")(";
        List<String> strings = n.removeInvalidParentheses(s);
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        Map<Integer,Set<String>> map = new HashMap<>();
        Set set = new HashSet<>();
        set.add(s);
        map.put(0,set);
        List<String> result = new ArrayList<>();
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i)=='('||s.charAt(i)==')'){
                count++;
            }
        }
        if(count==0){
            result.add(s);
            return result;
        }
        for (int i = 0; i <= count; i++) {
            result = getResult(map,i);
            if(result.size()>0){
                return result;
            }
        }
        return result;
    }

    private List<String> getResult(Map<Integer,Set<String>> map,int removeLength){
        List<String> list = new ArrayList<>();
        Set<String> set = map.get(removeLength);
        Set<String> setNext = new HashSet<>();
        for (String s : set) {
            if(valid(s)){
                list.add(s);
            }
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='('||s.charAt(i)==')'){
                    setNext.add(s.substring(0,i)+s.substring(i+1));
                }
            }
        }
        map.put(removeLength+1,setNext);
        return  list;
    }




    private boolean valid(String s){
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i)=='('){
                count ++;
            }
            if(s.charAt(i)==')'){
                count--;
            }
            if(count<0){
                return false;
            }
        }
        return count==0;
    }
}

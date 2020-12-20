package ArraysAndStrings;

import java.util.Stack;

/**
 * @program: Exercises
 * @description: 去除重复字母
 * @author: 宋丽
 * @create: 2020-12-20 20:00
 **/
public class RemoveDuplicateLetters {
    /**
     * 遇到一个新字符 如果比栈顶小 并且在新字符后面还有和栈顶一样的 就把栈顶的字符抛弃了
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length; i++){
            if(stack.contains(ss[i])){
                continue;
            }
            while(!stack.isEmpty() && stack.peek() > ss[i] && s.indexOf(stack.peek(),i) != -1){
                stack.pop();
            }
            stack.push(ss[i]);
        }
        char[] res = new char[stack.size()];
        for(int i = 0 ; i < stack.size() ; i++){
            res[i] = stack.get(i);
        }
        return new String(res);
    }
}

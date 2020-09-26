package Another;

import java.util.*;

/**
 * @program: Exercises
 * @description: 括号是否有效
 * @author: 宋丽
 * @create: 2020-09-26 21:46
 **/
public class bracketIsValid {
    /**
     * 我的解法
     * 用栈，写有点乱，官方给的很清晰
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c:chars
             ) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            if (c == ')' || c == '}' || c == ']'){
                if (stack.size() == 0){
                    return false;
                }
                if (c == map.get(stack.peek())){
                    stack.pop();
                }else {
                    return false;
                }

            }
        }
        return stack.size() == 0;
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean isValid2(String s) {

        int n = s.length();
        //排除多或少括号的现象，节省时间
        if (n % 2 == 1) {
            return false;
        }
        //用map易于扩展
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        //LinkedList实现了Deque（双向队列，同时具有栈和队列性质的数据结构）
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

}

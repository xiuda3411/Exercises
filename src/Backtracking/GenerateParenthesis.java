package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 括号生成
 * @author: 宋丽
 * @create: 2020-10-11 16:06
 **/
public class GenerateParenthesis {
    /**
     * 暴力法
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        write(new char[n*2],0,list);
        return list;
    }

    private void write(char[] chars, int i, List<String> list) {
        if (i == chars.length){
            if (check(chars)){
                list.add(new String(chars));
            }
        }else {
            chars[i] = '(';
            write(chars, i+1, list);
            chars[i] = ')';
            write(chars, i+1, list);
        }
    }

    private boolean check(char[] chars) {
        int count = 0;
        for (char c:chars) {
            if (c == '('){
                count++;
            }else {
                count--;
            }
            if (count < 0){
                return false;
            }
        }
        return count == 0;
    }

    /**
     * 回溯
     * 在迭代的基础上进行剪枝
     * @param n
     * @return
     */
    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        write2(new StringBuilder(),0,0,n,list);
        return list;
    }

    private void write2(StringBuilder stringBuilder,int left,int right,int max, List<String> list) {
        if (max*2 == stringBuilder.length()){
            list.add(stringBuilder.toString());
            return;
        }
        if (left < max){
            stringBuilder.append('(');
            write2(stringBuilder, left+1, right, max, list);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        }
        if (right < left){
            stringBuilder.append(')');
            write2(stringBuilder, left, right+1, max, list);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

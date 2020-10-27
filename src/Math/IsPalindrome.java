package Math;

/**
 * @program: Exercises
 * @description: 回文数
 * @author: 宋丽
 * @create: 2020-10-27 19:03
 **/
public class IsPalindrome {
    /**
     * 我的方法
     * 求出首位数字和末尾数字进行比较
     * 然后改变减去改变
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        //len为位数
        int len = 0;
        int x2 = x;
        while (x2 != 0){
            len++;
            x2 = x2/10;
        }
        while (len > 0){
            int t = (int)Math.pow(10,len - 1);
            int right = x % 10;
            int left = x/t;
            if (right != left){
                return false;
            }
            len -= 2;
            x = (x - left * t) / 10;
        }
        return true;
    }

    /**
     * 翻转一半的数字进行比较
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x){
        //末位为0的非0数或者负数返回false
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int re = 0;
        while (x > re){
            re = re * 10 + (x % 10);
            x = x / 10;
        }
        return x == re || x == re / 10;
    }
}

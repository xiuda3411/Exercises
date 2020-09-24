/**
 * @program: Exercises
 * @description: 罗马数字转整数
 * @author: 宋丽
 * @create: 2020-09-24 21:01
 **/
public class RomanToInt {
    /**
     * 我的解答
     * 转换成字符数组然后用switch case进行判断
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] romans = s.toCharArray();
        int sum = 0;
        for (int i = 0 ; i < romans.length ; i++){
            switch (romans[i]){
                case 'I':if (i < romans.length-1){if (romans[i+1] == 'V'){sum += 3;i++;}else if (romans[i+1] == 'X'){sum += 8;i++;}}sum += 1; break;
                case 'V': sum += 5;continue;
                case 'X':if (i < romans.length-1){if (romans[i+1] == 'L'){sum += 30;i++;}else if (romans[i+1] == 'C'){sum += 80;i++;}}sum += 10;break;
                case 'L': sum += 50;continue;
                case 'C':if (i < romans.length-1){if (romans[i+1] == 'D'){sum += 300;i++;}else if (romans[i+1] == 'M'){sum += 800;i++;}}sum += 100;break;
                case 'D': sum += 500;continue;
                case 'M': sum += 1000;continue;
                default:break;
            }
        }
        return sum;
    }

    /**
     * 更漂亮的解法
     * @param s
     * @return
     */
    public int romanToInt2(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int result = 0;
        for (int i=0; i<s.length(); i++) {
            result += which(s.charAt(i));
        }
        return result;
    }

    public int which(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
        }
        return 0;
    }
}

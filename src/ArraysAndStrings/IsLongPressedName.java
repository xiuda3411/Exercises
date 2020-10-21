package ArraysAndStrings;

/**
 * @program: Exercises
 * @description: 长按键入
 * @author: 宋丽
 * @create: 2020-10-21 12:27
 **/
public class IsLongPressedName {
    /**
     * 双指针
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}

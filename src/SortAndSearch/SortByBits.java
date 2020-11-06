package SortAndSearch;

import java.util.*;

/**
 * @program: Exercises
 * @description: 根据数字二进制下1的数目排序
 * @author: 宋丽
 * @create: 2020-11-06 10:25
 **/
public class SortByBits {
    /**
     * 暴力解法
     * @param arr
     * @return
     */
    public int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }

    /**
     * 权重法
     * @param arr
     * @return
     */
    public int[] sortByBits2(int[] arr) {
        int length = arr.length;

        /*
            根据 1的个数 和 当前数值，存储 每一个数字：
                此处是本题解的精髓：1的个数权值最大，其次是本身的值，方便之后的 还原和排序
         */
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
        }

        /*
            将 存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序

         */
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }

    public int[] sortByBits3(int[] arr) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0;i < arr.length;i ++) {
            array[i] = arr[i];
        }
        /**
         * JDk基本类型int数组不能直接Comparator排序有点迷
         */
        Arrays.sort(array, (o1, o2) -> {
            int c1 = getOneNumber(o1);
            int c2 = getOneNumber(o2);
            if (c1 == c2) {
                return o1 - o2;
            }
            return c1 - c2;
        });

        for (int i = 0;i < arr.length;i ++) {
            arr[i] = array[i];
        }
        return arr;
    }

    public int getOneNumber(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count ++;
            n = n >> 1;
        }
        return count;
    }
}

package Design;

import java.util.*;

/**
 * @program: Exercises
 * @description: O(1)时间插入、删除和获取随机元素-允许重复
 * @author: 宋丽
 * @create: 2020-10-31 17:33
 **/
public class RandomizedCollection {
    /**
     * 我的方法
     */
//    private Map<Integer,Integer> map = null;
//    private static int sum;
//
//    /** Initialize your data structure here. */
//    public RandomizedCollection() {
//        map = new HashMap<>();
//        sum = 0;
//    }
//
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//        sum++;
//        if (map.containsKey(val)){
//            map.put(val,map.get(val) + 1);
//            return false;
//        }else {
//            map.put(val,1);
//            return true;
//        }
//    }
//
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        if (map.containsKey(val)){
//            sum--;
//            if (map.get(val) == 1){
//                map.remove(val);
//            }else{
//                map.put(val,map.get(val) - 1);
//            }
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        int i = (int) (Math.random() * sum);
//        int result = 0;
//        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
//            i = i - entry.getValue();
//            if (i < 0){
//                result = entry.getKey();
//                break;
//            }
//        }
//        return result;
//    }
    /**
     * 官方题解
     */
    Map<Integer, Set<Integer>> idx;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        idx = new HashMap<Integer, Set<Integer>>();
        nums = new ArrayList<Integer>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        nums.add(val);
        Set<Integer> set = idx.getOrDefault(val, new HashSet<Integer>());
        set.add(nums.size() - 1);
        idx.put(val, set);
        return set.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!idx.containsKey(val)) {
            return false;
        }
        Iterator<Integer> it = idx.get(val).iterator();
        int i = it.next();
        int lastNum = nums.get(nums.size() - 1);
        nums.set(i, lastNum);
        idx.get(val).remove(i);
        idx.get(lastNum).remove(nums.size() - 1);
        if (i < nums.size() - 1) {
            idx.get(lastNum).add(i);
        }
        if (idx.get(val).size() == 0) {
            idx.remove(val);
        }
        nums.remove(nums.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int) (Math.random() * nums.size()));
    }
}

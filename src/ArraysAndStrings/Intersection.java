package ArraysAndStrings;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: Exercises
 * @description: 两个数组的交集
 * @author: 宋丽
 * @create: 2020-11-02 10:19
 **/
public class Intersection {
    /**
     * 我的方法
     * 排序+双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int head1 = 0;
        int head2 = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(head1 = 0 ; head1 < nums1.length ; head1++){
            if(head2 >= nums2.length){
                break;
            }
            while(head1 < nums1.length-1 && nums1[head1] < nums2[head2]){
                head1++;
            }
            while(head2 < nums2.length-1 && nums1[head1] > nums2[head2]){
                head2++;
            }
            if(nums1[head1] == nums2[head2]){
                res.add(nums1[head1]);
                while(head2 < nums2.length && nums1[head1] == nums2[head2]){
                    head2++;
                }
            }
        }
        int[] arr = new int[res.size()];
        int j = 0;
        for (int i: res) {
            arr[j] = i;
            j++;
        }
        return arr;
    }

    /**
     * 官方给的排序+双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                // 保证加入元素的唯一性
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
    /**
     * 哈希表
     * 主要学一下Java方法的调用
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> num2=Arrays.stream(nums2).boxed().collect(Collectors.toList());
        Set<Integer> cross=new HashSet<Integer>();
        for(int i=0;i<nums1.length;i++){
            if(num2.contains(nums1[i])){
                cross.add(nums1[i]);
            }
        }
        int[] arr = cross.stream().mapToInt(Integer::valueOf).toArray();
        return arr;
    }
}

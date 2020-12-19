package ForOffer;

/**
 * @program: Exercises
 * @description: 用户喜好
 * @author: 宋丽
 * @create: 2020-12-08 20:30
 **/

/**
 * 链接：https://www.nowcoder.com/questionTerminal/66b68750cf63406ca1db25d4ad6febbf
 * 来源：牛客网
 *
 * 输入描述:
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，
 * 第i个代表用户标号为i的用户对某类文章的喜好度
 * 第3行为一个正整数q代表查询的组数
 * 第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，
 * 即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。
 * 数据范围n <= 300000,q<=300000 k是整型
 *
 * 输出描述:
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 */
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
//        int[] fav = new int[n];
        Map<Integer,List<Integer>> fav = new HashMap<>();
        for(int i = 1 ; i <= n ; i++){
            int like = scan.nextInt();
//            if(!fav.containsKey(like)){
//                //List<Integer> list = new ArrayList<>();
            List<Integer> list = fav.getOrDefault(like,new ArrayList<>());
            list.add(i);
            fav.put(like,list);
//            }else{
//                List<Integer> list = fav.get(like);
//                list.add(i);
//                fav.put(like,list);
//            }

            //fav[i] = scan.nextInt();
        }
        int row = scan.nextInt();
        int[] res = new int[row];
        for(int j = 0 ; j < row ; j++){
            int left = scan.nextInt();
            int right = scan.nextInt();
            int target = scan.nextInt();
            int count = 0;
            List<Integer> list = fav.getOrDefault(target,new ArrayList<>());
            for(int i : list){
                if(i >= left && i <= right){
                    count++;
                }
            }
            res[j] = count;
        }
//            for(int i = left ; i < right ; i++){
//                if(fav[i - 1] == target){
//                    count++;
//                }
//            }
//            res[j] = count;
//        }
        for(int i : res){
            System.out.println(i);
        }
    }
}

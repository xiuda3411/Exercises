package Random;

/**
 * @program: Exercises
 * @description: 用rand7()实现rand10()
 * @author: 宋丽
 * @create: 2020-12-10 20:03
 **/
public class Rand10 {
    public int rand10() {
        while(true){
            int n = (rand7()-1) * 7 + rand7();
            if(n <= 40){
                return 1 + (n - 1) % 10;
            }
        }
    }

    private static int rand7() {
        return (int) (Math.random() * 7 + 1);
    }
//    public static void main(String[] args){
//        int[] n = new int[8];
//        for(int i = 0 ; i < 1000000 ; i++){
//            int r = rand7();
//            n[r]++;
//            System.out.println(r);
//        }
//        for(int i : n){
//            System.out.println(i);
//        }
//    }
}

package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Exercises
 * @description: 设计有序流
 * @author: 宋丽
 * @create: 2020-11-15 10:41
 **/
public class OrderedStream {
    private int ptr;
    private String[] res;

    public OrderedStream(int n) {
        ptr = 0;
        res = new String[n + 1];
    }

    public List<String> insert(int id, String value) {
        List<String> list = new ArrayList<>();
        res[id-1] = value;
        while(ptr < res.length && res[ptr] != null){
            list.add(res[ptr]);
            ptr++;
        }
        //System.out.println(ptr);
        return list;
    }
}
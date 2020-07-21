package cn.java.day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class zuoyeti {
    public static void main(String[] args) {
        int array[] = new int[1000];
        // 随机生成1000个0-100的数字
        for (int i = 0; i < array.length; i++) {
            Random m = new Random();
            array[i] = m.nextInt(101);
        }
        int count = 0;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // 分别统计0-9这10个数字的出现次数，并把数字和出现的次数存放在map中。
        while (i <=100) {
            count = 0;
            for (int j = 0; j < array.length; j++) {
                if (i == array[j]) {
                    count = count + 1;
                }
            }
            map.put(i, count);
            i++;
        }
        ArrayList<Map.Entry<Integer, Integer>> entries = sortMap(map); // 得到处理后的结果
        // 打印出出现次数最多的前3个数字
        for (int j = 0; j < 100; j++) {
            System.out.println(entries.get(j).getKey() + "出现"
                    + entries.get(j).getValue() + "次");
        }

    }

    /**
     * 通过重写Collections的sort方法，该方法可以使HashMap按照value进行降序排列。
     *
     * @param map
     * @return
     */
    public static ArrayList<Map.Entry<Integer, Integer>> sortMap(
            Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(
                map.entrySet());
        Collections.sort(entries,
                new Comparator<Map.Entry<Integer, Integer>>() {
                    public int compare(Map.Entry<Integer, Integer> entry1,
                                       Map.Entry<Integer, Integer> entry2) {
                        return entry2.getValue() - entry1.getValue();
                    }
                });
        return (ArrayList<Entry<Integer, Integer>>) entries;
    }
}

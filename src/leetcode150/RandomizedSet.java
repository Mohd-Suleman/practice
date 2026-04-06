package leetcode150;

import java.util.*;

public class RandomizedSet {

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(10);
        set.insert(20);
        set.insert(30);
        set.insert(40);

        System.out.println("Map: "+set.map);
        System.out.println("List: "+set.list);

        set.remove(20);

        System.out.println("After");
        System.out.println("Map: "+set.map);
        System.out.println("List: "+set.list);

        System.out.println(set.getRandom());
    }
    private Map<Integer, Integer> map;
    private List<Integer> list;


    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int item) {
        boolean flag = false;
        if(!map.containsKey(item)) {
            list.add(item);
            map.put(item, list.size()-1);
            flag = true;
        }
        return flag;
    }

    public boolean remove(int item) {
        int index = map.get(item);
        boolean flag = false;
        if(index < 0 )
            return false;
        else if(index == list.size()-1) {
            list.remove(index);
            map.remove(item, index);
            flag = true;
        } else {
            int lastElement = list.get(list.size()-1);
            list.set(index, lastElement);
            list.remove(list.size()-1);
            map.remove(item, index);
            map.put(lastElement, index);
            flag = true;
        }
        return flag;
    }

    public int getRandom() {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }



}

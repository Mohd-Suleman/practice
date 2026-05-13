package leetcode150.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public static void main(String[] args) {
        int num1 = 4;
        int[][] pre1 = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(findOrder(num1, pre1));

        int num2 = 2;
        int[][] pre2 = {{0,1},{1,0}};

        System.out.println(findOrder(num2, pre2));
    }

    public static List<Integer> findOrder(int num, int[][] pres) {
        List<Integer>[] adjList = new List[num];
        int[] inDegree = new int[num];
        for(int i=0; i<adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int[] pre: pres) {
            int src = pre[1];
            int des = pre[0];
            adjList[src].add(des);
            inDegree[des]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int j=0; j<inDegree.length; j++) {
            if(inDegree[j] == 0)
                queue.offer(j);
        }

        List<Integer> order = new ArrayList<>();

        while(!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order.add(currentCourse);

            for(int nextCourse: adjList[currentCourse]) {
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0)
                    queue.offer(nextCourse);
            }
        }
        if(order.size() == num)
            return order;
        return new ArrayList<>();

    }
}

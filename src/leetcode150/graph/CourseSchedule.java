package leetcode150.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int num1 = 5;
        int[][] pre1 = {{0,2},{1,2},{1,3},{2,4},{3,4}};

        System.out.println(canFinish(num1, pre1));

        int num2 = 2;
        int[][] pre2 = {{0,1},{1,0}};

        System.out.println(canFinish(num2, pre2));
    }

    public static boolean canFinish(int num, int[][] prerequisites) {
        List<Integer>[] graph = new List[num];
        int[] outDegree = new int[num];

        for(int i=0; i<num; i++)
            graph[i] = new ArrayList<>();

        for(int[] pre: prerequisites) {
            int src = pre[0];
            int des = pre[1];
            graph[des].add(src);
            outDegree[src]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int k=0; k<outDegree.length; k++) {
            if(outDegree[k]==0)
                queue.offer(k);
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int nextCourse: graph[course]) {
                outDegree[nextCourse]--;
                if(outDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return count == num;
    }
}

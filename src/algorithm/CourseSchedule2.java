package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
    	int[] order = new int[numCourses];
    	int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];

	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //duplicate case
	        matrix[pre][ready] = 1;
	    }

	    int count = 0;
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
//	        order[i] = i;
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        order[count] = course;
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--indegree[i] == 0)
	                {
	                    queue.offer(i);
//	                    order[i] = i;
	                }
	            }
	        }
	    }
	    System.err.println(count);
	    return count == numCourses ? order : new int[0];
    }
    
    public int[] findOrder2(int numCourses, int[][] prerequisites) 
    {
    	int[] order  = new int[numCourses];
    	List<List<Integer>> posts = new ArrayList<List<Integer>>();  
        for (int i = 0; i < numCourses; i++) {  
            posts.add(new ArrayList<Integer>());  
        }  
          
        int[] preNums = new int[numCourses];  
        for (int i = 0; i < prerequisites.length; i++) {  
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);  
            preNums[prerequisites[i][0]]++;  
        }  
          
        Queue<Integer> queue = new LinkedList<Integer>();  
        for (int i = 0; i < numCourses; i++) {  
            if (preNums[i] == 0){  
                queue.offer(i);  
//                order[i] = i;
            }  
        }  
          
        int count = 0;  
        while (!queue.isEmpty()) {  
            int cur = queue.poll();  
            order[count] = cur;
            for (int i : posts.get(cur)) {  
                if (--preNums[i] == 0) {  
                    queue.offer(i);  
//                    order[i] = i;
                }  
            }  
            count++;  
        }  
        System.out.println(count);
        return count == numCourses ? order : new int[0];  
    }
    
    public static void main(String[] args)
    {
    	int numCourses = 4;
    	int[][] prerequisites = {
    			{0,1},
    			{1,2},
    			{2,3},
    			{1,0}
    	};
    	CourseSchedule2 main = new CourseSchedule2();
    	int[] order = main.findOrder2(numCourses, prerequisites);
    	for (int i = 0; i < order.length; i++)
    	{
    		System.out.print(order[i]+" ");
    	}
    }
}

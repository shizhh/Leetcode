package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule
{

	public boolean canFinish(int numCourses, int[][] prerequisites)
	{
		
		Map<Integer, Set<Integer>> map = new HashMap<>(numCourses);
		int m = prerequisites.length;
		for (int i = 0; i < m; i++)
		{
			int course1 = prerequisites[i][1];
			int course2 = prerequisites[i][0];
			if (map.containsKey(course1))
			{
				map.get(course1).add(course2);
			}
			else
			{
				Set<Integer> list = new HashSet<>();
				list.add(course2);
				map.put(course1, list);
			}
		}
		
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < numCourses; i++)
		{
		    if (!map.containsKey(i))    continue;
			Set<Integer> list = map.get(i);
			for (int course : list)
				inDegree[course]++;
		}
		
		for (int i = 0; i < numCourses; i++)
		{
			int j = 0;
			for (; j < numCourses; j++)
				if (inDegree[j] == 0)	break;
			
			if (j == numCourses) return false;
			
			inDegree[j] = -1;
			if (!map.containsKey(j))    continue;
			Set<Integer> list = map.get(j);
			for (int course : list)
				inDegree[course]--;
		}
		return true;
	}
	
	public boolean canFinish2(int numCourses, int[][] prerequisites) {  
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
            }  
        }  
          
        int count = numCourses;  
        while (!queue.isEmpty()) {  
            int cur = queue.poll();  
            for (int i : posts.get(cur)) {  
                if (--preNums[i] == 0) {  
                    queue.offer(i);  
                }  
            }  
            count--;  
        }  
          
        return count == 0;  
    }
	
	public boolean canFinish3(int numCourses, int[][] prerequisites) 
	{
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
	    Queue<Integer> queue = new LinkedList();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--indegree[i] == 0)
	                    queue.offer(i);
	            }
	        }
	    }
	    return count == numCourses;
	}
	
	
}

package list;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class list_2 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<HashMap<String, Integer>> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
        	HashMap<String, Integer> map = new HashMap<>();
        	map.put("progress", progresses[i]);
        	map.put("speed", speeds[i]);
        	q.add(map);
        }
        
        while (!q.isEmpty()) {
        	for (HashMap<String, Integer> temp : q) {
        		int tProgress = temp.get("progress");
        		int tSpeed = temp.get("speed");
        		tProgress = tProgress + tSpeed;
        		
        		temp.put("progress", tProgress);
        	}
        	
        	int push = 0;
        	while (q.peek().get("progress") >= 100) {
        		HashMap<String, Integer> resultMap = q.poll();
        		System.out.println(resultMap.toString());
        		push++;
        	}
        	
        	System.out.println(push);
        	System.out.println(q.toString());
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
    	int[] progresses = new int[3];
    	int[] speeds = new int[3];
    	solution(progresses, speeds);
	}
}

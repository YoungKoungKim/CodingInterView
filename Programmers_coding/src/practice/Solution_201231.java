package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution_201231 {
    public static int[] solution(int[] numbers) {
        HashSet<Integer> hash = new HashSet<>();
        
        for (int i = 0; i < numbers.length-1; i++) {
        	for (int j = i + 1; j < numbers.length; j++) {
        		int sum = numbers[i] + numbers[j];
        		hash.add(sum);
        	}
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i : hash) {
        	list.add(i);
        }
        
        list.sort(null);
        
        int[] answer = new int[list.size()];
        
        for (int j = 0; j < list.size(); j++) {
        	answer[j] = list.get(j);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
		int[] numbers = {2, 1, 3, 4, 1};
    	
    	solution(numbers);
	}
}
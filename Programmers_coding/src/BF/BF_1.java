package BF;
import java.util.*;

class BF_1 {
	public int[] solution(int[] answers) {
		int[] answer = {};

		int[] person1 = { 1, 2, 3, 4, 5 };
		int[] person2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		ArrayList<Integer> list = new ArrayList<>();

		int[] result = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == person1[i % person1.length]) {
				result[0]++;
			}
			if (answers[i] == person2[i % person2.length]) {
				result[1]++;
			}
			if (answers[i] == person3[i % person3.length]) {
				result[2]++;
			}
		}
		
		int max = result[0];
		if (max < result[1]) {
			max = result[1];
		}
		if (max < result[2]) {
			max = result[2];
		}

		for (int i = 0; i < result.length; i++) {
			if (max == result[i]) {
				list.add(i + 1);
			}
		}
		
		list.sort(null);
		
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		BF_1 l = new BF_1();
		
		int[] result = l.solution(new int[] {1, 2, 3, 4, 5});
		
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}

package hash;

public class hash_2 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] phone_book = {"6", "119123456", "2"};
		System.out.println(sol.solution(phone_book));
	}
}

class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = i+1; j < phone_book.length; j++) {
				if (phone_book[j].startsWith(phone_book[i])) {
					answer = false;
					break;
				}
			}
			if (!answer) break;
		}
		
		return answer;
	}
}
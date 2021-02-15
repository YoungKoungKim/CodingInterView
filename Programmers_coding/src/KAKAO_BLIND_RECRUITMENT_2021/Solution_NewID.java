package KAKAO_BLIND_RECRUITMENT_2021;
import java.util.regex.Pattern;

public class Solution_NewID {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("=.="));
	}
}

class Solution {
	public String solution(String new_id) {
		String answer = "";
		
		//1. 대문자 -> 소문자 치환
		new_id = new_id.toLowerCase();
		
		//2. 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거
		new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
		
		//System.out.println(new_id);
		
		//3. 마침표 두번 연속을 한번으로 치환(.. -> .)
		//new_id = new_id.replaceAll("(.)\\1+", ".");
		new_id = new_id.replaceAll("[.]{2,}", ".");
		
		//System.out.println(new_id);
		
		//System.out.println(new_id.indexOf("."));
		//4. 마침표가 처음이나 끝에 위치하면 제거
		if (new_id.indexOf(".") == 0) {
			new_id = new_id.replaceFirst("^.", "");
		}
		if (new_id.length() > 0) {
			if (new_id.indexOf(".") == new_id.length()-1) {
				new_id = new_id.substring(0, new_id.length()-1);
			}
		}
		
		//System.out.println(new_id);
		
		//5. 빈 문자열의 경우 a를 대입
		if (new_id.length() == 0) {
			new_id = "a";
		}
		//System.out.println(new_id);
		
		//6. 16자 이상이면  15자로 자른 후 마침표 제거
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		//System.out.println(new_id);
		if (new_id.indexOf(".") == new_id.length()-1) {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		//7. new_id의 길이가 2자 이하면 마지막 문자를 길이가 3이 될 때까지 반복
		while (new_id.length() <= 2) {
			String last = String.valueOf(new_id.charAt(new_id.length()-1));
			new_id = new_id.concat(last);
		}
		
		answer = new_id;
		
		return answer;
	}
}
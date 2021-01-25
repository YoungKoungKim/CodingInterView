package KAKAO_BLIND_RECRUITMENT_2018;

public class Solution_SecretMap {
    public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 16;
		int[] arr1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int[] arr2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		sol.solution(n, arr1, arr2);
	}
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String format = "%0" + n + "d";
        
        for (int i = 0; i < n; i++) {
        	String binaryString1 = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i]).toString()));
        	String binaryString2 = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i]).toString()));
        	
        	answer[i] = "";
        	for (int j = 0; j < n; j++) {
        		if (binaryString1.charAt(j) == '1' || binaryString2.charAt(j) == '1') {
        			answer[i] = answer[i].concat("#");
        		} else {
        			answer[i] = answer[i].concat(" ");
        		}
        	}
        }
        return answer;
    }
}
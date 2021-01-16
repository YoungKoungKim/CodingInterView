package practice;

class Solution_210115 {
    public String solution(String[] seoul) {
        String answer = "";
        String location = "";
        
        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                location = String.valueOf(i);
                break;
            }
        }
        
        answer = "김서방은 " + location + "에 있다";
        
        return answer;
    }
}

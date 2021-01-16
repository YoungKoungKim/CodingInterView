package practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a, b);
        
        System.out.println(cal.get(Calendar.DAY_OF_WEEK));
        
        return answer;
    }
}
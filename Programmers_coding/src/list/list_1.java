
import java.util.*;
    class list_1 {
        public int[] solution(int[] answers) {
            int[] answer = new int[3];

            int[] person1 = {1, 2, 3, 4, 5};
            int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            ArrayList<Integer> list = new ArrayList<>();

            int result1 = 0;
            int result2 = 0;
            int result3 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (answers[i] == person1[i] % person1.length) {
                    result1++;
                }
                if (answers[i] == person2[i] % person2.length) {
                    result2++;
                }
                if (answers[i] == person3[i] % person3.length) {
                    result3++;
                }
            }

            list.add(result1);
            list.add(result2);
            list.add(result3);

            list.sort(null);
            
            for (int i = 0; i < 3; i++) {
                if (list.get(i) != 0) answer[i] = list.get(i);
            }

            return answer;
        }
    }

import java.util.*;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Queue<Integer> q = new LinkedList<>();
        for (int s : students) {
            q.offer(s);
        }
        int index = 0;
        int count = 0; 
        while (!q.isEmpty() && count < q.size()) {
            if (q.peek() == sandwiches[index]) {
                q.poll();
                index++;
                count = 0; 
            } else {
                q.offer(q.poll());
                count++;
            }
        }
        return q.size();
    }
}
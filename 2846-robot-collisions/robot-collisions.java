import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>(Arrays.asList(positions[i], healths[i], i)));
        }

        Collections.sort(list, (a, b) -> a.get(0) - b.get(0));

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty()) {
                int top = st.peek();
                char dir1 = directions.charAt(list.get(top).get(2));
                char dir2 = directions.charAt(list.get(i).get(2));
                if (dir1 == 'R' && dir2 == 'L') {

                    int h1 = list.get(top).get(1);
                    int h2 = list.get(i).get(1);

                    if (h1 > h2) {
                        list.get(top).set(1, h1 - 1);
                        list.get(i).set(1, 0);
                        break;
                    } else if (h1 < h2) {
                        list.get(i).set(1, h2 - 1);
                        list.get(top).set(1, 0);
                        st.pop(); 
                    } else {
                        list.get(top).set(1, 0);
                        list.get(i).set(1, 0);
                        st.pop();
                        break;
                    }

                } else {
                    break;
                }
            }

            if (list.get(i).get(1) > 0) {
                st.push(i);
            }
        }

        List<int[]> survivors = new ArrayList<>();

        while (!st.isEmpty()) {
            int idx = st.pop();
            survivors.add(new int[]{
                list.get(idx).get(2),
                list.get(idx).get(1)  
            });
        }

        Collections.sort(survivors, (a, b) -> a[0] - b[0]);

        List<Integer> ans = new ArrayList<>();
        for (int[] s : survivors) {
            ans.add(s[1]);
        }

        return ans;
    }
}
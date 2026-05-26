class Solution {
    public int numberOfSpecialChars(String word) {
        int[] arr = {
            65,66,67,68,69,70,71,72,73,74,75,76,77,
            78,79,80,81,82,83,84,85,86,87,88,89,90
        };

        int c = 0;

        for (int i = 0; i < 26; i++) {
            char ch1 = (char) arr[i];        
            char ch2 = (char) (arr[i] + 32); 

            if (word.contains(String.valueOf(ch1)) &&
                word.contains(String.valueOf(ch2))) {
                c++;
            }
        }

        return c;
    }
}
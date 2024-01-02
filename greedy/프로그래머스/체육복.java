class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n+1];
        int answer = n;
        
        for (int l : lost) {
            student[l]--;
        }
        for(int r : reserve) {
            student[r]++;
        }
        
        for(int i=1; i<=n; i++) {
            if (student[i] == -1) {
                if (student[i-1] == 1) {
                    student[i] = student[i-1] = 0;
                } else if (i+1 <= n && student[i+1] == 1) {
                    student[i] = student[i+1] = 0;
                } else {
                    answer--;
                }
            }
        }
        
        return answer;
    }
}

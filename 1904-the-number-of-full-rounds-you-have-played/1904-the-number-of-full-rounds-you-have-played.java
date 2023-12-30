public class Solution {
    public int numberOfRounds(String loginTime, String logoutTime) {
        int start = convert(loginTime);
        int end = convert(logoutTime);
        
        if (start > end) {
            return numberOfRounds(loginTime, "24:00") + numberOfRounds("00:00", logoutTime);
        }
        
        int round_start = 0;
        int round_end = 24 * 60;
        
        int count = 0;
        
        while (round_start <= round_end) {
            if (start <= round_start && round_start <= end && 
                start <= round_start + 15 && round_start + 15 <= end) {
                count++;
            }
            
            round_start += 15;
        }
        
        return count;
    }
    
    private int convert(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int mins = Integer.parseInt(parts[1]);
        return hour * 60 + mins;
    }
}
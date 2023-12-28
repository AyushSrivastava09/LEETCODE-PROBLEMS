class Solution {
    public boolean canConvertString(String s, String t, int k) {
        // Edge case: if the length of the two strings are not equal, return false
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = (t.charAt(i) - s.charAt(i) + 26) % 26;
        }
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            if (diff[i] == 0) continue;
            if (count[diff[i]] * 26 + diff[i] > k) return false;
            count[diff[i]]++;
        }
        return true;
    }
}
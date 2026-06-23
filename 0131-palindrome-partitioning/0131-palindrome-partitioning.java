class Solution {
    public List<List<String>> partition(String s) {
     List<List<String>> res = new ArrayList<>();
        // Temporary list to store current partition
        List<String> path = new ArrayList<>();
        // Start the depth-first search from index 0
        dfs(0, s, path, res);
        return res;
    }

    private void dfs(int index, String s, List<String> path, List<List<String>> res) {
        // If the index reaches the end of the string
        if (index == s.length()) {
            // Add the current partition to the result
            res.add(new ArrayList<>(path));
            return;
        }
        // Iterate over the substring starting from 'index'
        for (int i = index; i < s.length(); i++) {
            // Check if the substring s[index..i] is a palindrome
            if (isPalindrome(s, index, i)) {
                // If true, add it to the current path
                path.add(s.substring(index, i + 1));
                // Recur for the remaining substring
                dfs(i + 1, s, path, res);
                // Backtrack: remove the last added substring
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        // Check if the substring s[start..end] is a palindrome
        while (start <= end) {
            // If characters do not match, it's not a palindrome
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true; // Otherwise, it's a palindrome
    }
}
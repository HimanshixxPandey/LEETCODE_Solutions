class Solution {
    private  String[] map;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
        return ans;

        map = new String[]{
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        helper(digits, ans, 0, "");

        return ans;
    }

    public void helper(String digits, List<String> ans,
                    int index, String current) {

        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String s = map[digits.charAt(index) - '0'];

        for (int i = 0; i < s.length(); i++) {
            helper(digits, ans, index + 1,
                current + s.charAt(i));
        }
    }
}
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                List<Integer> leftValues =
                    diffWaysToCompute(left);
                List<Integer> rightValues =
                    diffWaysToCompute(right);
                for (int a : leftValues) {
                    for (int b : rightValues) {
                        if (ch == '+')
                            ans.add(a + b);
                        else if (ch == '-')
                            ans.add(a - b);
                        else
                            ans.add(a * b);
                    }
                }
            }
        }
        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}
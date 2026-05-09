class Solution {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        Stack<Integer> parenthesis = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                parenthesis.push(i);
            } else if(ch == '*') {
                star.push(i);
            } else {
                if(parenthesis.isEmpty() && star.isEmpty()) {
                    return false;
                }
                if(!parenthesis.isEmpty()) {
                    parenthesis.pop();
                } else {
                    star.pop();
                }
            }
        }

        while(!parenthesis.isEmpty() && !star.isEmpty()) {
            if(star.pop() < parenthesis.pop()) {
                return false;
            }
        }
        return parenthesis.isEmpty();
    }
}

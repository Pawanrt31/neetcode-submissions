class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> operands = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        for(String token: tokens) {
            if(operators.contains(token)) {
                int secondOperand = operands.pop();
                int firstOperand = operands.pop();
                int result = 0;
                switch(token) {
                    case "+": result = firstOperand + secondOperand;
                                break;
                    case "-": result = firstOperand - secondOperand;
                                break;
                    case "*": result = firstOperand * secondOperand;
                                break;
                    case "/": result = firstOperand / secondOperand;
                                break;
                    default: break;
                }
                operands.push(result);
            } else {
                operands.push(Integer.parseInt(token));
            }
        }
        return operands.peek();
    }
}

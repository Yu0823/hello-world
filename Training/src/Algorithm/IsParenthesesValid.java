package Algorithm;

import java.util.Stack;

public class IsParenthesesValid {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] text = s.toCharArray();
        for(int i = 0; i < text.length; i++){
            if(text[i] == '(')
                stack.push('(');
            else if(text[i] == '[')
                stack.push('[');
            else if(text[i] == '{')
                stack.push('{');
            else if(text[i] == ')'){
                if(stack.isEmpty() || (char)stack.pop() != '(')
                    return false;
            }
            else if(text[i] == ']'){
                if(stack.isEmpty() || (char)stack.pop() != '[')
                return false;
            }
            else if(text[i] == '}'){
                if(stack.isEmpty() || (char)stack.pop() != '{')
                    return false;
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsParenthesesValid().isValid("{}"));
    }
}
